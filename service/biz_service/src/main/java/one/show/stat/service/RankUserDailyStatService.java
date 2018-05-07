/**
 * 
 */
package one.show.stat.service;

import one.show.common.exception.ServiceException;
import one.show.stat.domain.MonitorStat;
import one.show.stat.domain.RankUserDaily;
import one.show.stat.domain.ReturnList;

/**
 * @author Haliaeetus leucocephalus 
 *
 */
public interface RankUserDailyStatService {

	
	public RankUserDaily findRankUserDaily(Long uid, Integer type, Integer date) throws ServiceException;
	
	void save(RankUserDaily rankUserDaily) throws ServiceException;
	
	void update(Long id, Double number) throws ServiceException;
	
	public ReturnList<RankUserDaily> findRankUserList(int beginTime, int endTime,
			int type, int start, int count) throws ServiceException;
}


