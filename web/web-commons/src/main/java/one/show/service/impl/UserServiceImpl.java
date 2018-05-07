package one.show.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jms.JMSException;

import one.show.common.Adapter;
import one.show.common.JacksonUtil;
import one.show.common.Loader;
import one.show.common.RandomUtils;
import one.show.common.TimeUtil;
import one.show.common.Constant.POPULAR_NO_STATUS;
import one.show.common.Constant.STAT_ACTION;
import one.show.common.Constant.THIRD_BIND_PUBLIC_STATUS;
import one.show.common.cache.LocalCache;
import one.show.common.exception.ReturnException;
import one.show.common.exception.ServiceException;
import one.show.common.id.PopularID;
import one.show.common.im.IMUtils;
import one.show.common.local.HeaderParams;
import one.show.common.local.XThreadLocal;
import one.show.common.mq.Publisher;
import one.show.common.mq.Queue;
import one.show.service.DeviceService;
import one.show.service.ManageService;
import one.show.service.PayService;
import one.show.service.RelationService;
import one.show.service.SearchService;
import one.show.service.SensitiveService;
import one.show.service.StatService;
import one.show.service.UserService;

import org.apache.commons.lang3.StringUtils;
import org.apache.thrift.TException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import one.show.id.thrift.iface.IDServiceProxy;
import one.show.id.thrift.view.IDView;
import one.show.manage.thrift.view.HeaderPortraitView;
import one.show.search.thrift.view.UserSearchView;
import one.show.user.thrift.iface.UserServiceProxy;
import one.show.user.thrift.view.BlackListView;
import one.show.user.thrift.view.ContactView;
import one.show.user.thrift.view.DeviceView;
import one.show.user.thrift.view.NickNameUserView;
import one.show.user.thrift.view.PopularNoUserView;
import one.show.user.thrift.view.RobotView;
import one.show.user.thrift.view.SettingView;
import one.show.user.thrift.view.ThirdBindView;
import one.show.user.thrift.view.ThirdDataView;
import one.show.user.thrift.view.UserDeviceView;
import one.show.user.thrift.view.UserForbiddenView;
import one.show.user.thrift.view.UserPopularNoView;
import one.show.user.thrift.view.UserView;

@Component("userService")
public class UserServiceImpl implements UserService {
	
	private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private UserServiceProxy.Iface userServiceClientProxy;

	@Autowired
	private StatService statService;
	
	@Autowired
	private DeviceService deviceService;
	
	@Autowired
	private ManageService manageService;

	@Autowired
	private RelationService relationService;
	
	@Autowired
	private PayService payService;
	
	@Autowired
	SensitiveService sensitiveService;
	
	@Autowired
	SearchService searchService;
	
	@Autowired
	private IDServiceProxy.Iface idServiceClientProxy;
	
	@Override
	public UserView findUserById(long id) throws ServiceException {
		UserView user = null;
		try {
			user = userServiceClientProxy.findUserById(id);
		} catch (Exception e) {
			throw new ServiceException(e);
		}

		return user;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see UserService#findThirdDataByTidAndType(java.lang.Long,
	 * java.lang.String)
	 */
	@Override
	public ThirdDataView findThirdDataByTidAndType(String tid, String type)
			throws ServiceException {
		ThirdDataView thirdDataView = null;
		try {
			thirdDataView = userServiceClientProxy.findThirdDataByTidAndType(
					tid, type);
		} catch (TException e) {
			throw new ServiceException(e);
		}
		return thirdDataView;
	}

	@Override
	public void updateUserById(long uid, Map<String, String> updateContent)
			throws ServiceException {
		
		//修改昵称
		String nickName = updateContent.get("nickname");
		
		//修改头像,加审核
		String profile_img = updateContent.get("profile_img");
		if (profile_img != null){
			UserView user = null;
			try {
				user = findUserById(uid);
			} catch (ServiceException e) {
				log.error(e.getMessage(),e);
			}
			
			HeaderPortraitView headerPortraitView = new HeaderPortraitView();
			headerPortraitView.setImg(profile_img);
			headerPortraitView.setUid(uid);
			headerPortraitView.setCreateAt(TimeUtil.getCurrentTimestamp());
			headerPortraitView.setNickName(user == null?"xxx":user.getNickname());
			manageService.saveHeaderPortraitList(headerPortraitView);
		}
		
		
		try {
			 userServiceClientProxy.updateUserById(uid, updateContent);
		} catch (TException e) {
			throw new ServiceException(e);
		}
		
		//修改靓号
		String popularNo = updateContent.get("popular_no");
		if (profile_img != null || nickName != null || popularNo != null){
			UserView u = findUserById(uid);
			//同步融云
			if (profile_img != null || nickName != null){
				IMUtils.getInstants().refreshUser(String.valueOf(uid), u.getNickname(), u.getProfileImg());
			}
			
			//同步搜索
			if(popularNo != null || nickName != null){
				try {
					UserSearchView userSearchView = new UserSearchView();
					userSearchView.setUid(u.getId());
					userSearchView.setNickName(u.getNickname());
					userSearchView.setPopularNo(u.getPopularNo());
					searchService.updateUser(userSearchView);
				} catch (Exception e) {
					log.error("update  search info error",e);
				}
				
			}
		}
		
	}

	@Override
	public void insertUser(UserView userview) throws ServiceException {
		try {
			userServiceClientProxy.insertUser(userview);
			
		} catch (TException e) {
			throw new ServiceException(e);
		}
		
	}

	@Override
	public void updateThirdData(String tid, String type,
			Map<String, String> map) throws ServiceException {
		try {
			userServiceClientProxy.updateThirdData(tid, type, map);
		} catch (TException e) {
			throw new ServiceException(e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see UserService#findContactListByUid()
	 */
	@Override
	public List<ContactView> findContactListByUid(String uid)
			throws ServiceException {
		try {
			return userServiceClientProxy.findContactListByUid(uid);
		} catch (TException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public void insertContactListByUid(List<ContactView> contactViewList)
			throws ServiceException {
		try {
			userServiceClientProxy.insertContactList(contactViewList);
		} catch (TException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public List<ThirdDataView> findThirdDataListByUid(long uid)
			throws ServiceException {
		List<ThirdDataView> thirdDataViewList = null;
		try {
			thirdDataViewList = userServiceClientProxy.findThirdDataListByUid(uid);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
		return thirdDataViewList;
	}

	@Override
	public void deleteThirdData(String tid, String type)
			throws ServiceException {
		try {
			userServiceClientProxy.deleteThirdData(tid, type);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public int saveThirdData(ThirdDataView thirdDataView)
			throws ServiceException {
		try {
			return userServiceClientProxy.saveThirdData(thirdDataView);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public ThirdDataView findThirdDataViewByUidAndType(long uid, String type)
			throws ServiceException {
		try {
			ThirdDataView thirdDataView = userServiceClientProxy.findThirdDataByUidAndType(uid, type);
			return thirdDataView;
		} catch (TException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public List<UserView> findUserListByIds(List<Long> ids)
			throws ServiceException {
		if (ids == null || ids.size() == 0){
			return null;
		}
		try {
			return userServiceClientProxy.findUserListByIds(ids);
		} catch (TException e) {
			throw new ServiceException(e);
		}
	}



	@Override
	public List<UserForbiddenView> findForbiddenByUid(long uid)
			throws ServiceException {
		try {
			return userServiceClientProxy.findForbiddenListByUid(uid);
		} catch (TException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public List<Integer> getForbiddenActionListByUid(long uid)
			throws ServiceException {
		try {
			return userServiceClientProxy.getForbiddenActionListByUid(uid);
		} catch (TException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public int add2BlackList(long currentUser, long target_userid)
			throws ServiceException {
		try {
			return userServiceClientProxy.add2BlackList(currentUser,
					target_userid);
		} catch (TException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public void removeFromBlackList(long currentUser, long target_userid)
			throws ServiceException {
		try {
			 userServiceClientProxy.removeFromBlackList(currentUser,
					target_userid);
		} catch (TException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public List<Long> findBlackList(long currentUser, Integer cursor,
			Integer count) throws ServiceException {
		try {
			return userServiceClientProxy.findBlackList(currentUser, cursor,
					count);
		} catch (TException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public void saveForbiddenView(UserForbiddenView forbiddenView)
			throws ServiceException {
		try {
			userServiceClientProxy.saveForbiddenView(forbiddenView);
		} catch (Exception e) {
			throw new ServiceException(e);
		}

	}

	@Override
	public void deleteForbiddenViewByUid(long uid) throws ServiceException {
		try {
			userServiceClientProxy.deleteForbiddenByUid(uid);
		} catch (Exception e) {
			throw new ServiceException(e);
		}

	}

	@Override
	public void deleteForbiddenViewByUidAndAction(long uid, int action)
			throws ServiceException {
		try {
			userServiceClientProxy.deleteForbiddenByUidAndAction(uid, action);
		} catch (Exception e) {
			throw new ServiceException(e);
		}

	}

	@Override
	public List<BlackListView> findBlackListByUid(long uid,
			Integer cursor, Integer count) throws ServiceException {
		List<BlackListView> list = null;
		try {
			list = userServiceClientProxy.findBlackListByUid(uid, cursor, count);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
		return list;
	}

	@Override
	public List<BlackListView> findBlackListByTid(long uid,
			Integer cursor, Integer count) throws ServiceException {
		List<BlackListView> list = null;
		try {
			list = userServiceClientProxy.findBlackListByTid(uid, cursor,
					count);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
		return list;
	}
	
	
	@Override
	public Integer findCountBlackListByUid(long uid) throws ServiceException {
		int count = 0;
		try {
			count = userServiceClientProxy.findCountBlackListByUid(uid);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
		return count;
	}
	
	@Override
	public Integer findCountBlackListByTid(long uid) throws ServiceException {
		int count = 0;
		try {
			count = userServiceClientProxy.findCountBlackListByTid(uid);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
		return count;
	}

	@Override
	public boolean isAllow(String nickName) throws ServiceException {
		try {
			return userServiceClientProxy.isAllow(nickName);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public boolean userIsForbidden(long uid, int action)
			throws ServiceException {
		boolean flag = false;
		try {
			flag = userServiceClientProxy.userIsForbidden(uid, action);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
		return flag;
	}

	@Override
	public UserView findUserByNickName(String nickName) throws ServiceException {
		try {
			return userServiceClientProxy.findUserByNickName(nickName);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public List<Boolean> findForbiddenListByUidsAndAction(List<Long> uids,
			int action) throws ServiceException {
		try {
			return userServiceClientProxy.findForbiddenListByUidsAndAction(uids, action);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}
	
	@Override
	public SettingView getSettingByUid(String uid) throws ServiceException{
		try {
			return userServiceClientProxy.getSettingByUid(uid);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}
	
	@Override
	public void setSwitch(String uid,Map<String, String> paramMap) throws ServiceException{
		try {
			userServiceClientProxy.setSwitch(uid, paramMap);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}


	
	private void getUniqNickName(UserView userView) throws ServiceException {
		boolean flag = isAllow(userView.getNickname());
		if (!flag) {
			userView.setNickname(userView.getNickname()
					+ RandomUtils.generateNumber(4));
		}
	}

	@Override
	public UserView  registerUser(UserView userView, ThirdDataView thirdDataView) throws ReturnException ,ServiceException {

		int now = (int) (System.currentTimeMillis() / 1000);
		HeaderParams headerParams = XThreadLocal.getInstance().getHeaderParams();
		
		//获取用户id和靓号
		IDView idView = null;
		try {
			idView = idServiceClientProxy.nextIdAndPid();
		} catch (TException e) {
			throw new ServiceException(e);
		}
		
		long uid = idView.id;

		//保存登陆表数据
		thirdDataView.setUid(uid);
		thirdDataView.setCreateTime(now);
		int res = saveThirdData(thirdDataView);
		if (thirdDataView.getType().equals("phone") && res == -1){
			throw new ReturnException("2025");
		}
		
		//保存用户信息数据
		userView.setId(uid);
		userView.setPopularNo(idView.pid);
		userView.setActive(1);
		userView.setMasterLevel(1);
		userView.setFanLevel(1);
		userView.setSignStatus(0);
		userView.setIsrobot(0);
		userView.setRole(0);
		userView.setIsNew(1);
		userView.setLastLoginType("phone");
		if (thirdDataView.getType().equals("phone")){
			userView.setPhoneNumber(thirdDataView.getTid());
		}else{
			if (headerParams != null){
				userView.setPhoneNumber(headerParams.getPhoneNum());
			}
			
		}
		
		//昵称为空或者存在敏感词
		String filterWord = null;
		try{
			filterWord = sensitiveService.filter(userView.getNickname(), 1);
		}catch(ServiceException e){
			log.error(e.getMessage(), e);
		}
		
		if (StringUtils.isBlank(userView.getNickname()) || (filterWord != null && !userView.getNickname().equals(filterWord))) {
			userView.setNickname("ShowCoin新人" + RandomUtils.generateNumber(8));
		}else{
			//生成唯一昵称
			getUniqNickName(userView);
		}
		if (StringUtils.isBlank(userView.getProfileImg())) {
			userView.setProfileImg(Loader.getInstance().getProps("default.profileimg"));
		}
		String lng = null;
		String lat = null;
		if (headerParams != null){
			lng = headerParams.getLongitude();
			lat = headerParams.getLatitude();
		}
		try {
			if (lng != null && !"".equals(lng) && lat != null
					&& !"".equals(lat)) {
				userView.setLongitude(Double.parseDouble(lng));
				userView.setLatitude(Double.parseDouble(lat));
			} 
		} catch (Exception e) {
			log.error("gps parse error, lng : {}, lat : {}", lng, lat,
					e);
		}
		
		String ryToken = IMUtils.getInstants().getToken(uid+"", userView.getNickname(), Adapter.getAvatar(userView.getProfileImg()));
		userView.setRyToken(ryToken);
		userView.setCreateTime(now);
		
		String did = null;
		if (headerParams != null){
			did = headerParams.getDeviceId();
			userView.setDeviceUuid(did);
		}
		
		insertUser(userView);
		
		
		if (did != null && !"".equals(did)) {
			DeviceView dv = deviceService.findDeviceByDid(did);
			if(dv==null){
				//保存设备数据
				dv = new DeviceView();
				dv.setDeviceUuid(did);
				deviceService.saveDevice(dv);
			}
			
			//保存用户和设备对应关系
			UserDeviceView udv = new UserDeviceView();
			udv.setUid(userView.getId());
			udv.setDeviceUuid(did);
			udv.setCreateTime(now);
			deviceService.saveUserDevice(udv);
		}
		
		try {
			UserSearchView userSearchView = new UserSearchView();
			userSearchView.setUid(userView.getId());
			userSearchView.setNickName(userView.getNickname());
			userSearchView.setPopularNo(userView.getPopularNo());
			searchService.insertUser(userSearchView);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		
		
		try {
			
		 	Map map = new HashMap();
			map.put("uid", userView.getId());
			map.put("action", STAT_ACTION.REGISTER.toString());
			map.put("header", headerParams);
			map.put("platform", XThreadLocal.getInstance().getUserAgent().ordinal());
			map.put("time", (int) (System.currentTimeMillis() / 1000));
			
			Publisher.getInstance().sendMessage(JacksonUtil.writeToJsonString(map), Queue.STAT);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		
		
		return userView;

	}

	@Override
	public void updateUserDevice(UserView userView)
			throws ServiceException {
		HeaderParams headerParams = XThreadLocal.getInstance().getHeaderParams();
		if (headerParams == null){
			return;
		}
		String did = headerParams.getDeviceId();
		if (did != null && !"".equals(did)) {
			int currentTimestamp = (int) (System.currentTimeMillis() / 1000);
			DeviceView device = deviceService.findDeviceByDid(did);
			if (device == null) {
				DeviceView dv = new DeviceView();
				dv.setDeviceUuid(did);
				deviceService.saveDevice(dv);
				
				UserDeviceView udv = new UserDeviceView();
				udv.setUid(userView.getId());
				udv.setDeviceUuid(did);
				udv.setCreateTime(currentTimestamp);
				deviceService.saveUserDevice(udv);
			}else{
				UserDeviceView udv = deviceService.findUserDevice(userView.getId(), did);
				if(udv==null){
					udv = new UserDeviceView();
					udv.setUid(userView.getId());
					udv.setDeviceUuid(did);
					udv.setCreateTime(currentTimestamp);
					deviceService.saveUserDevice(udv);
				}
				
				Map<String,String> params = new HashMap<String,String>();
				params.put("app_version", headerParams.getAppVersion());
				params.put("kernel_version", headerParams.getKernelVersion());
				deviceService.updateDevice(did, params);
				
			}
			Map<String, String> map = new HashMap<String, String>();
			map.put("device_uuid", did);
			updateUserById(userView.getId(), map);

		}
		
	}

	private List<UserView> getAllRobots(){
		List<UserView> all = null;
		try {
			all = new LocalCache<List<UserView>>(){
				@Override
				public List<UserView> getAliveObject() throws Exception {
					List<UserView> all = new ArrayList<UserView>();
							
					List<RobotView> list = userServiceClientProxy.findAllRobot();
					int perSize = 200;
					int n = list.size()/perSize;
					int t = list.size()%perSize;
					for (int i = 0; i <= n; i++) {
						int max = (i+1)*perSize;
						if(i==n){
							if(t==0){
								break;
							}else{
								max = i*perSize+t;
							}
						}
						List<Long> ids = new ArrayList<Long>();
						for (int j = i*perSize; j < max; j++) {
							ids.add(list.get(j).getUid());
						}
						List<UserView> users = userServiceClientProxy.findUserListByIds(ids);
						all.addAll(users);
					}
					Collections.sort(all, new Comparator<UserView>() {

						@Override
						public int compare(UserView u1, UserView u2) {
							return u1.getFanLevel()-u2.getFanLevel();
						}
					});
					
					log.info("load robot size:"+all.size()+",robot[0] level:"+all.get(0).getFanLevel());
					return all;
				}
				
			}.put(60 * 60 * 5, "robotList");
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return all;
	}
	
	@Override
	public List<UserView> getRobotList(int num,List<Long> contains){
		if(num<=0){
			return new ArrayList<UserView>();
		}
		List<UserView> all = getAllRobots();
		List<UserView> userViews = new ArrayList<UserView>();
		if(all!=null && !all.isEmpty()){
			Collections.shuffle(all);
			int  n = 0;
			for (UserView uv:all) {
				if(n>=num){
					break;
				}
				if(contains!=null && contains.contains(uv.getId())){
					continue;
				}
				userViews.add(uv);
				n++;
			}
		}
		return userViews;
	}
	

	@Override
	public List<UserView> getRobotList(int minLevel, int maxLevel) {
		List<UserView> all = getAllRobots();
		List<UserView> userViews = new ArrayList<UserView>();
		if(all!=null && !all.isEmpty()){
			for (UserView uv:all) {
				if(uv.getFanLevel()<minLevel||uv.getFanLevel()>maxLevel){
					continue;
				}
				userViews.add(uv);
			}
			Collections.shuffle(all);
		}
		return userViews;
	}
	
	@Override
	public List<UserView> getRobotList(int num) throws ServiceException {
		return getRobotList(num, null);
	}

	@Override
	public UserView findUserByPid(long pid) throws ServiceException {
		try {
			return userServiceClientProxy.findUserByPid(pid);
		} catch (TException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public void saveRoomAdmin(long uid, long tid) throws ServiceException {

		try {
			userServiceClientProxy.saveRoomAdmin(uid, tid);
		} catch (TException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public void deleteRoomAdmin(long uid, long tid) throws ServiceException {

		try {
			userServiceClientProxy.deleteRoomAdmin(uid, tid);
		} catch (TException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public List<Long> findRoomAdminListByUid(long uid, int cursor,
			int count) throws ServiceException {
		try {
			return userServiceClientProxy.findRoomAdminListByUid(uid, cursor, count);
		} catch (TException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public Integer findRoomAdminCountByUid(long uid) throws ServiceException {
		try {
			return userServiceClientProxy.findRoomAdminCount(uid);
		} catch (TException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public boolean isRoomAdmin(long uid, long tid) throws ServiceException {
		try {
			return userServiceClientProxy.isRoomAdmin(uid, tid);
		} catch (TException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public boolean isBlack(long uid, long tid) throws ServiceException {
		try {
			return userServiceClientProxy.isBlack(uid, tid);
		} catch (TException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public void sendPopularNo(long uid, long popularNo)
			throws ServiceException {

		UserView user = findUserById(uid);
		
		int now = TimeUtil.getCurrentTimestamp();
		try {
			
			//保存用户所持有靓号
			UserPopularNoView userPopularNoView = new UserPopularNoView();
			userPopularNoView.setUid(uid);
			userPopularNoView.setPopularNo(popularNo);
			userPopularNoView.setStatus(POPULAR_NO_STATUS.USEING.ordinal());
			userPopularNoView.setCreateTime(now);
			userServiceClientProxy.saveUserPopularNo(userPopularNoView);
			
			//用户当前靓号状态修改为未使用
			userServiceClientProxy.updateUserPopularNoStatus(uid, user.getPopularNo(), POPULAR_NO_STATUS.UNUSED.ordinal());
			
			//修改当前使用靓号
			Map<String, String> updateContent = new HashMap<String, String>();
			updateContent.put("popular_no", String.valueOf(popularNo));
			updateUserById(uid, updateContent);
			
		} catch (Exception e) {
			throw new ServiceException(e);
		}
		
		
		
	}

	@Override
	public void deletePopularNo(long uid, long popularNo)
			throws ServiceException {

		
		try {
			
			List<UserPopularNoView> beforDelUserPopularList = userServiceClientProxy.findUserPopularNoListByUid(uid);
			if (beforDelUserPopularList.size() == 1){
				throw new ServiceException("用户只有一个靓号，不能删除");
			}
			UserView user = findUserById(uid);
			
			//删除用户所持有靓号
			userServiceClientProxy.deleteUserPopularNo(uid, popularNo);
			
			//删除的靓号是用户正在使用的，需要给用户分配一个过去持用的靓号
			if (user.getPopularNo() == popularNo){
				
				List<UserPopularNoView> afterDelUserPopularList = userServiceClientProxy.findUserPopularNoListByUid(uid);
				//随便给选一个过去持用的靓号
				long assignedPopularNo = afterDelUserPopularList.get(0).getPopularNo();
				//修改靓号状态为使用中
				userServiceClientProxy.updateUserPopularNoStatus(uid, assignedPopularNo, POPULAR_NO_STATUS.USEING.ordinal());
				
				//修改使用靓号
				Map<String, String> updateContent = new HashMap<String, String>();
				updateContent.put("popular_no", String.valueOf(assignedPopularNo));
				updateUserById(uid, updateContent);
			}
			
			
		} catch (Exception e) {
			throw new ServiceException(e);
		}
		
	}

	@Override
	public List<UserPopularNoView> findPopularNoListByUid(long uid) throws ServiceException {

		List<UserPopularNoView> list = null;
		try {
			list = userServiceClientProxy.findUserPopularNoListByUid(uid);
		} catch (TException e) {
			throw new ServiceException(e);
		}
		
		return list;
		
	}

	@Override
	public void deletetUserById(Long uid) throws ServiceException {

		try {
			userServiceClientProxy.deleteUser(uid);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
		
		//同步索引
		try {
			searchService.deleteUser(uid);
		} catch (Exception e) {
			log.error("update  search info error",e);
		}
		
	}

	@Override
	public void deleteThirdDataByUidAndType(long uid, String thirdType) {
		try {
			ThirdDataView td = userServiceClientProxy.findThirdDataByUidAndType(uid, thirdType);
			if(td!=null){
				userServiceClientProxy.deleteThirdData(td.getTid(), thirdType);
			}
		} catch (Exception e) {
			log.error("update  search info error",e);
		}
	}

}