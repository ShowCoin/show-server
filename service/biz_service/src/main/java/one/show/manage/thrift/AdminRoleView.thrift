namespace java one.show.manage.thrift.view

struct AdminRoleView{
	1:i32 roleId
	2:string roleName
	3:string roleDesc
	4:i32 status
	5:i32 createTime
	6:list<string> funcs
}


