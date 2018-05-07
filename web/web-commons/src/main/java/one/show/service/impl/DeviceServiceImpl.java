package one.show.service.impl;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;
import java.util.Map;

import one.show.common.exception.ServiceException;
import one.show.common.local.HeaderParams;
import one.show.common.local.XThreadLocal;
import one.show.service.DeviceService;

import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import one.show.user.thrift.iface.DeviceServiceProxy;
import one.show.user.thrift.view.DeviceForbiddenView;
import one.show.user.thrift.view.DeviceView;
import one.show.user.thrift.view.UserDeviceView;

@Component("deviceService")
public class DeviceServiceImpl implements DeviceService {
	@Autowired
    private DeviceServiceProxy.Iface deviceServiceClientProxy;
	@Override
	public DeviceView findDeviceByDid(String did)
			throws ServiceException {
		DeviceView deviceView=null;
		try {
			deviceView=deviceServiceClientProxy.findDeviceByDid(did);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
		return deviceView;
	}

	@Override
	public void updateDevice(String did,Map<String, String> params)
			throws ServiceException {
		try {
			deviceServiceClientProxy.updateDevice(did,params);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
		
	}

	@Override
	public boolean deviceIsForbidden(String did) throws ServiceException{
		try {
			boolean found = deviceServiceClientProxy.findForbiddenByDid(did);
			return found;
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public void saveForbidden(DeviceForbiddenView deviceForbiddenView)
			throws ServiceException {
		try {
			deviceServiceClientProxy.saveForbidden(deviceForbiddenView);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
		
	}

	@Override
	public void deleteForbidden(String did) throws ServiceException {
		try {
			deviceServiceClientProxy.deleteForbidden(did);
		} catch (TException e) {
			throw new ServiceException(e);
		}
		
	}

	@Override
	public void saveDevice(DeviceView deviceView) throws ServiceException {
		
		//保存设备数据
		HeaderParams headerParams = XThreadLocal.getInstance().getHeaderParams();
		deviceView.setAppVersion(headerParams.getAppVersion());
		deviceView.setOs(headerParams.getOs());
		deviceView.setKernelVersion(headerParams.getKernelVersion());
		deviceView.setPhoneType(headerParams.getPhoneType());
		deviceView.setDeviceName(headerParams.getDeviceName());
		if (headerParams.getDeviceName() != null){
			try {
				deviceView.setDeviceName(URLDecoder.decode(headerParams.getDeviceName(),"utf-8"));
			} catch (UnsupportedEncodingException e) {
			}
		}
		
		deviceView.setPhoneNumber(headerParams.getPhoneNum());
		deviceView.setPlatform(XThreadLocal.getInstance().getUserAgent().toString());
		deviceView.setPushId(headerParams.getPushId());
		deviceView.setChannel(headerParams.getChannel());
		deviceView.setSc(headerParams.getSc());
		deviceView.setCreateTime((int) (System.currentTimeMillis() / 1000));
		
		try {
			deviceServiceClientProxy.saveDevice(deviceView);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
		
	}

	@Override
	public UserDeviceView findUserDevice(long uid, String deviceUuid)
			throws ServiceException {
		try {
			return deviceServiceClientProxy.findUserDevice(uid, deviceUuid);
		} catch (TException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public List<UserDeviceView> findListByUid(long uid) throws ServiceException {
		try {
			return deviceServiceClientProxy.findListByUid(uid);
		} catch (TException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public void saveUserDevice(UserDeviceView device) throws ServiceException {
		try {
			deviceServiceClientProxy.saveUserDevice(device);;
		} catch (TException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public void delete(String did) throws ServiceException {

		try {
			deviceServiceClientProxy.deleteDevice(did);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
		
	}

	@Override
	public void deleteUserDeviceByUid(long uid) throws ServiceException {

		try {
			deviceServiceClientProxy.deleteUserDeviceByUid(uid);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
		
	}
	
	
}
