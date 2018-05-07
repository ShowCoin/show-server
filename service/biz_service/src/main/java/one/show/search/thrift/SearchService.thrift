namespace java one.show.search.thrift.iface

include "UserSearchView.thrift"

service SearchServiceProxy{
	list<i64> searchUser(1:string keyword,2:i32 cursor,3:i32 count);
	void deleteUser(1:i64 uid);
	void insertUser(1:UserSearchView.UserSearchView userSearchView);
	void updateUser(1:UserSearchView.UserSearchView userSearchView);
}

