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
	
	/**
	 * 根据uid获取用户粉丝列表
	 */
	public List<Fans> findListByUid(Long uid, Integer start, Integer count) throws ServiceException;
	
	
	/**
	 * 保存用户粉丝
	 */
	public void save(Fans fans) throws ServiceException;
	
	
	/**
	 * 删除粉丝
	 */
	public void delete(Long uid, Long fid) throws ServiceException;

	/**
	 * 获取粉丝数
	 */
	public Integer findFansCountByUid(Long uid) throws ServiceException;
}


