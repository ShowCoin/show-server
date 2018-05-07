package one.show.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import one.show.common.Adapter;
import one.show.common.Constant;
import one.show.common.Constant.CDN;
import one.show.common.Constant.LIVE_END_REASON;
import one.show.common.Constant.LIVE_STATUS;
import one.show.common.Constant.STATUS;
import one.show.common.Constant.STAT_ACTION;
import one.show.common.Constant.WANGSU_NGB;
import one.show.common.JacksonUtil;
import one.show.common.RandomUtils;
import one.show.common.cache.LocalCache;
import one.show.common.cdn.WCNGBSDK;
import one.show.common.client.redis.JedisUtil;
import one.show.common.exception.ServiceException;
import one.show.common.im.ChatRoomMessage;
import one.show.common.im.IMUtils;
import one.show.common.im.MessageFactory;
import one.show.common.mq.Publisher;
import one.show.common.mq.Queue;
import one.show.id.thrift.iface.IDServiceProxy;
import one.show.manage.thrift.view.SystemConfigView;
import one.show.manage.thrift.view.UserCDNView;
import one.show.service.ManageService;
import one.show.service.StatService;
import one.show.service.UserService;
import one.show.service.VideoService;
import one.show.stat.thrift.view.VideoStatView;
import one.show.user.thrift.view.UserView;
import one.show.video.thrift.iface.VideoServiceProxy;
import one.show.video.thrift.view.LiveHistoryView;
import one.show.video.thrift.view.LiveHistoryViewList;
import one.show.video.thrift.view.LiveRecordView;
import one.show.video.thrift.view.LiveUserView;
import one.show.video.thrift.view.LiveView;

import org.apache.thrift.TException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import scala.collection.immutable.StreamView;

/**
 * 
 * @author Haliaeetus leucocephalus
 *
 */
@Component("videoService")
public class VideoServiceImpl implements VideoService {
	
	private static final Logger log = LoggerFactory.getLogger(VideoServiceImpl.class);

	@Autowired
	protected ManageService manageService;
	 
	@Autowired
	private VideoServiceProxy.Iface videoServiceClientProxy;
	
//	@Autowired
//	private StreamServiceProxy.Iface streamServiceClientProxy;
	
	@Autowired
	private IDServiceProxy.Iface idServiceClientProxy;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private StatService statService;
	
	@Override
	public LiveView getLiveById(Long liveId) throws ServiceException {

		try {
			return videoServiceClientProxy.findLiveById(liveId);
		} catch (TException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public Long initLive(LiveView liveView) throws ServiceException {

		try {
			Long liveId = idServiceClientProxy.nextId();
			liveView.setLiveId(liveId);
			//初始化假人
			liveView.setRobotNumber(RandomUtils.getRandomInteger(3, 11));
			String streamName = String.valueOf(liveId) +"_"+ (int)(System.currentTimeMillis()/1000);
			liveView.setRtmp(Adapter.getRtmpAddr(streamName, liveView.getCdnType()));
			
			int ngb = 0;
			liveView.setCdnType(CDN.WANGSU.ordinal());
			UserCDNView userCDNView =  null;
			try {
				userCDNView = manageService.findUserCDNById(liveView.getUid());
				if (userCDNView == null){
					userCDNView = manageService.findUserCDNById(0);
				}
			} catch (ServiceException e) {
				log.error(e.getMessage(), e);
			}
			if (userCDNView != null){
				liveView.setCdnType(userCDNView.getCdnType());
				ngb = userCDNView.getNgb();
				if (userCDNView.getRtmp() != null && !userCDNView.getRtmp().equals("")){
					liveView.setRtmp("rtmp://"+userCDNView.getRtmp()+"/live/"+streamName+"?wsHost=push1.xiubi.com");
				}
				
			}
			
			//网宿NGB开关
			if (ngb == WANGSU_NGB.ON.ordinal() && liveView.getCdnType() == CDN.WANGSU.ordinal()){
				try {
					String rtmp = new WCNGBSDK().ngbRequest(Adapter.getRtmpAddr(streamName, liveView.getCdnType()), liveView.getIp(), 3);
					liveView.setRtmp(rtmp);
				} catch (Exception e) {
					liveView.setRtmp(Adapter.getRtmpAddr(streamName, liveView.getCdnType()));
				}
			}
			
			liveView.setVodStatus(STATUS.DISABLE.ordinal());
			liveView.setStreamName(streamName);
			liveView.setCreateTime((int)(System.currentTimeMillis()/1000));
		} catch (TException e) {
			throw new ServiceException(e);
		}
		
		try {
			SystemConfigView systemConfigView = new LocalCache<SystemConfigView>() {
				@Override
				public SystemConfigView getAliveObject() throws Exception {
						return manageService.getSystemConfig(Constant.SYSTEM_CONFIG_ID);
				}
			}.put(60*5, "systemConfig");
			
			liveView.setWidth(systemConfigView.getWidth());
			liveView.setHeight(systemConfigView.getHeight());
			liveView.setFrame(systemConfigView.getFrame());
			liveView.setBitrate(systemConfigView.getBitrate());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		
		
		liveView.setStatus(LIVE_STATUS.READY.ordinal());
		liveView.setVodStatus(STATUS.DISABLE.ordinal());
		
		try {
			videoServiceClientProxy.initLive(liveView);
		} catch (TException e) {
			throw new ServiceException(e);
		}
		return liveView.getLiveId();
	}

	@Override
	public void openStream(LiveView liveView) throws ServiceException {

//		try {
//			streamServiceClientProxy.init(liveView.getStreamName(), liveView.getCdnType(), liveView.getRtmp());
//			
//		} catch (TException e) {
//			throw new ServiceException(e);
//		}
	}

	@Override
	public void endLive(LiveView liveView) throws ServiceException {

		try {
			videoServiceClientProxy.endLive(liveView.getLiveId(), liveView.getReason());
			
//			streamServiceClientProxy.close(liveView.getStreamName(), liveView.getCdnType(), liveView.getRtmp());
			
			if(liveView.getReason()==LIVE_END_REASON.AUDIT.ordinal()){
				deleteHistory(liveView.getUid(), liveView.getLiveId());
			}
		} catch (TException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public LiveView getInLiveByUid(Long uid) throws ServiceException {
		try {
			return videoServiceClientProxy.findInLiveByUid(uid);
		} catch (TException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public Integer getLiveListCount(Map<String, String> condition) throws ServiceException {
		try {
			return videoServiceClientProxy.findLiveListCount(condition);
		} catch (TException e) {
			throw new ServiceException(e);
		}
	}
	
	@Override
	public List<LiveView> getLiveList(Map<String, String> condition, String sort, Integer start, Integer count) throws ServiceException {
		try {
			return videoServiceClientProxy.findLiveList(condition, sort, start, count);
		} catch (TException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public LiveHistoryViewList getLiveHistoryByUid(Long uid, String sort, Map<String, String> condition, Integer start, Integer count) throws ServiceException {
		try {
			return videoServiceClientProxy.findLiveHistoryByUid(uid, sort,condition, start, count);
		} catch (TException e) {
			throw new ServiceException(e);
		}
	}


//	@Override
//	public List<StreamView> getAllStreamList() throws ServiceException {
//		try {
//			return streamServiceClientProxy.getAllStreamList();
//			
//		} catch (TException e) {
//			throw new ServiceException(e);
//		}
//	}

	@Override
	public void updateLiveView(long liveId, Map<String, String> params)
			throws ServiceException {
		try {
			videoServiceClientProxy.updateLive(liveId, params);
		} catch (TException e) {
			log.error("updateLive error."+liveId,e);
			throw new ServiceException(e);
		}
	}

	@Override
	public List<LiveHistoryView> getLiveHistoryByIds(List<Long> ids)
			throws ServiceException {
		try {
			return videoServiceClientProxy.findLiveHistoryByIds(ids);
		} catch (TException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public LiveHistoryView getLiveHistoryById(Long liveId)
			throws ServiceException {

		try {
			return videoServiceClientProxy.findLiveHistoryById(liveId);
		} catch (TException e) {
			throw new ServiceException(e);
		}
	}


	@Override
	public Integer getLiveHistoryCountByUid(Long uid, Map<String, String> condition)
			throws ServiceException {
		try {
			return videoServiceClientProxy.findLiveHistoryCountByUid(uid, condition);
		} catch (TException e) {
			throw new ServiceException(e);
		}
	
	}
	
	@Override
	public int getRoomTotal(int trueValue,int robotNum){
		float percent = 1.0f+(System.currentTimeMillis()%20-10)/100.0f;
		int total = Math.round(trueValue*1.5f)+Math.round(robotNum*percent);
		log.info("truevalue:"+trueValue+",robotNumber:"+robotNum+",percent:"+percent+",total:"+total);
		return total;
	}
	
	@Override
	public List<UserView> getRoomUserList(LiveView liveView) throws ServiceException{
		if(liveView==null){
			return null;
		}
		List<Long> ids = IMUtils.getInstants().queryChatRoomUsers(liveView.getLiveId()+"");
		log.info("room user size======="+ids.size()+",master uid========"+liveView.getUid());
		int total = getRoomTotal(ids.size(),liveView.getRobotNumber());
		return getRoomUserList(liveView, ids, total);
	}
	
	@Override
	public List<UserView> getRoomUserList(LiveView liveView,List<Long> ids,int total) throws ServiceException{
		List<UserView> all =  new ArrayList<UserView>();
		if(ids!=null){
			List<Long> users = new ArrayList<Long>();
			for (int i = ids.size()-1; i >= 0; i--) {
				if(users.size()==500){
					break;
				}
				//剔除自己
				if(ids.get(i).longValue()==liveView.getUid()){
					continue;
				}
				users.add(ids.get(i));
			}
			ids = users;
			
			int perSize = 100;
			int n = ids.size()/perSize;
			int t = ids.size()%perSize;
			for (int i = 0; i <= n; i++) {
				int max = (i+1)*perSize;
				if(i==n){
					if(t==0){
						break;
					}else{
						max = i*perSize+t;
					}
				}
				List<Long> idList = new ArrayList<Long>();
				for (int j = i*perSize; j < max; j++) {
					idList.add(ids.get(j));
				}
				List<UserView> userViewList = userService.findUserListByIds(idList);
				all.addAll(userViewList);
			}
		}
		
		int robotNum = total-all.size();
		if(robotNum>0){
			List<UserView> robots = getRobotUser(liveView.getLiveId(),robotNum);
			all.addAll(robots);
		}
		Collections.sort(all, new Comparator<UserView>(){  
			public int compare(UserView arg0, UserView arg1) {  
				return arg1.getFanLevel() - arg0.getFanLevel();
			}  
		}); 
		int totalValue = total>(all.size()+1)?total:(all.size()+1);
		VideoStatView videoStatView = statService.findVideoStatByVid(liveView.getLiveId());
		if(videoStatView!=null){
			totalValue+=videoStatView.getGiftNum()+videoStatView.getLiked()+videoStatView.getShare();
		}
		liveView.setViewed(totalValue);
		Map<String, String> params = new HashMap<String, String>();
		params.put("viewed", totalValue+"");
		updateLiveView(liveView.getLiveId(), params);
		return all;
	}
	
	private List<UserView> getRobotUser(long liveid,int count) throws ServiceException{
		log.info("getrobotuser:liveid="+liveid+",count="+count);
		String key = "liveRobot:"+liveid;
		Object obj = JedisUtil.get(key);
		List<UserView> userList = null;
		if(obj==null){
			userList = userService.getRobotList(count);
		}else{
			userList = (List<UserView>)obj;
			if(userList.size()<count){
				List<Long> ids = new ArrayList<Long>();
				for(UserView uv:userList){
					ids.add(uv.getId());
				}
				List<UserView> list = userService.getRobotList(count-userList.size(),ids);
				log.info("got robot yet. size="+list.size());
				userList.addAll(list);
			}else if(userList.size()>count){
				Collections.shuffle(userList);
				userList = new ArrayList(userList.subList(0, count));
			}
		}
		JedisUtil.set(key, userList,1800);
		log.info("count="+count+",got robot list size="+userList.size());
		return userList;
	}

	@Override
	public void updateLiveUserList(LiveView liveView) throws ServiceException {
		List<Long> ids = IMUtils.getInstants().queryChatRoomUsers(liveView.getLiveId()+"");
		/*
		try {

		 	Map map = new HashMap();
			map.put("action", STAT_ACTION.ONLINE.toString());
			map.put("uid", liveView.getUid());
			map.put("live_id", liveView.getLiveId());
			map.put("online_count", ids.size());
			map.put("time", (int) (System.currentTimeMillis() / 1000));
			
			Publisher.getInstance().sendMessage(JacksonUtil.writeToJsonString(map), Queue.STAT);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		*/
		
		int total = getRoomTotal(ids.size(),liveView.getRobotNumber());
		
		final List<UserView> all =  getRoomUserList(liveView, ids, total);
		int max = 20>all.size()?all.size():20;
		JSONArray userList = new JSONArray();
		for (int i = 0; i < max; i++) {
			UserView uv = all.get(i);
			JSONObject json = new JSONObject();
			try {
				json.put("uid", uv.getId());
				json.put("profileImg",uv.getProfileImg());
				json.put("fanLevel",uv.getFanLevel());
			} catch (JSONException e) {
				log.error("updateLiveUserList error.",e);
			}
			userList.put(json);
		}
		ChatRoomMessage msg = MessageFactory.createUpdateUseListMessage(liveView.getViewed(),userList);
		IMUtils.getInstants().publishChatroomMessage(liveView.getLiveId()+"", msg);
		
		/**
		 * 每次1的假人点赞，概率20%
		 */
		final long liveid = liveView.getLiveId();
//		new AsyncHandler(){
//			@Override 
//			public void task() {
				int n = 1;
				List<UserView> robots = userService.getRobotList(1,3);
				if(robots!=null){
					Random r = new Random();
					for (int i = 0; i < n; i++) {
						int k = r.nextInt(5);
						if(k==0){
							UserView user = robots.get(i);
							try {
								ChatRoomMessage message = MessageFactory.createHeartMessage(user.getId(), user.getNickname(), user.getFanLevel(), 0);
								IMUtils.getInstants().publishChatroomMessage(liveid+"", message);
							} catch (ServiceException e) {
								log.error("publish chatroom message error.", e);
							}
							
							try {
								
								Map map = new HashMap();
								map.put("uid", user.getId());
								map.put("action", STAT_ACTION.LIKE.toString());
								map.put("vid", liveid);
								map.put("tid", liveView.getUid());
								map.put("time", (int) (System.currentTimeMillis() / 1000));
								
								Publisher.getInstance().sendMessage(JacksonUtil.writeToJsonString(map), Queue.STAT);
							} catch (Exception e) {
								log.error(e.getMessage(), e);
							}
//							try {
//								Thread.sleep(10000);
//							} catch (InterruptedException e) {
//								log.error("sleep interupte.",e);
//							}
						}
					}
				}
//			}
		  
//		}.handle("robot likes,liveid= : "+ liveView.getLiveId());
		
	}

	@Override
	public LiveUserView findLiveUserView(long uid, long liveid)
			throws ServiceException {
		try {
			return videoServiceClientProxy.findLiveUser(uid, liveid);
		} catch (TException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public void updateLiveUserView(long uid, long liveId,
			Map<String, String> updateContent) throws ServiceException {
		try {
			videoServiceClientProxy.updateLiveUser(uid, liveId, updateContent);
		} catch (TException e) {
			throw new ServiceException(e);
		}
	}


	@Override
	public void updateLiveHistoryView(long liveId, Map<String, String> params)
			throws ServiceException {
		try {
			videoServiceClientProxy.updateLiveHistory(liveId, params);
		} catch (TException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public LiveRecordView findLiveRecordViewById(long id) throws ServiceException {
		try {
			return videoServiceClientProxy.findById(id);
		} catch (TException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public List<LiveRecordView> findLiveRecordViewByLiveid(long liveid) throws ServiceException {
		try {
			return videoServiceClientProxy.findByLiveid(liveid);
		} catch (TException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public int saveLiveRecordView(LiveRecordView record) throws ServiceException {
		try {
			return videoServiceClientProxy.save(record);
		} catch (TException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public void updateLiveRecordViewStatusByLiveId(long liveid, int status) throws ServiceException {
		try {
			videoServiceClientProxy.updateStatusByLiveId(liveid, status);
		} catch (TException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public List<LiveRecordView> findLiveRecordViewByStatus(int status)
			throws ServiceException {
		try {
			return videoServiceClientProxy.findByStatus(status);
		} catch (TException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public void deleteLiveRecord(long id) throws ServiceException {
		try {
			videoServiceClientProxy.deleteLiveRecord(id);
		} catch (TException e) {
			log.error("deleteLiveRecord error."+e.getMessage());
			throw new ServiceException(e);
		}
	}

	@Override
	public List<LiveRecordView> findLiveRecordViewByPersistentId(
			String persistentId) throws ServiceException {
		try {
			return videoServiceClientProxy.findByPersistentId(persistentId);
		} catch (TException e) {
			log.error("findLiveRecordViewByPersistentId error."+e.getMessage());
			throw new ServiceException(e);
		}
	}

	@Override
	public void updateLiveRecordViewPersistentIdByLiveId(long liveid,int format,
			String persistentId,int status) throws ServiceException {
		try {
			videoServiceClientProxy.updatePersistentIdByLiveId(liveid, format, persistentId,status);
		} catch (TException e) {
			log.error("updateLiveRecordViewPersistentIdByLiveId error."+e.getMessage());
			throw new ServiceException(e);
		}
	}

	@Override
	public List<LiveView> getLiveByIds(List<Long> ids) throws ServiceException {
		
		try {
			return videoServiceClientProxy.findLiveByIds(ids);
		} catch (TException e) {
			throw new ServiceException(e);
		}
	
	}

	@Override
	public void breakStream(LiveView liveView) throws ServiceException {

//		try {
//			streamServiceClientProxy.breakStream(liveView.getStreamName(), liveView.getCdnType(), liveView.getRtmp());
//		} catch (TException e) {
//			throw new ServiceException(e);
//		}
	}

	@Override
	public List<LiveView> getLiveList4Square(String sort, Integer start,
			Integer count) throws ServiceException {
		
		try {
			return videoServiceClientProxy.findLiveList4Square(sort, start, count);
		} catch (TException e) {
			throw new ServiceException(e);
		}
	
	}

	@Override
	public void deleteHistory(long uid, long liveId) throws ServiceException {

		Map<String, String> updateContent  = new HashMap<String, String>();
		updateContent.put("status", String.valueOf(STATUS.DISABLE.ordinal()));
		
		Map<String, String> updateLive  = new HashMap<String, String>();
		updateLive.put("status", String.valueOf(LIVE_STATUS.INVALID.ordinal()));
		try {
			updateLiveUserView(uid, liveId, updateContent);
			updateLiveHistoryView(liveId, updateContent);
			updateLiveView(liveId, updateLive);
		} catch (ServiceException e) {
			throw e;
		}
		
	}

	@Override
	public Integer findLiveDurationByUid(Long uid, Integer startTime,
			Integer endTime) throws ServiceException {
		
		try {
			return videoServiceClientProxy.findLiveDurationByUid(uid, startTime, endTime);
		} catch (TException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public Integer findLiveEffectiveDaysByUid(Long uid, Integer startTime,
			Integer endTime) throws ServiceException {
		
		try {
			return videoServiceClientProxy.findLiveEffectiveDaysByUid(uid, startTime, endTime);
		} catch (TException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public List<LiveView> getLiveList4HandSort(Integer start, Integer count)
			throws ServiceException {
		try {
			return videoServiceClientProxy.findLiveList4HandSort(start, count);
		} catch (TException e) {
			throw new ServiceException(e);
		}
	}
	
}