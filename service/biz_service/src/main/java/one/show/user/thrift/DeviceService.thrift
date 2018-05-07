namespace java one.show.user.thrift.iface

include "../../../../../../../../thrift-common/ServerException.thrift"
include "DeviceView.thrift"
include "DeviceForbiddenView.thrift"
include "UserDeviceView.thrift"

service DeviceServiceProxy{
	DeviceView.DeviceView findDeviceByDid(1:string did);
	void updateDevice(1: string did,2:map<string,string> paramsMap);
	
	list<DeviceForbiddenView.DeviceForbiddenView> findDeviceForbiddenListByDid(1: string did);

  	bool findForbiddenByDid(1: string did);

  	void saveForbidden(1:DeviceForbiddenView.DeviceForbiddenView deviceForbiddenView)  throws(1:ServerException.ServerException e) ;
  	
  	void deleteDevice(1:string did);
  	
  	void deleteForbidden(1:string did);

  	void saveDevice(1:DeviceView.DeviceView deviceView)  throws(1:ServerException.ServerException e) ;
  	
  	UserDeviceView.UserDeviceView findUserDevice(1:i64 uid,2:string deviceUuid);

	list<UserDeviceView.UserDeviceView> findListByUid(1:i64 uid);

	void saveUserDevice(1:UserDeviceView.UserDeviceView device);
	
	void deleteUserDeviceByUid(1:i64 uid);
}

