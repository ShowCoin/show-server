package one.show.video.service;

import java.util.Map;

import one.show.common.exception.ServiceException;
import one.show.video.domain.LiveUser;
import one.show.video.domain.ReturnList;

public interface LiveUserService {
	
	/**
	 * 保存直播用户
	 * @param liveUser
	 * @throws ServiceException
	 */
	public void save(LiveUser liveUser) throws ServiceException;
	
	/**
	 * 根据UID获得直播列表
	 * @param uid
	 * @param sort
	 * @param condition
	 * @param start
	 * @param count
	 * @return
	 * @throws ServiceException
	 */
	public ReturnList<LiveUser> getLiveListByUid(Long uid, String sort,Map<String, String> condition, Integer start, Integer count) throws ServiceException;
	
	/**
	 * 根据UID获得直播数量
	 * @param uid
	 * @param condition
	 * @return
	 * @throws ServiceException
	 */
	public Integer getLiveCountByUid(Long uid, Map<String, String> condition) throws ServiceException;

	/**
	 * 根据uid和liveId获得直播用户
	 * @param uid
	 * @param liveid
	 * @return
	 * @throws ServiceException
	 */
	public LiveUser findLiveUser(long uid,long liveid) throws ServiceException;
	
	/**
	 * 更新直播用户
	 * @param uid
	 * @param liveId
	 * @param updateContent
	 * @throws ServiceException
	 */
	public void updateLiveUser(long uid, long liveId,Map<String, String> updateContent) throws ServiceException;
}
