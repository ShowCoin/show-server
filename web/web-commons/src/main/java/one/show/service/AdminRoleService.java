/**
 * 
 */
package one.show.service;

import java.util.List;

import one.show.common.Constant.ADMIN_STATUS;
import one.show.common.exception.ServiceException;

import one.show.manage.thrift.view.AdminRoleFuncView;
import one.show.manage.thrift.view.AdminRoleListView;
import one.show.manage.thrift.view.AdminRoleView;

/**
 * @author Norman711 2015年8月22日 下午9:04:13
 *
 */
public interface AdminRoleService {

	/**
	 * 根据id获取角色
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public AdminRoleView getRoleById(Integer id) throws ServiceException;
	
	/**
	 * 保存角色
	 * @param adminRoleView
	 * @throws ServiceException
	 */
	public void save(AdminRoleView adminRoleView) throws ServiceException;
	
	/**
	 * 保存角色
	 * @param adminRoleView
	 * @throws ServiceException
	 */
	public void update(AdminRoleView adminRoleView) throws ServiceException;
	
	/**
	 * 删除角色
	 * @param roleId
	 * @throws ServiceException
	 */
	public void delete(Integer roleId) throws ServiceException;
	
	/**
	 * 获取指定角色的功能列表
	 * @param roleId
	 * @return
	 * @throws ServiceException
	 */
	public List<AdminRoleFuncView> getFuncListByRoleId(Integer roleId) throws ServiceException;
	
	/**
	 * 获取角色列表
	 * @param status
	 * @param start
	 * @param count
	 * @return
	 * @throws ServiceException
	 */
	public AdminRoleListView getRoleList(ADMIN_STATUS status, Integer start, Integer count) throws ServiceException;
	
	
}


