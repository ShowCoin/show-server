namespace java one.show.manage.thrift.iface

include "VersionControlView.thrift"
include "LinkView.thrift"
include "ReportView.thrift"
include "GiftListView.thrift"
include "GiftView.thrift"
include "GiftTypeView.thrift"
include "TranscationDetailLogView.thrift"
include "SendExchangeView.thrift"
include "SystemConfigView.thrift"
include "AdvertisementView.thrift"
include "RegisterView.thrift"
include "RegisterListView.thrift"
include "MasterLevelView.thrift"
include "FanLevelView.thrift"
include "NoticeView.thrift"
include "NoticeListView.thrift"
include "HeaderPortraitView.thrift"
include "AdminHeaderPortraitListView.thrift"
include "UserCDNView.thrift"
include "UserCDNListView.thrift"
include "RobotSendGiftRatioView.thrift"

service ManageServiceProxy{
	VersionControlView.VersionControlView findVersionControlByAgentType(1:i32 agentType);
	list<LinkView.LinkView> findPlazaLinks();
	
	void saveReport(1:ReportView.ReportView reportView);
	
	list<HeaderPortraitView.HeaderPortraitView> findHeaderPortraitList(1:i32 pageSize,2:i32 pageCount);
    void deleteHeaderPortrait(1:i64 id);
    void deleteHeaderPortraitList(1:list<i64> ids);
    void saveHeaderPortraitList(1:HeaderPortraitView.HeaderPortraitView headerPortraitView);
	AdminHeaderPortraitListView.AdminHeaderPortraitListView findAdminHeaderPortraitListView(1:i32 pageSize,2:i32 pageCount);
	
	
	GiftListView.GiftListView findGiftList(1:i32 giftType, 2:i32 status, 3:i32 start, 4:i32 count);
	void saveGift(1:GiftView.GiftView giftView);
	void deleteGift(1:i32 giftId);
	list<GiftTypeView.GiftTypeView> findGiftTypeList(1:i32 status);
	GiftView.GiftView findGiftById(1:i32 giftId);
	void updateGift(1:i32 giftId, 2:map<string,string> updateContent);

	
	void saveSendExchange(1:SendExchangeView.SendExchangeView sendExchangeView);
	
	list<SendExchangeView.SendExchangeView> findSendExchangeByUid(1:i64 uid,2:i32 sendType,3:i32 start,4:i32 count);
	
	i32 findSendExchangeCountByUid(1:i64 uid,2:i32 sendType);
	
	SystemConfigView.SystemConfigView getSystemConfig(1:string configId);
	
	void updateSystemConfig(1:SystemConfigView.SystemConfigView systemConfigView) 
	
	list<AdvertisementView.AdvertisementView> findAdvertisementView();
	
    list<SystemConfigView.SystemConfigView> getSystemConfigList(1:map<string, string> paramMap,2:i32 start,3:i32 count);
    void addSystemConfig(1:SystemConfigView.SystemConfigView systemConfigView);
	void deleteSystemConfig(1:string configId);
	SystemConfigView.SystemConfigView getSystemConfigByVersion(1:string version);
	
	void saveRegister(1:RegisterView.RegisterView registerView);
	RegisterView.RegisterView getRegisterByUid(1:string uid);
	void updateRegisterByUid(1:string uid, 2:map<string, string> paramMap);
	RegisterListView.RegisterListView getRegisterList(1:map<string,string> paramMap, 2:i32 start, 3:i32 count);
	void updateRegister(1:RegisterView.RegisterView registerView);
	
	list<MasterLevelView.MasterLevelView> findMasterLevelList();
	list<FanLevelView.FanLevelView> findFanLevelList();
	
	NoticeView.NoticeView findNoticeById(1:i32 id);
	list<NoticeView.NoticeView> findEffecNoticeList();
	NoticeListView.NoticeListView findNoticeList(1:i32 start, 2:i32 count);
	void updateNoticeById(1:i32 id, 2:map<string, string> paramMap);
	void deleteNoticeById(1:i32 id);
	void addNotice(1:NoticeView.NoticeView noticeView);
	
	UserCDNListView.UserCDNListView findUserCDNList(1:i32 start, 2:i32 count);
	void updateUserCDNById(1:UserCDNView.UserCDNView userCDNView);
	void deleteUserCDN(1:i64 uid);
	void saveUserCDN(1:UserCDNView.UserCDNView userCDNView); 
	UserCDNView.UserCDNView findUserCDNById(1:i64 uid);
	
	list<RobotSendGiftRatioView.RobotSendGiftRatioView> findRobotSendGiftRatioList();
	void saveRobotSendGiftRatio(1:RobotSendGiftRatioView.RobotSendGiftRatioView robotSendGiftRatioView);
	

}