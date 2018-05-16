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
	 * 根据角色ID获得角色信息
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public AdminRoleView getRoleById(Integer id) throws ServiceException;
	
	/**
	 * 保存角色信息
	 * @param adminRoleView
	 * @throws ServiceException
	 */
	public void save(AdminRoleView adminRoleView) throws ServiceException;
	
	/**
	 * 更新角色信息
	 * @param adminRoleView
	 * @throws ServiceException
	 */
	public void update(AdminRoleView adminRoleView) throws ServiceException;
	
	/**
	 * 删除角色信息
	 * @param roleId
	 * @throws ServiceException
	 */
	public void delete(Integer roleId) throws ServiceException;
	
	/**
	 * 根据角色ID获得角色权限
	 * @param roleId
	 * @return
	 * @throws ServiceException
	 */
	public List<AdminRoleFuncView> getFuncListByRoleId(Integer roleId) throws ServiceException;
	
	/**
	 * 根据状态获得角色列表信息
	 * @param status
	 * @param start
	 * @param count
	 * @return
	 * @throws ServiceException
	 */
	public AdminRoleListView getRoleList(ADMIN_STATUS status, Integer start, Integer count) throws ServiceException;
	
	
}


