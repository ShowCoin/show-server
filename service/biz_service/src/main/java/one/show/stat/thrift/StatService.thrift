namespace java one.show.stat.thrift.iface

include "UserStatView.thrift"
include "VideoStatView.thrift"
include "MonitorStatListView.thrift"
include "SummaryStatView.thrift"
include "MonitorStatView.thrift"
include "RankUserDailyView.thrift"
include "RankUserListView.thrift"
include "LogView.thrift"
include "ActionLogView.thrift"
include "RobotStatDailyView.thrift"
include "ActiveXbStatView.thrift"

service StatServiceProxy{

	UserStatView.UserStatView findUserStatByUid(1:i64 uid);

	list<UserStatView.UserStatView> findUserStatByUids(1:list<i64> uids);

	void deleteUserStat(1:i64 uid);
	void saveUserStat(1:UserStatView.UserStatView userStatView);
	void updateUserStat(1:UserStatView.UserStatView userStatView);
		
	VideoStatView.VideoStatView findVideoStatByVid(1:i64 vid);
	list<VideoStatView.VideoStatView> findVideoStatByVids(1:list<i64> uids);

	
	void saveVideoStat(1:VideoStatView.VideoStatView videoStatView);
	void updateVideoStat(1:VideoStatView.VideoStatView videoStatView);
	


	void updateMonitorStatById(1:i64 id, 2:string statement);
	void saveMonitorStat(1:MonitorStatView.MonitorStatView monitorStatView);
	MonitorStatView.MonitorStatView findMonitorStat(1:string name, 2:i32 type, 3:i32 time);
	MonitorStatListView.MonitorStatListView findMonitorStatList(1:i32 beginTime, 2:i32 endTime, 3:i32 type, 4:i32 start, 5:i32 count);

	
	list<SummaryStatView.SummaryStatView> getSummaryStatList(1:i32 time);
	
	SummaryStatView.SummaryStatView getSummaryStat(1:i32 time);
	
	void saveSummaryStat(1:SummaryStatView.SummaryStatView summaryStatView);
	
	void updateSummaryStat(1:SummaryStatView.SummaryStatView summaryStatView);
	
	void updateSummaryStatLiveMax(1:i32 num, 2:i32 time);
	
	
	RankUserDailyView.RankUserDailyView getRankUserDaily(1:i64 uid, 2:i32 type, 3:i32 date);
	
	void savetRankUserDaily(1:RankUserDailyView.RankUserDailyView rankUserDailyView);
	
	void updateRankUserDaily(1:i64 id, 2:double number);
	
	RankUserListView.RankUserListView findRankUserList(1:i32 beginTime, 2:i32 endTime, 3:i32 type, 4:i32 start, 5:i32 count);

	void saveLog(1:LogView.LogView logView);
	
	void saveActionLog(1:ActionLogView.ActionLogView actionLogView);
	
	RobotStatDailyView.RobotStatDailyView findRobotStatDailyByDate(1:i32 date);
	void saveRobotStatDaily(1:RobotStatDailyView.RobotStatDailyView robotStatDailyView);
	void updateRobotStatDailyByDate(1:i32 date, 2:map<string, string> updateContent)
	
	
	
	ActiveXbStatView.ActiveXbStatView findActiveXbStatByUidAndTime(1:i64 uid, 2:i32 time);
	void saveActiveXbStat(1:ActiveXbStatView.ActiveXbStatView ActiveXbStatView);
	void updateActiveXbStatById(1:i64 id, 2:map<string, string> updateContent)
	
}

