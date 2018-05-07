/**
 * 
 */
package one.show.relation.service;

import java.util.List;

import one.show.common.exception.ServiceException;
import one.show.relation.domain.Fans;

/**
 * @author kevin 
 *
 */
public interface FansService {
	
	public List<Fans> findListByUid(Long uid, Integer start, Integer count) throws ServiceException;
	
	public void save(Fans fans) throws ServiceException;
	
	public void delete(Long uid, Long fid) throws ServiceException;

	public Integer findFansCountByUid(Long uid) throws ServiceException;
}


