namespace java one.show.manage.thrift.view

include "GiftView.thrift"
struct GiftListView{
	1:list<GiftView.GiftView> giftList
	2:i32 count
}


