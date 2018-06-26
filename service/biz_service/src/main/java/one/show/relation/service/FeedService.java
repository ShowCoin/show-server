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
	
	/**
	 * 根据uid获取推送列表
	 * @param uid
	 * @param condition
	 * @param start 起始位置
	 * @param count
	 * @return List
	 * @throws ServiceException
	 */
	public List<Feed> findListByUid(Long uid, Map<String, String> condition, Integer start, Integer count) throws ServiceException;
	
	
	/**
	 * 保存推送数据
	 * @param feed
	 * @throws ServiceException
	 */
	public void save(Feed feed) throws ServiceException;
	
	/**
	 * 删除
	 * @param uid
	 * @param fid  关注人ID
	 * @param point 推送类型
	 * @throws ServiceException
	 */
	public void delete(Long uid, Long fid, String point) throws ServiceException;
	
	/**
	 * 更新
	 * @param uid
	 * @param fid
	 * @param point
	 * @param updateContent
	 * @throws ServiceException
	 */
	public void update(Long uid, Long fid, String point, Map<String, String> updateContent) throws ServiceException;

}


