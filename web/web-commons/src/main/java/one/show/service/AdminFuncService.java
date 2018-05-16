/**
 * 
 */
package one.show.service;

import java.util.List;

import one.show.common.Constant.ADMIN_STATUS;
import one.show.common.exception.ServiceException;

import one.show.manage.thrift.view.AdminFuncView;

/**
 * @author hank 2018年1月22日 下午9:04:13
 *
 */
public interface AdminFuncService {

	/**
	 * 获取功能列表
	 * @param status
	 * @return
	 * @throws ServiceException
	 */
	public List<AdminFuncView> getFuncList(ADMIN_STATUS status) throws ServiceException;
	
	/**
	 * 根据id获取功能
	 * @param funcId
	 * @return
	 * @throws ServiceException
	 */
	public AdminFuncView getFuncById(String funcId) throws ServiceException;
	
	/**
	 * 保存功能
	 * @param adminFuncView
	 * @return
	 * @throws ServiceException
	 */
	public String save(AdminFuncView adminFuncView) throws ServiceException;
	
	/**
	 * 修改功能
	 * @param adminFuncView
	 * @throws ServiceException
	 */
	public void update(AdminFuncView adminFuncView) throws ServiceException;
	
	/**
	 * 删除功能
	 * @param funcId
	 * @throws ServiceException
	 */
	public void delete(String funcId) throws ServiceException;
}


