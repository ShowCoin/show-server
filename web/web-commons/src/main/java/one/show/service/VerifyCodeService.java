package one.show.service;

import java.util.Date;

import one.show.common.TimeUtil;
import one.show.common.client.redis.JedisUtil;
import one.show.common.exception.ReturnException;

import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Haliaeetus leucocephalus on 18/1/17.
 */
public abstract class VerifyCodeService {

    private static final Logger log = LoggerFactory.getLogger(VerifyCodeService.class);


    private final String format;

    public VerifyCodeService() {
        format = "verify-code:period-limit:%s:%s:%s";
    }

    protected abstract String _sendVerifyCode(String templateId, String phoneNumber, String[] params);

    public void sendVerifyCode(String phoneNumber, String type) throws ReturnException {
    	String dayLimitKey = "DayLimit:"+TimeUtil.getDayOfMonth(new Date())+":"+phoneNumber;
    	String dayLimitvalue = (String) JedisUtil.get(dayLimitKey);
    	if(dayLimitvalue!=null&& Integer.parseInt(dayLimitvalue)>=3){
    		throw new ReturnException("11003");
    	}
    	
        String periodLimitKey = "TimeLimit:" + type + ":" + phoneNumber;
        String periodLimitValue = (String) JedisUtil.get(periodLimitKey);
        String verifyCode;
        String statusCode = "000000";
        if (periodLimitValue == null || !periodLimitValue.equals("1")) {
            verifyCode = RandomStringUtils.random(4, false, true).toString();
            String key = String.format(format, type, phoneNumber, verifyCode);
            // 5分钟有效期
            JedisUtil.set(key, "1" , 300);
            // 1分钟内只能发一次
            JedisUtil.set(periodLimitKey , "1" , 60);
            log.warn("key="+key+",verifyCode="+verifyCode+",phoneNumber="+phoneNumber);
        }
        else {
            throw new ReturnException("11004");
        }
        String templateId = null;
        if (type.equals("reg")) {
            templateId = "93977";
        }
        else if (type.equals("bind")) {
            templateId = "93980";
        }
        else if (type.equals("forget")) {
            templateId = "93979";
        }else if (type.equals("extract_bind")) {
            templateId = "104524";
        }
        else {
            throw new ReturnException("1002");
        }
        statusCode = _sendVerifyCode(templateId,phoneNumber, new String[]{verifyCode,"5"});
        if(! statusCode.equals("000000")){
            if (statusCode.equals("111111")) {
                log.error("云通讯错误：超过限制,一分钟300个请求的并发");
            }
            else if (statusCode.equals("160021")) {
                log.error("云通讯错误：每天限定给同一手机号只能发送1条内容相同的短信");
            }
            else if (statusCode.equals("160021")) {
                log.error("云通讯错误：每天限定给同一手机号只能发送1条内容相同的短信");
            }
            else if (statusCode.equals("112314")) {
                log.error("云通讯错误：每天限定给同一手机号只能发送10条内容不同的短信");
                throw new ReturnException("11003");
            }
            throw new ReturnException("0");
        }else{
        	int value = 1;
        	if(dayLimitvalue!=null){
        		value = Integer.parseInt(dayLimitvalue)+1;
        	}
        	JedisUtil.set(dayLimitKey, value+"", 60*60*24);
        }
    }

    /**
     *
     * @param phoneNumber
     * @param type
     * @param verifyCode
     * @return 1表示验证码正确，其它表示不正确
     * @throws ReturnException
     */
    public String getVerifyCode(String phoneNumber, String type, String verifyCode) throws ReturnException {
        String key;
        key = String.format(format, type, phoneNumber, verifyCode);
        String periodLimitValue = (String) JedisUtil.get(key);
        return periodLimitValue;
    }

    private String generateVerifyCode(String phoneNumber, String type) throws ReturnException {
        // 每日请求不超过三次
        String dayLimitKey = String.format("verify-code:day-limit:%s:%s", type, phoneNumber);
        long dayLimitValue = JedisUtil.increase(dayLimitKey);
        if (dayLimitValue > 3) {
            throw new ReturnException("2018");
        }
        else if (dayLimitValue == 1){
            JedisUtil.expire(dayLimitKey, TimeUtil.getSecondsTillMidnight());
        }

        return RandomStringUtils.random(4, false, true);
    }

    public static void clear(String phoneNumber, String type) {
        String dayLimitKey = String.format("verify-code:day-limit:%s:%s", type, phoneNumber);
        JedisUtil.delete(dayLimitKey);
    }

	public void sendNoticeMsg(String type, long phoneNumber, String[] params) {
		int templateId = 0;
		switch (type) {
		case "extract_apply":
			templateId = 108080;
			break;
//		case "extract_refuse":
//			templateId = 104543;
//			break;
//		case "extract_fail":
//			templateId = 106263;
//			break;
//		case "extract_success":
//			templateId = 104562;
//			break;
		default:
			break;
		}
		if(templateId!=0){
			_sendVerifyCode(templateId+"", phoneNumber+"", params);
		}
	}

}
