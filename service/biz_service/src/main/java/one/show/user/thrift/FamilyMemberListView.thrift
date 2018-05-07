namespace java one.show.user.thrift.view

include "FamilyMemberView.thrift"
struct FamilyMemberListView{
	1:list<FamilyMemberView.FamilyMemberView> familyMemberList
	2:i32 count
}


