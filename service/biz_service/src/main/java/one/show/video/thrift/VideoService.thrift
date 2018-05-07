namespace java one.show.video.thrift.iface

include "../../../../../../../../thrift-common/ServerException.thrift"
include "LiveUserView.thrift"
include "LiveView.thrift"
include "LiveHistoryViewList.thrift"
include "LiveHistoryView.thrift"
include "LiveRecordView.thrift"

service VideoServiceProxy{
	
	LiveView.LiveView  findLiveById(1:i64 liveId);
	
	LiveView.LiveView  findInLiveByUid(1:i64 uid);
	
	list<LiveView.LiveView> findLiveByIds(1:list<i64> ids);
	
	LiveHistoryViewList.LiveHistoryViewList findLiveHistoryByUid(1:i64 uid, 2:string sort, 3:map<string, string> condition, 4:i32 start, 5:i32 count);
	
	i32 findLiveHistoryCountByUid(1:i64 uid, 2:map<string, string> condition);
	
	list<LiveHistoryView.LiveHistoryView> findLiveHistoryByIds(1:list<i64> ids);
	
	LiveHistoryView.LiveHistoryView findLiveHistoryById(1:i64 liveId);
	
	void initLive(1:LiveView.LiveView liveView);
	
	void endLive(1:i64 liveId,2:i32 reason);
	
	void updateStreamStatus(1:string streamName,2:i32 status);
	
	list<LiveView.LiveView>  findLiveList(1:map<string, string> condition, 2:string sort, 3:i32 start, 4:i32 count);
	
	list<LiveView.LiveView>  findLiveList4Square(1:string sort, 2:i32 start, 3:i32 count);
	
	list<LiveView.LiveView>  findLiveList4HandSort(1:i32 start, 2:i32 count);
	
	i32  findLiveListCount(1:map<string, string> condition);
	
	void updateLive(1:i64 liveId,2:map<string, string> paramMap);
	
	LiveUserView.LiveUserView findLiveUser(1:i64 uid,2:i64 liveid);
	
	void updateLiveUser(1:i64 uid,2:i64 liveid,3:map<string, string> updateContent);
	
	void updateLiveHistory(1:i64 liveid,2:map<string, string> paramMap);
	
	LiveRecordView.LiveRecordView findById(1:i64 id);

	list<LiveRecordView.LiveRecordView> findByLiveid(1:i64 liveid);

	i32 save(1:LiveRecordView.LiveRecordView record);

	void updateStatusByLiveId(1:i64 liveid, 2:i32 status);
	
	list<LiveRecordView.LiveRecordView> findByStatus( 1:i32 status);
	
	void deleteLiveRecord(1:i64 id);
	
	i32 finishRecord(1:i64 uid,2:i64 liveid,3:string recordUrl,4:string mp4Url,5:double duration);
	
	list<LiveRecordView.LiveRecordView> findByPersistentId(1:string persistentId);
	
	void updatePersistentIdByLiveId(1:i64 liveid,2:i32 format, 3:string persistentId, 4:i32 status);

	i32 findLiveDurationByUid(1:i64 uid,  2:i32 startTime,  3:i32 endTime);
	
	i32 findLiveEffectiveDaysByUid(1:i64 uid,  2:i32 startTime,  3:i32 endTime);
	
}

