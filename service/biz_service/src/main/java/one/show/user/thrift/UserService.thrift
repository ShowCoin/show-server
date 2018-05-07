namespace java one.show.user.thrift.iface

include "../../../../../../../../thrift-common/ServerException.thrift"

include "UserView.thrift"
include "ContactView.thrift"
include "ThirdDataView.thrift"
include "GenericType.thrift"
include "UserForbiddenView.thrift"
include "BlackListView.thrift"
include "RoomAdminView.thrift"
include "UserPopularNoView.thrift"
include "SettingView.thrift"
include "RobotView.thrift"
include "WhiteListView.thrift"

service UserServiceProxy{

	SettingView.SettingView getSettingByUid(1:string uid);
	
	void setSwitch(1:string uid,2:map<string, string> paramMap);
	
	UserView.UserView findUserById(1:i64 id);
	
	void registerUser(1:UserView.UserView userView, 2:ThirdDataView.ThirdDataView thirdDataView);
	
	void deleteUser(1:i64 id);
	
	UserView.UserView findUserByPid(1:i64 pid);
	
	list<UserView.UserView> findUserListByIds(1:list<i64> ids);

	void updateUserById(1:i64 id, 2:map<string, string> updatecontent);
	
	list<ContactView.ContactView> findContactListByUid(1:string uid);
	
	void insertContactList(1:list<ContactView.ContactView> contactViewList);
	
	ThirdDataView.ThirdDataView findThirdDataByTidAndType(1:string tid, 2:string type);

	
	void insertUser(1:UserView.UserView userview) throws(1:ServerException.ServerException e) ;
	
	void updateThirdData(1:string tid,2:string type, 4:map<string,string> pmap);
	
	list<ThirdDataView.ThirdDataView> findThirdDataListByUid(1:i64 uid);
	
  	i32 saveThirdData(1:ThirdDataView.ThirdDataView thirdDataView);
  	
  	void deleteThirdData(1:string tid, 2:string type);
  	
  	ThirdDataView.ThirdDataView findThirdDataByUidAndType(1:i64 uid,2:string type);
  	
  	list<UserForbiddenView.UserForbiddenView> findForbiddenListByUid(1:i64 uid);
  	
  	list<i32> getForbiddenActionListByUid(1:i64 uid);
  	
  	
  	i32 add2WhiteList(1:i64 uid,2: i32 time);
	void removeFromWhiteList(1:i64 uid);
	list<WhiteListView.WhiteListView> findWhiteList(1: i32 cursor, 2:i32 count);
	WhiteListView.WhiteListView findWhiteListByUid(1:i64 uid);
	
	
	

	i32 add2BlackList(1:i64 currentUser,2: i64 target_userid);


	void removeFromBlackList(1:i64 currentUser,2: i64 target_userid);
	list<i64> findBlackList(1:i64 currentUser,2: i32 cursor, 3:i32 count);
	
	list<BlackListView.BlackListView> findBlackListByUid(1:i64 uid,2: i32 cursor, 3:i32 count);
	
	list<BlackListView.BlackListView> findBlackListByTid(1:i64 tid,2: i32 cursor, 3:i32 count);
	bool isBlack(1:i64 uid,2: i64 tid);
	
	void saveRoomAdmin(1:i64 uid,2: i64 tid);
	void deleteRoomAdmin(1:i64 uid,2: i64 tid);
	list<i64> findRoomAdminListByUid(1:i64 uid,2: i32 cursor, 3:i32 count);
	i32 findRoomAdminCount(1:i64 uid);
	bool isRoomAdmin(1:i64 uid,2: i64 tid);
	

	void saveForbiddenView(1:UserForbiddenView.UserForbiddenView userForbiddenView) throws(1:ServerException.ServerException e) ;
	
	void deleteForbiddenByUid(1:i64 uid);
	
	void deleteForbiddenByUidAndAction(1:i64 uid,2:i32 action);
	
	
	i32 findCountBlackListByUid(1:i64 uid);
	
	i32 findCountBlackListByTid(1:i64 tid);
	
	bool isAllow(1:string nickName);
	
	void saveUserPopularNo(1:UserPopularNoView.UserPopularNoView userPopularNoView);
	
	void updateUserPopularNoStatus(1:i64 uid, 2:i64 popularNo, 3:i32 status)
	
	void deleteUserPopularNo(1:i64 uid, 2:i64 popularNo)
	
	list<UserPopularNoView.UserPopularNoView> findUserPopularNoListByUid(1:i64 uid);
	
	
	bool userIsForbidden(1:i64 uid,2:i32 action);
	
	UserView.UserView findUserByNickName(1:string nickName);
	
	list<bool> findForbiddenListByUidsAndAction(1:list<i64> uids,2:i32 action);
	
	list<UserView.UserView> findAllUserList(1:i32 start,2:i32 count);
	
	list<RobotView.RobotView> findAllRobot();
}