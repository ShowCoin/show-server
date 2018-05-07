namespace java one.show.video.thrift.view

struct LiveRecordView{
	1:i64 id
	2:i32 cdnType
	3:i32 status
	4:i64 liveid
	5:i64 uid
	6:string bucket
	7:i32 format
	8:string ops
	9:string keys
	10:string urls
	11:i32 createTime
	12:i32 updateTime
	13:double duration
}