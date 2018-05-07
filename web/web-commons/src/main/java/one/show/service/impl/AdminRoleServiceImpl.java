/**
 * 
 */
package one.show.service.impl;

import java.util.List;

import one.show.common.Constant.ADMIN_STATUS;
import one.show.common.exception.ServiceException;
import one.show.service.AdminRoleService;

import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import one.show.manage.thrift.iface.AdminSystemServiceProxy;
import one.show.manage.thrift.view.AdminRoleFuncView;
import one.show.manage.thrift.view.AdminRoleListView;
import one.show.manage.thrift.view.AdminRoleView;

/**
 * @author Norman711 2015年8月24日 下午10:04:37
 *
 */
@Component
public class AdminRoleServiceImpl implements AdminRoleService {
	
	@Autowired
	private AdminSystemServiceProxy.Iface adminSystemServiceClientProxy;

	/* (non-Javadoc)
	 * @see one.show.service.AdminRoleService#getRoleById(java.lang.Integer)
	 */
	@Override
	public AdminRoleView getRoleById(Integer id) throws ServiceException {
		try {
			return adminSystemServiceClientProxy.findRoleById(id);
		} catch (TException e) {
			throw new ServiceException(e);
		}
	}

	/* (non-Javadoc)
	 * @see one.show.service.AdminRoleService#getFuncListByRoleId(java.lang.Integer)
	 */
	@Override
	public List<AdminRoleFuncView> getFuncListByRoleId(Integer roleId)
			throws ServiceException {
		try {
			return adminSystemServiceClientProxy.findFuncListByRoleId(roleId);
		} catch (TException e) {
			throw new ServiceException(e);
		}
	}

	/* (non-Javadoc)
	 * @see one.show.service.AdminRoleService#getRoleList(one.show.common.Constant.ADMIN_STATUS)
	 */
	@Override
	public AdminRoleListView getRoleList(ADMIN_STATUS status, Integer start, Integer count)
			throws ServiceException {

		try {
			return adminSystemServiceClientProxy.findRoleList(status==null?-1:status.ordinal(), start, count);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
		
	}

	/* (non-Javadoc)
	 * @see one.show.service.AdminRoleService#save(one.show.manage.thrift.view.AdminRoleView)
	 */
	@Override
	public void save(AdminRoleView adminRoleView) throws ServiceException {

		try {
			adminSystemServiceClientProxy.saveRole(adminRoleView);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}

	/* (non-Javadoc)
	 * @see one.show.service.AdminRoleService#update(one.show.manage.thrift.view.AdminRoleView)
	 */
	@Override
	public void update(AdminRoleView adminRoleView) throws ServiceException {

		try {
			adminSystemServiceClientProxy.updateRole(adminRoleView);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}

	/* (non-Javadoc)
	 * @see one.show.service.AdminRoleService#delete(java.lang.Integer)
	 */
	@Override
	public void delete(Integer roleId) throws ServiceException {

		try {
			adminSystemServiceClientProxy.deleteRole(roleId);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}

}


