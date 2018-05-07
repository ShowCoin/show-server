namespace java one.show.video.thrift.view

struct LiveUserView{
	1:i64 liveid
	2:i64 uid
	3:string snapshot
	4:i32 viewed
	5:i32 createTime
	6:i32 vodStatus
	7:i32 status
}