/**
 * 
 */
package one.show.relation.service;

import java.util.List;
import java.util.Map;

import one.show.common.exception.ServiceException;
import one.show.relation.domain.Feed;

/**
 * @author kevin 
 *
 */
public interface FeedService {
	
	public List<Feed> findListByUid(Long uid, Map<String, String> condition, Integer start, Integer count) throws ServiceException;
	
	public void save(Feed feed) throws ServiceException;
	
	public void delete(Long uid, Long fid, String point) throws ServiceException;
	
	public void update(Long uid, Long fid, String point, Map<String, String> updateContent) throws ServiceException;

}


