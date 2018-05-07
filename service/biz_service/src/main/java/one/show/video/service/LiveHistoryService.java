package one.show.video.service;

import java.util.List;
import java.util.Map;

import one.show.common.exception.ServiceException;
import one.show.video.domain.LiveHistory;

public interface LiveHistoryService {
	
	public void save(LiveHistory liveHistory) throws ServiceException;
	
	public List<LiveHistory> findLiveHistoryListByIds(List<Long> ids);
	
	public LiveHistory findLiveHistoryListById(Long liveId) throws ServiceException;

	public void update(long liveid,Map<String, String> updateContent) throws ServiceException;
	
}
