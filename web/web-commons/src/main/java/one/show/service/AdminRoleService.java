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

	
	public AdminRoleView getRoleById(Integer id) throws ServiceException;
	
	public void save(AdminRoleView adminRoleView) throws ServiceException;
	
	public void update(AdminRoleView adminRoleView) throws ServiceException;
	
	public void delete(Integer roleId) throws ServiceException;
	
	public List<AdminRoleFuncView> getFuncListByRoleId(Integer roleId) throws ServiceException;
	
	public AdminRoleListView getRoleList(ADMIN_STATUS status, Integer start, Integer count) throws ServiceException;
	
	
}


