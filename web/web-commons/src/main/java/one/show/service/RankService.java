package one.show.service;

import java.util.List;
import java.util.Map;

import one.show.common.exception.ServiceException;

import one.show.stat.thrift.view.RankUserListView;

/**
 * Created by Andy on 18/4/16.
 */
public interface RankService {
	/**
	 * 获取用户排名列表
	 * @param beginTime
	 * @param endTime
	 * @param type
	 * @param start
	 * @param count
	 * @return
	 * @throws ServiceException
	 */
	public RankUserListView findUserRankList(int beginTime, int endTime,
			int type, int start, int count) throws ServiceException;
	
	/**
	 * 获取守护者列表
	 * @param uid
	 * @param start
	 * @param count
	 * @return
	 * @throws ServiceException
	 */
	public List<Map<String, Object>> findDefenderList(final long uid, final int start, final int count) throws ServiceException;

}
