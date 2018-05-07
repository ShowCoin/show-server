package one.show.manage.service;

import java.util.List;
import java.util.Map;

import one.show.manage.domain.ActivityConfig;
import one.show.manage.domain.ActivityShare;
import one.show.manage.domain.ActivityShareReward;

public interface  ActivityService {
	
	List<ActivityConfig>  findAllActivityConfigs();
	
	ActivityShare findActivityShareByDid(String did);
	
	void updateActivityShare(String did,Map<String, String> updateContent);
	
	void saveActivityShare(ActivityShare activityShare);
	
	ActivityShareReward findActivityShareRewardByDate(int date);
	
	void updateActivityShareReward(int id,Map<String, String> updateContent);
	
	void saveActivityShareReward(ActivityShareReward activityShareReward);

	void addToUserShare(String did, String shareReward);

	void addToShareReward(int date,String name, double showCoin);

	void updateActivityConfig(int id, Map<String, String> updateContent);

}
