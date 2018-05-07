namespace java one.show.manage.thrift.view

struct AdminUserView{
	1:string userName
	2:string password
	3:string name
	4:i32 status
	5:i32 createTime
	6:list<i32> roles
	7:i32 userType
	8:i64 fid
	9:string fname
}


