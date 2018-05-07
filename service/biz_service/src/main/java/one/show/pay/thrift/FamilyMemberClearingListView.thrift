namespace java one.show.pay.thrift.view

include "FamilyMemberClearingView.thrift"
struct FamilyMemberClearingListView{
	1:list<FamilyMemberClearingView.FamilyMemberClearingView> familyMemberClearingList
	2:i32 count
}