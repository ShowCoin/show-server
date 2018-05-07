/**
 * 
 */
package one.show.service.impl;

import java.util.List;

import one.show.common.Constant.ADMIN_STATUS;
import one.show.common.exception.ServiceException;
import one.show.service.AdminFuncService;

import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import one.show.manage.thrift.iface.AdminSystemServiceProxy;
import one.show.manage.thrift.view.AdminFuncView;

/**
 * @author Norman711 2015年8月22日 下午9:04:36
 *
 */

@Component
public class AdminFuncServiceImpl implements AdminFuncService {

	@Autowired
	private AdminSystemServiceProxy.Iface adminSystemServiceClientProxy;
	
	/* (non-Javadoc)
	 * @see one.show.service.AdminFuncService#getFuncList(one.show.common.Constant.ADMIN_STATUS)
	 */
	@Override
	public List<AdminFuncView> getFuncList(ADMIN_STATUS status)
			throws ServiceException {
		
		try {
			return adminSystemServiceClientProxy.findFuncList(status==null?-1:status.ordinal());
		} catch (TException e) {
			throw new ServiceException(e);
		}
	}

	/* (non-Javadoc)
	 * @see one.show.service.AdminFuncService#getFuncById(java.lang.String)
	 */
	@Override
	public AdminFuncView getFuncById(String funcId) throws ServiceException {
		try {
			return adminSystemServiceClientProxy.findFuncById(funcId);
		} catch (TException e) {
			throw new ServiceException(e);
		}
	}

	/* (non-Javadoc)
	 * @see one.show.service.AdminFuncService#save(one.show.manage.thrift.view.AdminFuncView)
	 */
	@Override
	public String save(AdminFuncView adminFuncView) throws ServiceException {

		try {
			return adminSystemServiceClientProxy.saveFunc(adminFuncView);
		} catch (TException e) {
			throw new ServiceException(e);
		}
	}

	/* (non-Javadoc)
	 * @see one.show.service.AdminFuncService#update(one.show.manage.thrift.view.AdminFuncView)
	 */
	@Override
	public void update(AdminFuncView adminFuncView) throws ServiceException {

		try {
			adminSystemServiceClientProxy.updateFunc(adminFuncView);
		} catch (TException e) {
			throw new ServiceException(e);
		}
	}

	/* (non-Javadoc)
	 * @see one.show.service.AdminFuncService#delete(java.lang.String)
	 */
	@Override
	public void delete(String funcId) throws ServiceException {

		try {
			adminSystemServiceClientProxy.deleteFunc(funcId);
		} catch (TException e) {
			throw new ServiceException(e);
		}
	}

}


