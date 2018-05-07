namespace java one.show.manage.thrift.view

struct AdminFuncView{
	1:string funcId
	2:string funcName
	3:string url
	4:i32 funcType
	5:string fatherFuncId
	6:i32 status
	7:bool hasChild
}


