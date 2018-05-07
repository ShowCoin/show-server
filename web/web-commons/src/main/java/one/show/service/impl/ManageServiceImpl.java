package one.show.service.impl;

import java.util.List;
import java.util.Map;

import one.show.common.exception.ServiceException;
import one.show.service.ManageService;

import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import one.show.manage.thrift.iface.ManageServiceProxy;
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
import one.show.user.thrift.iface.UserServiceProxy;

@Component("manageService")
public class ManageServiceImpl implements ManageService {
	@Autowired
	private ManageServiceProxy.Iface manageServiceClientProxy;
	@Autowired
	private UserServiceProxy.Iface userServiceClientProxy;

	@Override
	public VersionControlView findVersionControlByAgentType(int agentType)
			throws ServiceException {

		try {
			return manageServiceClientProxy
					.findVersionControlByAgentType(agentType);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}


	@Override
	public List<LinkView> findPlazaLinks() throws ServiceException {
		try {
			return manageServiceClientProxy.findPlazaLinks();
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public void saveReport(ReportView reportView) throws ServiceException {
		try {
			manageServiceClientProxy.saveReport(reportView);
		} catch (TException e) {
			throw new ServiceException(e);
		}
	}

	
	  @Override
      public List<HeaderPortraitView> findHeaderPortraitList(int pageSize,
                      int pageCount) throws ServiceException {
              List<HeaderPortraitView> list = null;
              try {
                      list = manageServiceClientProxy.findHeaderPortraitList(pageSize,
                                      pageCount);
              } catch (Exception e) {
                      throw new ServiceException(e);
              }
              return list;
      }

      @Override
      public void deleteHeaderPortrait(long id) throws ServiceException {
              try {
                      manageServiceClientProxy.deleteHeaderPortrait(id);
              } catch (Exception e) {
                      throw new ServiceException(e);
              }

      }

      @Override
      public void deleteHeaderPortraitList(List<Long> ids)
                      throws ServiceException {
              try {
                      manageServiceClientProxy.deleteHeaderPortraitList(ids);
              } catch (Exception e) {
                      throw new ServiceException(e);
              }

      }

      @Override
      public void saveHeaderPortraitList(HeaderPortraitView headerPortraitView)
                      throws ServiceException {
              try {
                      manageServiceClientProxy.saveHeaderPortraitList(headerPortraitView);
              } catch (Exception e) {
                      throw new ServiceException(e);
              }

      }

      
      @Override
      public AdminHeaderPortraitListView findAdminHeaderPortraitListView(
                      int pageSize, int pageCount) throws ServiceException {
              AdminHeaderPortraitListView adminHeaderPortraitListView = null;
              try {
                      adminHeaderPortraitListView = manageServiceClientProxy
                                      .findAdminHeaderPortraitListView(pageSize, pageCount);
              } catch (Exception e) {
                      throw new ServiceException(e);
              }
              return adminHeaderPortraitListView;
      }


	
	@Override
	public void saveSendExchange(SendExchangeView sendExchangeView)
			throws ServiceException {
		try {
			manageServiceClientProxy.saveSendExchange(sendExchangeView);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public List<SendExchangeView> findSendExchangeByUid(Long uid,int sendType, int start,
			int count) throws ServiceException {
		List<SendExchangeView> list = null;
		try {
			list = manageServiceClientProxy.findSendExchangeByUid(uid,sendType, start, count);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
		return list;
	}

	@Override
	public int findSendExchangeCountByUid(Long uid,int sendType) throws ServiceException {
		int count = 0;
		try {
			count  = manageServiceClientProxy.findSendExchangeCountByUid(uid,sendType);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
		return count;
	}



	@Override
	public SystemConfigView getSystemConfig(String configId)
			throws ServiceException {
		
		try {
			return manageServiceClientProxy.getSystemConfig(configId);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public void updateSystemConfig(SystemConfigView systemConfigView)
			throws ServiceException {
		try {
			manageServiceClientProxy.updateSystemConfig(systemConfigView);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
		
	}



	@Override
	public List<AdvertisementView> findAdvertisementView()
			throws ServiceException {
		List<AdvertisementView> list=null;
		try {
			list=manageServiceClientProxy.findAdvertisementView();
		} catch (Exception e) {
			throw new ServiceException(e);
		}
		return list;
	}
	

	@Override
	public List<SystemConfigView> getSystemConfigList(Map<String, String> paramMap, int start, int count) throws ServiceException {
		try {
			return manageServiceClientProxy.getSystemConfigList(paramMap, start, count);
		} catch (TException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public void addSystemConfig(SystemConfigView systemConfigView)
			throws ServiceException {
		try {
			manageServiceClientProxy.addSystemConfig(systemConfigView);
		} catch (TException e) {
			throw new ServiceException(e);
		}
		
	}

	@Override
	public void deleteSystemConfig(String configId) throws ServiceException {
		try {
		    manageServiceClientProxy.deleteSystemConfig(configId);
		} catch (TException e) {
			throw new ServiceException(e);
		}
		
	}



	@Override
	public SystemConfigView getSystemConfigByVersion(String version)
			throws ServiceException {
		try {
			return manageServiceClientProxy.getSystemConfigByVersion(version);
		} catch (TException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public void saveRegister(RegisterView registerView) throws ServiceException {
		try {
			manageServiceClientProxy.saveRegister(registerView);
		} catch (TException e) {
			throw new ServiceException(e);
		}
		
	}

	@Override
	public GiftView findGiftById(int giftId) throws ServiceException {
		GiftView giftView = null;
		try {
			giftView=manageServiceClientProxy.findGiftById(giftId);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
		return giftView;
	}

	@Override
	public RegisterView getRegisterByUid(String uid) throws ServiceException {
		try {
			return manageServiceClientProxy.getRegisterByUid(uid);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public void updateRegisterByUid(String uid, Map<String, String> paramMap)
			throws ServiceException {
		try {
			manageServiceClientProxy.updateRegisterByUid(uid, paramMap);
		} catch (TException e) {
			throw new ServiceException(e);
		}
		
	}

	@Override
	public RegisterListView getRegisterList(Map<String, String> paramMap,
			int start, int count) throws ServiceException {
		try {
			return manageServiceClientProxy.getRegisterList(paramMap, start, count);
		} catch (TException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public void updateRegister(RegisterView registerView)
			throws ServiceException {
		try {
		    manageServiceClientProxy.updateRegister(registerView);
		} catch (TException e) {
			throw new ServiceException(e);
		}
		
	}


	@Override
	public List<FanLevelView> findFanLevelList() throws ServiceException {
		try {
			return manageServiceClientProxy.findFanLevelList();
		} catch (TException e) {
			throw new ServiceException(e);
		}
	}


	@Override
	public UserCDNListView findUserCDNList(int start, int count)
			throws ServiceException {

		try {
			return manageServiceClientProxy.findUserCDNList(start, count);
		} catch (TException e) {
			throw new ServiceException(e);
		}
	}


	@Override
	public void updateUserCDNById(UserCDNView userCDNView)
			throws ServiceException {

		try {
			 manageServiceClientProxy.updateUserCDNById(userCDNView);
		} catch (TException e) {
			throw new ServiceException(e);
		}
	}


	@Override
	public void deleteUserCDN(long uid) throws ServiceException {

		try {
			 manageServiceClientProxy.deleteUserCDN(uid);
		} catch (TException e) {
			throw new ServiceException(e);
		}
	}


	@Override
	public void saveUserCDN(UserCDNView userCDNView) throws ServiceException {

		try {
			 manageServiceClientProxy.saveUserCDN(userCDNView);
		} catch (TException e) {
			throw new ServiceException(e);
		}
	}


	@Override
	public UserCDNView findUserCDNById(long uid) throws ServiceException {

		try {
			 return manageServiceClientProxy.findUserCDNById(uid);
		} catch (TException e) {
			throw new ServiceException(e);
		}
	}

}