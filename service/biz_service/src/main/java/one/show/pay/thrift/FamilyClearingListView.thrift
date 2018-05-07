namespace java one.show.pay.thrift.view

include "FamilyClearingView.thrift"
struct FamilyClearingListView{
	1:list<FamilyClearingView.FamilyClearingView> familyClearingList
	2:i32 count
}