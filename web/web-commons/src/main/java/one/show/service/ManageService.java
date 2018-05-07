package one.show.service;

import java.util.List;
import java.util.Map;

import one.show.common.exception.ServiceException;

import one.show.manage.thrift.view.AdminHeaderPortraitListView;
import one.show.manage.thrift.view.AdvertisementView;
import one.show.manage.thrift.view.FanLevelView;
import one.show.manage.thrift.view.GiftView;
import one.show.manage.thrift.view.HeaderPortraitView;
import one.show.manage.thrift.view.LinkView;
import one.show.manage.thrift.view.RegisterListView;
import one.show.manage.thrift.view.RegisterView;
import one.show.manage.thrift.view.ReportView;
import one.show.manage.thrift.view.SendExchangeView;
import one.show.manage.thrift.view.SystemConfigView;
import one.show.manage.thrift.view.UserCDNListView;
import one.show.manage.thrift.view.UserCDNView;
import one.show.manage.thrift.view.VersionControlView;

public interface ManageService {
	public VersionControlView findVersionControlByAgentType(int agentType)
			throws ServiceException;


	List<LinkView> findPlazaLinks() throws ServiceException;

	/**
	 * 新增投诉
	 * 
	 * @param reportView
	 */
	public void saveReport(ReportView reportView) throws ServiceException;

	
    public List<HeaderPortraitView> findHeaderPortraitList(int pageSize,
            int pageCount) throws ServiceException;

	public void deleteHeaderPortrait(long id) throws ServiceException;
	
	public void deleteHeaderPortraitList(List<Long> ids)
	            throws ServiceException;
	
	public void saveHeaderPortraitList(HeaderPortraitView headerPortraitView)
	            throws ServiceException;

	public AdminHeaderPortraitListView findAdminHeaderPortraitListView(
            int pageSize, int pageCount) throws ServiceException;


	public void saveSendExchange(SendExchangeView sendExchangeView)
			throws ServiceException;

	public List<SendExchangeView> findSendExchangeByUid(Long uid,int sendType, int start,
			int count) throws ServiceException;

	public int findSendExchangeCountByUid(Long uid,int sendType) throws ServiceException;


	public SystemConfigView getSystemConfig(String configId)
			throws ServiceException;

	public void updateSystemConfig(SystemConfigView systemConfig)
			throws ServiceException;

	public List<AdvertisementView> findAdvertisementView()
			throws ServiceException;

	public List<SystemConfigView> getSystemConfigList(
			Map<String, String> paramMap, int start, int count)
			throws ServiceException;

	public void addSystemConfig(SystemConfigView systemConfigView)
			throws ServiceException;

	public void deleteSystemConfig(String configId) throws ServiceException;


	public SystemConfigView getSystemConfigByVersion(String version)
			throws ServiceException;

	public void saveRegister(RegisterView registerView) throws ServiceException;

	public RegisterView getRegisterByUid(String uid) throws ServiceException;

	public GiftView findGiftById(int giftId) throws ServiceException;

	public void updateRegisterByUid(String uid, Map<String, String> paramMap)
			throws ServiceException;
	
	public RegisterListView getRegisterList(Map<String, String> paramMap,
			int start, int count) throws ServiceException;
	
	public void updateRegister(RegisterView registerView) throws ServiceException;


	public List<FanLevelView> findFanLevelList() throws ServiceException;
	
	public UserCDNListView findUserCDNList(int start, int count)  throws ServiceException;
	
	public void updateUserCDNById(UserCDNView userCDNView) throws ServiceException;
	
	public void deleteUserCDN(long uid)throws ServiceException;
	
	public void saveUserCDN(UserCDNView userCDNView) throws ServiceException;
	
	public UserCDNView findUserCDNById(long uid) throws ServiceException;

}