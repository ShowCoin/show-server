namespace java one.show.manage.thrift.view

include "AdminUserPayView.thrift"
struct AdminUserPayListView{
	1:list<AdminUserPayView.AdminUserPayView> userPayList
	2:i32 count
}


