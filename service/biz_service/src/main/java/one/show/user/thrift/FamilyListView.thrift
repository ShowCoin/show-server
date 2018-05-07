namespace java one.show.user.thrift.view

include "FamilyView.thrift"
struct FamilyListView{
	1:list<FamilyView.FamilyView> familyViewList
	2:i32 count
}


