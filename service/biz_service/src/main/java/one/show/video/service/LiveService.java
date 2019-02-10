package one.show.video.service;

import java.util.List;
import java.util.Map;

import one.show.common.exception.ServiceException;
import one.show.video.domain.Live;

public interface LiveService {

	/**
	 * 开始直播
	 * 
	 * @param live
	 * @throws ServiceException
	 */
	public void startLive(Live live) throws ServiceException;

	/**
	 * 暂停直播
	 * 
	 * @param live
	 * @throws ServiceException
	 */
	public void resumeLive(Live live) throws ServiceException;

	/**
	 * 结束直播
	 * 
	 * @param live
	 * @throws ServiceException
	 */
	public void endLive(Live live) throws ServiceException;

	/**
	 * 断流
	 * 
	 * @param live
	 * @throws ServiceException
	 */
	public void streamBreak(Live live) throws ServiceException;

	/**
	 * 保存直播
	 * 
	 * @param live
	 * @throws ServiceException
	 */
	public void save(Live live) throws ServiceException;

	/**
	 * 根据ID删除直播
	 * 
	 * @param liveId
	 * @throws ServiceException
	 */
	public void deleteById(Long liveId) throws ServiceException;

	/**
	 * 根据uid和直播状态删除直播记录
	 * 
	 * @param uid
	 * @param status
	 * @throws ServiceException
	 */
	public void deleteByUidAndStatus(Long uid, Integer status) throws ServiceException;

	/**
	 * 获取用户正在直播的记录
	 * 
	 * @param uid
	 * @return
	 * @throws ServiceException
	 */
	public Live findInLiveByUid(Long uid) throws ServiceException;

	/**
	 * 根据LiveID获得直播信息
	 * 
	 * @param liveId
	 * @return
	 * @throws ServiceException
	 */
	public Live findByLiveId(Long liveId) throws ServiceException;

	/**
	 * 根据LiveID列表获得直播列表信息
	 * @param ids
	 * @return
	 * @throws ServiceException
	 */
	public List<Live> findByLiveIds(List<Long> ids) throws ServiceException;

	/**
	 * 直播分页
	 * @param condition
	 * @param sort
	 * @param start
	 * @param count
	 * @return
	 * @throws ServiceException
	 */
	public List<Live> findLiveList(Map<String, String> condition, String sort, Integer start, Integer count)
			throws ServiceException;

	public List<Live> findLiveList4Square(String sort, Integer start, Integer count) throws ServiceException;

	public List<Live> findLiveList4HandSort(Integer start, Integer count) throws ServiceException;

	/**
	 * 根据直播条件获得条数
	 * @param condition
	 * @return
	 * @throws ServiceException
	 */
	public Integer findLiveListCount(Map<String, String> condition) throws ServiceException;

	/**
	 * 更新直播信息
	 * @param liveId
	 * @param updateContent
	 * @throws ServiceException
	 */
	public void update(Long liveId, Map<String, String> updateContent) throws ServiceException;

	/**
	 * 直播时长
	 * 
	 * @param uid
	 * @param startTime
	 * @param endTime
	 * @return
	 * @throws ServiceException
	 */
	public Integer findLiveDurationByUid(Long uid, Integer startTime, Integer endTime) throws ServiceException;

	/**
	 * 直播有效天数
	 * 
	 * @param uid
	 * @param startTime
	 * @param endTime
	 * @return
	 * @throws ServiceException
	 */
	public Integer findLiveEffectiveDaysByUid(Long uid, Integer startTime, Integer endTime) throws ServiceException;

	/**
	 * 累计直播时长
	 * 
	 * @param uid
	 * @return
	 * @throws ServiceException
	 */
	public Integer findLiveTotalDurationByUid(Long uid) throws ServiceException;

}
