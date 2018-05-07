namespace java one.show.manage.thrift.view

include "UserCDNView.thrift"
struct UserCDNListView{
	1:list<UserCDNView.UserCDNView> cdnList
	2:i32 count
}


