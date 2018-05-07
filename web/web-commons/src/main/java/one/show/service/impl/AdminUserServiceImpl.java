/**
 * 
 */
package one.show.service.impl;

import java.util.List;

import one.show.common.Constant.ADMIN_STATUS;
import one.show.common.exception.ServiceException;
import one.show.service.AdminUserService;

import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import one.show.manage.thrift.iface.AdminSystemServiceProxy;
import one.show.manage.thrift.view.AdminUserListView;
import one.show.manage.thrift.view.AdminUserRoleView;
import one.show.manage.thrift.view.AdminUserView;

/**
 * @author Norman711 2015年8月24日 下午10:05:00
 *
 */
@Component
public class AdminUserServiceImpl implements AdminUserService {

	@Autowired
	private AdminSystemServiceProxy.Iface adminSystemServiceClientProxy;

	/* (non-Javadoc)
	 * @see one.show.service.AdminUserService#getUser(java.lang.String)
	 */
	@Override
	public AdminUserView getUser(String userName) throws ServiceException {

		try {
			return adminSystemServiceClientProxy.findUser(userName);
		} catch (TException e) {
			throw new ServiceException(e);
		}
	}

	/* (non-Javadoc)
	 * @see one.show.service.AdminUserService#getUserRole(java.lang.String)
	 */
	@Override
	public List<AdminUserRoleView> getUserRole(String userName)
			throws ServiceException {
		try {
			return adminSystemServiceClientProxy.findUserRole(userName);
		} catch (TException e) {
			throw new ServiceException(e);
		}
	}

	/* (non-Javadoc)
	 * @see one.show.service.AdminUserService#updateUser(one.show.manage.thrift.view.AdminUserView)
	 */
	@Override
	public void updateUser(AdminUserView au) throws ServiceException {
		// TODO Auto-generated method stub
		try {
			adminSystemServiceClientProxy.updateUser(au);
		} catch (TException e) {
			throw new ServiceException(e);
		}
		
	}

	/* (non-Javadoc)
	 * @see one.show.service.AdminUserService#addUser(one.show.manage.thrift.view.AdminUserView, java.lang.Integer[])
	 */
	@Override
	public void addUser(AdminUserView au)
			throws ServiceException {

		try {
			adminSystemServiceClientProxy.saveUser(au);
		} catch (TException e) {
			throw new ServiceException(e);
		}
		
	}



	/* (non-Javadoc)
	 * @see one.show.service.AdminUserService#getUserList(one.show.common.Constant.ADMIN_STATUS, int, int)
	 */
	@Override
	public AdminUserListView getUserList(ADMIN_STATUS status, int start,
			int count) throws ServiceException {
		
		try {
			return adminSystemServiceClientProxy.findUserList(status == null?-1:status.ordinal(), start, count);
		} catch (TException e) {
			throw new ServiceException(e);
		}
		
	}

	/* (non-Javadoc)
	 * @see one.show.service.AdminUserService#delelteUser(java.lang.String)
	 */
	@Override
	public void delelteUser(String userName) throws ServiceException {

		try {
			adminSystemServiceClientProxy.deleteUser(userName);
		} catch (TException e) {
			throw new ServiceException(e);
		}
	}

	/* (non-Javadoc)
	 * @see one.show.service.AdminUserService#updateUserPwd(java.lang.String, java.lang.String)
	 */
	@Override
	public void updateUserPwd(String userName, String password)
			throws ServiceException {
		try {
			adminSystemServiceClientProxy.updatePwd(userName, password);
		} catch (TException e) {
			throw new ServiceException(e);
		}
		
	}

}


