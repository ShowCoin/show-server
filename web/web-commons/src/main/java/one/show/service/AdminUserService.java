/**
 * 
 */
package one.show.service;

import java.util.List;

import one.show.common.Constant.ADMIN_STATUS;
import one.show.common.exception.ServiceException;

import one.show.manage.thrift.view.AdminUserListView;
import one.show.manage.thrift.view.AdminUserRoleView;
import one.show.manage.thrift.view.AdminUserView;

/**
 * @author Norman711 2015年8月22日 下午9:04:13
 *
 */
public interface AdminUserService {

	
	public AdminUserView getUser(String userName) throws ServiceException;
	
	public void updateUser(AdminUserView au) throws ServiceException;

	public void updateUserPwd(String userName, String password) throws ServiceException;
	
	public List<AdminUserRoleView> getUserRole(String userName) throws ServiceException;
	
	public void addUser(AdminUserView au) throws ServiceException;
	
	
	public AdminUserListView getUserList(ADMIN_STATUS status, int start, int count) throws ServiceException; 
	
	public void delelteUser(String userName) throws ServiceException;
}


