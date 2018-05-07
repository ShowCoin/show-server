namespace java one.show.user.thrift.iface

include "GpsView.thrift"


service GpsServiceProxy{

	GpsView.GpsView findGpsByUid(1:i64 uid);
	void saveGps(1:GpsView.GpsView gpsView);
	void updateGps(1:i64 uid, 2:map<string, string> params);
	list<GpsView.GpsView> findNearGpsList(1:map<string,string> params,2:i32 start,3:i32 count);
}

