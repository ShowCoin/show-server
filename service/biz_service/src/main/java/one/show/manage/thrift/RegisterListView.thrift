namespace java one.show.manage.thrift.view

include "RegisterView.thrift"
struct RegisterListView{
	1:list<RegisterView.RegisterView> registerList
	2:i32 count
}