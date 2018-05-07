
package one.show.service.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import one.show.common.Constant;
import one.show.common.Constant.THIRD_DATA_TYPE;
import one.show.common.exception.ReturnException;
import one.show.common.exception.ServiceException;
import one.show.service.LoginService;
import one.show.service.ThirdpartyService;
import one.show.service.UserService;
import one.show.struc.LoginParam;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import one.show.user.thrift.view.ThirdBindView;
import one.show.user.thrift.view.ThirdDataView;
import one.show.user.thrift.view.UserView;

/**
 * @author Haliaeetus leucocephalus  2016年5月28日 上午12:23:46
 *
 * 
 */

public class ThirdPartyLoginServiceImpl extends LoginService {
	
	private static final Logger log = LoggerFactory.getLogger(ThirdPartyLoginServiceImpl.class);

	@Override
	public UserView login(LoginParam loginParam, UserService userService) throws ReturnException, ServiceException{

		if (StringUtils.isBlank(loginParam.getThirdId())) {
			throw new ReturnException("1000");
		}else if (StringUtils.isBlank(loginParam.getThirdToken())) {
			throw new ReturnException("1000");
		}
		
		THIRD_DATA_TYPE third_data_type = THIRD_DATA_TYPE.valueOf("T_"
				+ loginParam.getThirdType().toUpperCase());

		if (!Arrays.asList(THIRD_DATA_TYPE.T_SINA, THIRD_DATA_TYPE.T_WEIXIN,
				THIRD_DATA_TYPE.T_QQ).contains(third_data_type)) {
			throw new ReturnException("2022");
		}
		
		//微信登陆，处理之前错误的usid
		if (third_data_type == THIRD_DATA_TYPE.T_WEIXIN && loginParam.getWxUsId() != null){
			ThirdDataView wxUsThirdDataView = userService.findThirdDataByTidAndType(
					loginParam.getWxUsId(), loginParam.getThirdType());
			if (wxUsThirdDataView != null){

				ThirdDataView thirdDataView = userService.findThirdDataByTidAndType(
						loginParam.getThirdId(), loginParam.getThirdType());
				
				if (thirdDataView == null){
					thirdDataView = new ThirdDataView();
					thirdDataView.setType(loginParam.getThirdType());
					thirdDataView.setToken(loginParam.getThirdToken());
					thirdDataView.setTid(loginParam.getThirdId());
					thirdDataView.setUid(wxUsThirdDataView.getUid());
					thirdDataView.setCreateTime((int) (System.currentTimeMillis() / 1000));
					userService.saveThirdData(thirdDataView);
					
					userService.deleteThirdData(wxUsThirdDataView.getTid(), wxUsThirdDataView.getType());
					
					Map<String,String> map = new HashMap<String,String>(); 
					map.put("tid", thirdDataView.getTid());
					userService.updateThirdBind(wxUsThirdDataView.getUid(), thirdDataView.getType(), map);
				}
				
				
			}
		}
		
		ThirdDataView thirdDataView = userService.findThirdDataByTidAndType(
				loginParam.getThirdId(), loginParam.getThirdType());

		if (thirdDataView == null) {
			//激活用户
			thirdDataView = new ThirdDataView();
			thirdDataView.setType(loginParam.getThirdType());
			thirdDataView.setToken(loginParam.getThirdToken());
			thirdDataView.setTid(loginParam.getThirdId());

			UserView userView = new UserView();
			if (StringUtils.isNotBlank(loginParam.getThirdNickname())) {
				userView.setNickname(loginParam.getThirdNickname());
			}
			if (StringUtils.isNotBlank(loginParam.getThirdHeadimage())) {
				
				userView.setProfileImg(loginParam.getThirdHeadimage());
			}
			if (StringUtils.isNotBlank(loginParam.getThirdUserdesc())) {
				userView.setDescription(loginParam.getThirdUserdesc());
			}
			if (loginParam.getThirdSex() != null && (loginParam.getThirdSex() == 0 || loginParam.getThirdSex() == 1)) {
				userView.setGender(loginParam.getThirdSex());
			}
			
			if (StringUtils.isBlank(userView.getNickname())) {
				// grab user info
				ThirdpartyService thirdpartyService = null;
				switch (third_data_type) {
				case T_QQ:
					thirdpartyService = new QQServiceImpl();
					break;
				case T_WEIXIN:
					thirdpartyService = new WeixinServiceImpl();
					break;
				case T_SINA:
					thirdpartyService = new WeiboServiceImpl();
					break;
				default:
					assert 1 == 0;
				}
				userView = thirdpartyService.getUserInfo(loginParam.getThirdId() ,loginParam.getThirdToken());
				
			}
			
			userView.setCity(loginParam.getCity());
			userService.registerUser(userView, thirdDataView);
			userView.setIsNew(1);
			return userView;
			
		} else {
			//登陆
			if(userService.userIsForbidden(thirdDataView.getUid(), Constant.USER_AUTH_FORBID.LOGIN.getIndex())){
				throw new ReturnException("5007");
			}else{
				log.info("thirddata.uid="+thirdDataView.getUid()+",thirddata.tid="+thirdDataView.getTid()+",type="+thirdDataView.getType());
				UserView userView = userService.findUserById(thirdDataView.getUid());
				//异常数据，删除垃圾数据
				if (userView == null){
            		
            		//删除三方登陆和绑定表
            		List<ThirdBindView> thirdBindList = userService.findThirdBindByUid(thirdDataView.getUid());
            		if (thirdBindList != null){
            			for(ThirdBindView thirdBindView : thirdBindList){
                    		userService.deleteThirdBind(thirdDataView.getUid(), thirdBindView.getType());
                    		userService.deleteThirdData(thirdBindView.getTid(), thirdBindView.getType());
            			}
            		}
            		throw new ReturnException("2033");
				}else{
					userView.setIsNew(0);
				}
				
				return userView;
			}
			
		}

	}

}


