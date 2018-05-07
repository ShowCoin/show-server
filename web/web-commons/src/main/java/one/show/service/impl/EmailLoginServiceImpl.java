
package one.show.service.impl;

import one.show.common.Constant;
import one.show.common.MD5;
import one.show.common.Constant.THIRD_DATA_TYPE;
import one.show.common.exception.ReturnException;
import one.show.common.exception.ServiceException;
import one.show.service.LoginService;
import one.show.service.UserService;
import one.show.struc.LoginParam;

import one.show.user.thrift.view.ThirdDataView;
import one.show.user.thrift.view.UserView;

/**
 * @author Haliaeetus leucocephalus  2016年5月28日 上午12:23:01
 *
 * 
 */

public class EmailLoginServiceImpl extends LoginService {

	@Override
	public UserView login(LoginParam loginParam, UserService userService) throws ReturnException, ServiceException{
		if (loginParam.getEmail() == null || loginParam.getPwd() == null) {
			throw new ReturnException("1000");
		}

		ThirdDataView thirdDataView = userService.findThirdDataByTidAndType(
				loginParam.getEmail(), THIRD_DATA_TYPE.T_EMAIL.getTypeName());

		if (thirdDataView == null) {
			throw new ReturnException("2004");
		}
		
		if(userService.userIsForbidden(thirdDataView.getUid(), Constant.USER_AUTH_FORBID.LOGIN.getIndex())){
			throw new ReturnException("5007");
		}

		if (!thirdDataView.token.equals(MD5.md5(loginParam.getPwd()))) {
			throw new ReturnException("2003");
		}
		UserView userView = userService.findUserById(thirdDataView.getUid());
		userView.setIsNew(0);
		return userView;
	
	}

}


