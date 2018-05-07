package one.show.interceptor;


import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import one.show.common.Constant.USER_AGENT;
import one.show.common.TypeUtil;
import one.show.common.local.HeaderParams;
import one.show.common.local.XThreadLocal;
import one.show.common.security.Sign;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Haliaeetus leucocephalus on 18-2-22.
 * 验证签名
 */
public class SecurityInterceptor implements HandlerInterceptor {

    private static final Logger log = LoggerFactory.getLogger(SecurityInterceptor.class);
    
    private static final String SECRET = "secret";
    
    private static final String HEADER_MAC = "MAC";
    private static final String HEADER_IM = "IM";
    private static final String HEADER_IDFA = "IDFA";
    private static final String HEADER_IDFY = "IDFY";
    //终端运营商  1移动  2联通  3电信
    private static final String HEADER_OP = "OP";
    //终端所处国家
    private static final String HEADER_CO = "CO";
    //屏幕分辨率
    private static final String HEADER_SC = "SC";
    //应用版本名
    private static final String HEADER_VN = "VN";
    //扩展字段
    private static final String HEADER_TAG = "TAG";
    
    private static final String HEADER_USERID = "User-Id";
    private static final String HEADER_TOKEN = "User-Token";
    //操作系统名称
    private static final String HEADER_OS = "OS";
    //操作系统版本
    private static final String HEADER_KERNAL_VERSION = "Kernel-Version";
    //应用版本号
    private static final String HEADER_APP_VERSION = "App-Version";
    //经度
    private static final String HEADER_LONGITUDE = "Longitude";
    //纬度
    private static final String HEADER_LATITUDE = "Latitude";
    private static final String HEADER_CITY = "City";
    private static final String HEADER_DEVICE_UUID = "Device-Uuid";
    private static final String HEADER_DEVICE_NAME = "Device-Name";
    //手机类型
    private static final String HEADER_PHONE_TYPE = "Phone-Type";
    private static final String HEADER_PHONE_NUMBER = "Phone-Number";
    private static final String HEADER_PUSH_ID = "Push-Id";
    private static final String HEADER_CHANNEL = "Channel";
    //网络类型
    private static final String HEADER_NET_TYPE = "Net-Type";
    
    private static final String SIGN = "Sign";
    private static final String TIME = "Time";
    
    
    public static Set<String> noSignUri = new HashSet<String>();
    static{
    	noSignUri.add("/uploadAvatar");
    	noSignUri.add("/callback/cdn1/record");
    	noSignUri.add("/callback/cdn1/concat_notify");
    	noSignUri.add("/alipay_callback");
    	noSignUri.add("/wx_Callback");
    	noSignUri.add("/wx_app_callback");
    	noSignUri.add("/stat/action");
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{

    	USER_AGENT userAgent = XThreadLocal.getInstance().getUserAgent();
        
    	
        HeaderParams headerParams = new HeaderParams();
        headerParams.setUid(request.getHeader(HEADER_USERID));
        headerParams.setOs(request.getHeader(HEADER_OS));
        headerParams.setKernelVersion(request.getHeader(HEADER_KERNAL_VERSION));
        headerParams.setAppVersion(request.getHeader(HEADER_APP_VERSION));
        
        headerParams.setLongitude(request.getHeader(HEADER_LONGITUDE));
        headerParams.setLatitude(request.getHeader(HEADER_LATITUDE));
        headerParams.setCity(request.getHeader(HEADER_CITY));
        
        headerParams.setDeviceId(request.getHeader(HEADER_DEVICE_UUID));
        headerParams.setDeviceName(request.getHeader(HEADER_DEVICE_NAME));
        
        headerParams.setPhoneType(request.getHeader(HEADER_PHONE_TYPE));
        headerParams.setPhoneNum(request.getHeader(HEADER_PHONE_NUMBER));
        headerParams.setChannel(request.getHeader(HEADER_CHANNEL));
        headerParams.setPushId(request.getHeader(HEADER_PUSH_ID));
        headerParams.setNetType(request.getHeader(HEADER_NET_TYPE));
        
        headerParams.setMac(request.getHeader(HEADER_MAC));
        headerParams.setIm(request.getHeader(HEADER_IM));
        headerParams.setIdfa(request.getHeader(HEADER_IDFA));
        headerParams.setIdfv(request.getHeader(HEADER_IDFY));
        headerParams.setOp(request.getHeader(HEADER_OP));
        headerParams.setCo(request.getHeader(HEADER_CO));
        headerParams.setSc(request.getHeader(HEADER_SC));
        headerParams.setVn(request.getHeader(HEADER_VN));
        headerParams.setTag(request.getHeader(HEADER_TAG));
        
        XThreadLocal.getInstance().setHeaderParams(headerParams);
        
        if (noSignUri.contains(request.getRequestURI())){
        	return true;
        }
        
        //验证签名
        Map<String, String> params = new HashMap<String, String>();
        
        Enumeration<String> em = request.getParameterNames();

        while (em.hasMoreElements()) {
            String name = em.nextElement();
            params.put(name, request.getParameter(name));
        }
        
        
        params.put(HEADER_USERID, request.getHeader(HEADER_USERID));
        params.put(HEADER_TOKEN, request.getHeader(HEADER_TOKEN));
        
        params.put(HEADER_OS, request.getHeader(HEADER_OS));
        params.put(HEADER_KERNAL_VERSION, request.getHeader(HEADER_KERNAL_VERSION));
        params.put(HEADER_APP_VERSION, request.getHeader(HEADER_APP_VERSION));
        
        params.put(HEADER_LONGITUDE, request.getHeader(HEADER_LONGITUDE));
        params.put(HEADER_LATITUDE, request.getHeader(HEADER_LATITUDE));
        params.put(HEADER_CITY, request.getHeader(HEADER_CITY));
        
        
        params.put(HEADER_DEVICE_UUID, request.getHeader(HEADER_DEVICE_UUID));
        params.put(HEADER_DEVICE_NAME, request.getHeader(HEADER_DEVICE_NAME));
        
        params.put(HEADER_PHONE_TYPE, request.getHeader(HEADER_PHONE_TYPE));
        params.put(HEADER_PHONE_NUMBER, request.getHeader(HEADER_PHONE_NUMBER));
       
        params.put(HEADER_PUSH_ID, request.getHeader(HEADER_PUSH_ID));
        params.put(HEADER_CHANNEL, request.getHeader(HEADER_CHANNEL));
        params.put(HEADER_NET_TYPE, request.getHeader(HEADER_NET_TYPE));
        
        params.put(HEADER_MAC, request.getHeader(HEADER_MAC));
        params.put(HEADER_IM, request.getHeader(HEADER_IM));
        params.put(HEADER_IDFA, request.getHeader(HEADER_IDFA));
        params.put(HEADER_IDFY, request.getHeader(HEADER_IDFY));
        params.put(HEADER_OP, request.getHeader(HEADER_OP));
        params.put(HEADER_CO, request.getHeader(HEADER_CO));
        params.put(HEADER_SC, request.getHeader(HEADER_SC));
        params.put(HEADER_VN, request.getHeader(HEADER_VN));
        params.put(HEADER_TAG, request.getHeader(HEADER_TAG));
        
        
        
        params.put(TIME, request.getHeader(TIME));
        
        
        String uri = request.getRequestURI();
        String sign = request.getHeader(SIGN);
        Integer time = null;
        
        try{
        	time = Integer.parseInt(request.getHeader(TIME));
        }catch(Exception e){
        	
        }
        
        
        
        boolean signFlag = true;
        
        
        if (!signFlag){
        	return true;
        }
        
        //验证签名
        if (sign == null || time == null){
        	log.error(uri+"  缺少签名参数["+userAgent+"],sign="+sign+", time="+time);
        	throw new SecurityException("11002");
        }
        
        int now = (int)(System.currentTimeMillis()/1000);
        //签名过期　
        if (Math.abs(now - time) > 5*60){
        	log.error(uri+"  签名已过期["+userAgent+"]");
        	throw new SecurityException("11005");
        }
        
        String mySign = Sign.getSignature(params, SECRET, userAgent);
        if (!mySign.equals(sign)){
        	log.error(uri+"  签名错误["+userAgent+"], mySign="+mySign+", sign="+sign);
			throw new SecurityException("11002");
		}

        log.info(uri + " ["+userAgent+"], sign ok ");
        
        return true;

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    

    }
    

}
