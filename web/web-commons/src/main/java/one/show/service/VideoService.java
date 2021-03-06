package one.show.service;

import java.util.List;
import java.util.Map;

import one.show.common.exception.ServiceException;
import one.show.user.thrift.view.UserView;
import one.show.video.thrift.view.LiveHistoryView;
import one.show.video.thrift.view.LiveHistoryViewList;
import one.show.video.thrift.view.LiveRecordView;
import one.show.video.thrift.view.LiveUserView;
import one.show.video.thrift.view.LiveView;


public interface VideoService {
	
	/**
	 * 根据id获取直播
	 * @param liveId
	 * @return
	 * @throws ServiceException
	 */
	public LiveView getLiveById(Long liveId) throws ServiceException;
	
	/**
	 * 根据uid获取当前直播
	 * @param uid
	 * @return
	 * @throws ServiceException
	 */
	public LiveView getInLiveByUid(Long uid) throws ServiceException;
	
	/**
	 * 根据id列表获取直播列表
	 * @param ids
	 * @return
	 * @throws ServiceException
	 */
	public List<LiveView> getLiveByIds(List<Long> ids)throws ServiceException;
	
	/**
	 * 根据uid获取历史直播列表
	 * @param uid
	 * @param sort
	 * @param condition
	 * @param start
	 * @param count
	 * @return
	 * @throws ServiceException
	 */
	public LiveHistoryViewList getLiveHistoryByUid(Long uid, String sort, Map<String, String> condition, Integer start, Integer count) throws ServiceException;
	
	/**
	 * 根据uid获取历史作品数量
	 * @param uid
	 * @param condition
	 * @return
	 * @throws ServiceException
	 */
	public Integer getLiveHistoryCountByUid(Long uid, Map<String, String> condition) throws ServiceException;
	
	/**
	 * 根据ids获取历史作品列表
	 * @param ids
	 * @return
	 * @throws ServiceException
	 */
	public List<LiveHistoryView> getLiveHistoryByIds(List<Long> ids)throws ServiceException;
	
	/**
	 * 根据id获取历史作品
	 * @param liveId
	 * @return
	 * @throws ServiceException
	 */
	public LiveHistoryView getLiveHistoryById(Long liveId)throws ServiceException;
	
	/**
	 * 根据条件获取作品列表
	 * @param condition
	 * @return
	 * @throws ServiceException
	 */
	public Integer getLiveListCount(Map<String, String> condition) throws ServiceException;
	
	/**
	 * 根据条件排序获取直播列表
	 * @param condition
	 * @param sort
	 * @param start
	 * @param count
	 * @return
	 * @throws ServiceException
	 */
	public List<LiveView> getLiveList(Map<String, String> condition, String sort, Integer start, Integer count) throws ServiceException;
	
	public List<LiveView> getLiveList4Square(String sort, Integer start, Integer count) throws ServiceException;
	
	public List<LiveView> getLiveList4HandSort(Integer start, Integer count) throws ServiceException;
	
	/**
	 * 初始化直播间
	 * @param liveView
	 * @return
	 * @throws ServiceException
	 */
	public Long initLive(LiveView liveView) throws ServiceException;
	
	/**
	 * 打开视频流
	 * @param liveView
	 * @throws ServiceException
	 */
	public void openStream(LiveView liveView) throws ServiceException;
	
	/**
	 * 中断视频流
	 * @param liveView
	 * @throws ServiceException
	 */
	public void breakStream(LiveView liveView) throws ServiceException;
	
//	public List<StreamView> getAllStreamList() throws ServiceException;
	
	public void endLive(LiveView liveView) throws ServiceException;
	
	public void updateLiveView(long liveId,Map<String, String> params) throws ServiceException;
	
	public void updateLiveHistoryView(long liveId,Map<String, String> params) throws ServiceException;
	
	public void updateLiveUserList(LiveView liveView) throws ServiceException;
	
	public LiveUserView findLiveUserView(long uid,long liveid) throws ServiceException;
	
	public void updateLiveUserView(long uid, long liveId,Map<String, String> updateContent) throws ServiceException;
	
	public LiveRecordView findLiveRecordViewById(long id) throws ServiceException;

	public List<LiveRecordView> findLiveRecordViewByLiveid(long liveid) throws ServiceException;
	
	public List<LiveRecordView> findLiveRecordViewByPersistentId(String persistentId) throws ServiceException;

	public int saveLiveRecordView(LiveRecordView record) throws ServiceException;

	void updateLiveRecordViewStatusByLiveId(long liveid, int status) throws ServiceException;
	
	void updateLiveRecordViewPersistentIdByLiveId(long liveid, int format, String persistentId,int status) throws ServiceException;
	
	public List<LiveRecordView> findLiveRecordViewByStatus(int status) throws ServiceException;
	
	public void deleteLiveRecord(long id) throws ServiceException;
	
	public List<UserView> getRoomUserList(LiveView liveView) throws ServiceException;
	
	 public List<UserView> getRoomUserList(LiveView liveView,List<Long> ids,int total) throws ServiceException;
	
	/**
	 * 删除回放
	 * @param uid
	 * @param liveId
	 * @throws ServiceException
	 */
	public void deleteHistory(long uid, long liveId)  throws ServiceException;
	
	public int getRoomTotal(int trueValue,int robotNum);
	
	/**
	 * 直播时长
	 * @param uid
	 * @param startTime
	 * @param endTime
	 * @return
	 * @throws ServiceException
	 */
	public Integer findLiveDurationByUid(Long uid,  Integer startTime,  Integer endTime) throws ServiceException;
	
	/**
	 * 直播有效天数
	 * @param uid
	 * @param startTime
	 * @param endTime
	 * @return
	 * @throws ServiceException
	 */
	public Integer findLiveEffectiveDaysByUid(Long uid,  Integer startTime, Integer endTime) throws ServiceException;

}