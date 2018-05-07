namespace java one.show.relation.thrift.iface

include "../../../../../../../../thrift-common/ServerException.thrift"
include "FansView.thrift"
include "FollowView.thrift"
include "FeedView.thrift"

service RelationServiceProxy{

	list<FansView.FansView> findFansListByUid(1:i64 uid, 2:i32 start, 3:i32 count);
	
	list<FollowView.FollowView> findFollowListByUid(1:i64 uid, 2:i32 start, 3:i32 count);
	
	void follow(1:i64 uid, 2:i64 fid);

	void unfollow(1:i64 uid, 2:i64 vid);
	
	i32 findFansCount(1:i64 uid);
	
	i32 findFollowCount(1:i64 uid);
	

	list<bool> isFollowed(1:i64 currentUser, 2: list<i64>uids);
	
	list<bool> isFans(1:i64 currentUser, 2: list<i64>uids);
	
	list<FeedView.FeedView> findFeedListByUid(1:i64 uid, 2:map<string, string> condition, 3:i32 start, 4:i32 count);
	
	void saveFeed(1:FeedView.FeedView feedView);
	
	void updateFeed(1:i64 uid, 2:i64 fid, 3:string point, 4:map<string, string> updateContent);
	
	void deleteFeed(1:i64 uid, 2:i64 fid, 3:string point);
	
	
}

