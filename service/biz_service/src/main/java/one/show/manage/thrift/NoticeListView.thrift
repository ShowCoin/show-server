namespace java one.show.manage.thrift.view

include "NoticeView.thrift"
struct NoticeListView{
	1:list<NoticeView.NoticeView> noticeList
	2:i32 count
}


