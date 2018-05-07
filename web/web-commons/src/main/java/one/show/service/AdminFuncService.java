/**
 * 
 */
package one.show.service;

import java.util.List;

import one.show.common.Constant.ADMIN_STATUS;
import one.show.common.exception.ServiceException;

import one.show.manage.thrift.view.AdminFuncView;

/**
 * @author Norman711 2015年8月22日 下午9:04:13
 *
 */
public interface AdminFuncService {

	public List<AdminFuncView> getFuncList(ADMIN_STATUS status) throws ServiceException;
	
	
	public AdminFuncView getFuncById(String funcId) throws ServiceException;
	
	public String save(AdminFuncView adminFuncView) throws ServiceException;
	
	public void update(AdminFuncView adminFuncView) throws ServiceException;
	
	public void delete(String funcId) throws ServiceException;
}


