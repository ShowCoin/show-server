package one.show.service;

import java.util.List;
import java.util.Map;

import one.show.common.exception.ServiceException;

import one.show.stat.thrift.view.RankUserListView;

/**
 * Created by Andy on 18/4/13.
 */
public interface RankService {
	public RankUserListView findUserRankList(int beginTime, int endTime,
			int type, int start, int count) throws ServiceException;
	
	public List<Map<String, Object>> findDefenderList(final long uid, final int start, final int count) throws ServiceException;

}
