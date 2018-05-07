namespace java one.show.manage.thrift.view

include "AdminVideoView.thrift"
struct AdminVideoListView{
	1:list<AdminVideoView.AdminVideoView> videoList
	2:i32 count
}


