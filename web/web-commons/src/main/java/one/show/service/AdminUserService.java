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

	/**
	 * 获取管理员
	 * @param userName
	 * @return
	 * @throws ServiceException
	 */
	public AdminUserView getUser(String userName) throws ServiceException;
	
	/**
	 * 更新管理员
	 * @param au
	 * @throws ServiceException
	 */
	public void updateUser(AdminUserView au) throws ServiceException;

	/**
	 * 修改管理员密码
	 * @param userName
	 * @param password
	 * @throws ServiceException
	 */
	public void updateUserPwd(String userName, String password) throws ServiceException;
	
	/**
	 * 获取用户的角色列表
	 * @param userName
	 * @return
	 * @throws ServiceException
	 */
	public List<AdminUserRoleView> getUserRole(String userName) throws ServiceException;
	
	/**
	 * 添加管理员
	 * @param au
	 * @throws ServiceException
	 */
	public void addUser(AdminUserView au) throws ServiceException;
	
	/**
	 * 获取管理员列表
	 * @param status
	 * @param start
	 * @param count
	 * @return
	 * @throws ServiceException
	 */
	public AdminUserListView getUserList(ADMIN_STATUS status, int start, int count) throws ServiceException; 
	
	/**
	 * 删除后台用户
	 * @param userName
	 * @throws ServiceException
	 */
	public void delelteUser(String userName) throws ServiceException;
}


