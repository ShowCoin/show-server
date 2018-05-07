namespace java one.show.manage.thrift.view

include "AdminRoleView.thrift"
struct AdminRoleListView{
	1:list<AdminRoleView.AdminRoleView> roleList
	2:i32 count
}


