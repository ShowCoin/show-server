namespace java one.show.manage.thrift.view

include "HeaderPortraitView.thrift"
struct AdminHeaderPortraitListView{
	1:list<HeaderPortraitView.HeaderPortraitView> headerPortraitViewList
	2:i32 count
}


