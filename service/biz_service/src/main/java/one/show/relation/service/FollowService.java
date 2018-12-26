package one.show.relation.service;

import java.util.List;

import one.show.common.exception.ServiceException;
import one.show.relation.domain.Follow;

/**
 * @author kevin 
 * 
 */
public interface FollowService {
	
	List<Follow> findListByUid(Long uid, Integer start, Integer count) throws ServiceException;
	
	void save(Follow follow) throws ServiceException;
	
	void delete(Long uid, Long fid) throws ServiceException;

	List<Boolean> isFollowed(Long currentUser, List<Long> uids);
	
	List<Boolean> isFans(Long currentUser, List<Long> uids);
	
	Integer findFollowCountByUid(Long uid) throws ServiceException;

	void disLike(Follow follow) throws ServiceException;
	
}


