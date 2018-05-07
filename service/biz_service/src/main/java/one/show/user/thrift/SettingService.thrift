namespace java one.show.user.thrift.iface

include "SettingView.thrift"

service SettingServiceProxy{

	SettingView.SettingView getSettingByUid(1:string uid);
	
	void setSwitch(1:string uid,2:map<string, string> paramMap);
	
}