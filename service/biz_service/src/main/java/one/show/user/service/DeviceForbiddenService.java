/**
 * 
 */
package one.show.user.service;

import java.util.List;

import one.show.common.exception.ServiceException;
import one.show.user.domain.DeviceForbidden;

/**
 * @author hank
 *
 */
public interface DeviceForbiddenService {
	
	/**
	 * 获取设备权限信息
	 * @param did
	 * @return
	 */
	public List<DeviceForbidden> findDeviceForbiddenListByDid(String did) throws ServiceException;
	
	
	public void saveForbidden(DeviceForbidden deviceForbidden) throws ServiceException;
	
	public void deleteForbidden(String did) throws ServiceException;
}