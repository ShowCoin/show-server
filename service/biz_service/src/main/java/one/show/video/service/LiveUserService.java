package one.show.video.service;

import java.util.Map;

import one.show.common.exception.ServiceException;
import one.show.video.domain.LiveUser;
import one.show.video.domain.ReturnList;

public interface LiveUserService {
	
	public void save(LiveUser liveUser) throws ServiceException;
	
	public ReturnList<LiveUser> getLiveListByUid(Long uid, String sort,Map<String, String> condition, Integer start, Integer count) throws ServiceException;
	
	public Integer getLiveCountByUid(Long uid, Map<String, String> condition) throws ServiceException;

	public LiveUser findLiveUser(long uid,long liveid) throws ServiceException;
	
	public void updateLiveUser(long uid, long liveId,Map<String, String> updateContent) throws ServiceException;
}
