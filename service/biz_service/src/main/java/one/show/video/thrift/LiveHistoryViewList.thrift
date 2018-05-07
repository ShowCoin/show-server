namespace java one.show.video.thrift.view

include "LiveHistoryView.thrift"

struct LiveHistoryViewList{

	1:list<LiveHistoryView.LiveHistoryView> liveHistoryViewList
	2:i32 count
	
}