package one.show.service;

import java.util.List;
import java.util.Map;

import one.show.common.exception.ServiceException;

import one.show.user.thrift.view.DeviceForbiddenView;
import one.show.user.thrift.view.DeviceView;
import one.show.user.thrift.view.UserDeviceView;

public interface DeviceService {
	/**
	 * 根据id查询设备
	 * @param did
	 * @return
	 * @throws ServiceException
	 */
	public DeviceView findDeviceByDid(String did) throws ServiceException;
	/**
	 * 查询设备信息
	 * @param did
	 * @param params
	 * @throws ServiceException
	 */
	public void updateDevice(String did,Map<String,String> params) throws ServiceException;
	
	/**
	 * 判断设备是否被禁止
	 * @param did
	 * @return
	 * @throws ServiceException
	 */
	public boolean deviceIsForbidden(String did) throws ServiceException;
	
	/**
	 * 保存设备封禁信息
	 * @param deviceForbiddenView
	 * @throws ServiceException
	 */
	public void saveForbidden(DeviceForbiddenView deviceForbiddenView) throws ServiceException;
	
	public void deleteForbidden(String did) throws ServiceException;
	
	public void saveDevice(DeviceView deviceView)throws ServiceException;
	
	public UserDeviceView findUserDevice(long uid, String deviceUuid) throws ServiceException;

    public List<UserDeviceView> findListByUid(long uid) throws ServiceException;

    public void saveUserDevice(UserDeviceView device) throws ServiceException;
    
    public void delete(String did) throws ServiceException;
    
    public void deleteUserDeviceByUid(long uid) throws ServiceException;
}
