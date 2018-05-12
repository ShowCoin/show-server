package one.show.video.service;

import java.util.List;
import java.util.Map;

import one.show.common.exception.ServiceException;
import one.show.video.domain.LiveHistory;

public interface LiveHistoryService {
	
	/**
	 * 保存直播回放
	 * @param liveHistory
	 * @throws ServiceException
	 */
	public void save(LiveHistory liveHistory) throws ServiceException;
	
	/**
	 * 根据ids获得直播回放列表
	 * @param ids
	 * @return
	 */
	public List<LiveHistory> findLiveHistoryListByIds(List<Long> ids);
	
	/**
	 * 根据直播ID获得回放
	 * @param liveId
	 * @return
	 * @throws ServiceException
	 */
	public LiveHistory findLiveHistoryListById(Long liveId) throws ServiceException;

	/**
	 * 更新直播信息
	 * @param liveid
	 * @param updateContent
	 * @throws ServiceException
	 */
	public void update(long liveid,Map<String, String> updateContent) throws ServiceException;
	
}
