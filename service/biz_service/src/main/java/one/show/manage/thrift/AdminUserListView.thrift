namespace java one.show.manage.thrift.view

include "AdminUserView.thrift"
struct AdminUserListView{
	1:list<AdminUserView.AdminUserView> userList
	2:i32 count
}


