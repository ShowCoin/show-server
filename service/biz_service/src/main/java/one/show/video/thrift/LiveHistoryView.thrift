namespace java one.show.video.thrift.view

struct LiveHistoryView{

	1:i64 liveId
	2:i64 uid
	3:i32 startTime
	4:i32 endTime
	5:i32 status
	6:string snapshot
	7:i32 createTime
	8:i32 streamStatus
	9:i32 streamTime
	10:string streamName
	11:string ip
	12:string rtmp
	13:i32 cdnType
	14:i32 reason
	15:i32 frame
	16:i32 bitrate
	17:i32 width
	18:i32 height
	19:string did
	20:double latitude
	21:double longitude
	22:i32 city
	23:i32 province
	24:i32 viewed
	25:string title
	26:string topic
	27:string cityName
	28:i32 vodStatus
	29:string recordUrl
	30:string mp4Url
	31:i32 platform
}