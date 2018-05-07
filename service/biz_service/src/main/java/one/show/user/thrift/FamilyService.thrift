namespace java one.show.user.thrift.iface

include "FamilyView.thrift"
include "FamilyMemberView.thrift"
include "FamilyListView.thrift"
include "FamilyMemberListView.thrift"

service FamilyServiceProxy{

	
	FamilyView.FamilyView findFamilyById(1:i64 familyId);
	
	i64 saveFamily(1:FamilyView.FamilyView familyView);

	void updateFamilyById(1:i64 familyId,2:map<string,string> updateContent);
	
	FamilyListView.FamilyListView findFamilyList(1: map<string,string> condition, 2:i32 start, 3:i32 count);

  	void saveFamilyMember(1:FamilyMemberView.FamilyMemberView familyMemberView);
  	
  	FamilyMemberListView.FamilyMemberListView findFamilyMemberListByFamilyId(1:i64 familyId, 2:i32 start, 3:i32 count);
  	
  	void deleteFamilyMemberById(1:i64 familyId, 2:i64 userId);
  	
  	list<FamilyView.FamilyView> findByIds(1:list<i64> ids);
  	
}

