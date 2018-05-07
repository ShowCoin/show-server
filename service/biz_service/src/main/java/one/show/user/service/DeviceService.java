package one.show.user.service;

import java.util.List;
import java.util.Map;

import one.show.common.exception.ServiceException;
import one.show.user.domain.Device;
import one.show.user.domain.UserDevice;

public interface DeviceService {
	public Device findDeviceByDid(String deviceUuid) throws ServiceException;
	public void updateDevice(String deviceUuid,Map<String,String> paramsMap) throws ServiceException;

	int save(Device device) throws ServiceException;
	
	public void delete(String did) throws ServiceException;
	
	public UserDevice findUserDevice(long uid,String deviceUuid) throws ServiceException;

	public List<UserDevice> findListByUid(long uid) throws ServiceException;

	public void insertUserDevice(UserDevice device) throws ServiceException;
	
	public void deleteUserDeviceByUid(long uid) throws ServiceException;
}
