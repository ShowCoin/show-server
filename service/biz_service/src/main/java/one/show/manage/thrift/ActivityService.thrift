namespace java one.show.manage.thrift.iface

include "ActivityConfigView.thrift"
include "ActivityShareView.thrift"
include "ActivityShareRewardView.thrift"

service ActivityServiceProxy{
		
	list<ActivityConfigView.ActivityConfigView>  findAllActivityConfigs();
	
	ActivityShareView.ActivityShareView findActivityShareByDid(1:string did);
	
	void updateActivityShare(1:string did,2:map<string, string> updateContent);
	
	void saveActivityShare(1:ActivityShareView.ActivityShareView activityShare);
	
	ActivityShareRewardView.ActivityShareRewardView findActivityShareRewardByDate(1:i32 date);
	
	void updateActivityShareReward(1:i32 shareDate,2:map<string, string> updateContent);
	
	void saveActivityShareReward(1:ActivityShareRewardView.ActivityShareRewardView activityShareReward);
	
	void addToUserShare(1:string did,2:string shareReward);
	
  	void addToShareReward(1:i32 date,2:string name,3:double showCoin);
  	
  	void updateActivityConfig(1:i32 id, 2:map<string,string> paramMap);
}