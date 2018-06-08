/**
 * 
 */
package one.show.stat.service;

import java.util.List;

import one.show.common.exception.ServiceException;
import one.show.stat.domain.SummaryStat;

import org.apache.ibatis.annotations.Param;

/**
 * @author Haliaeetus leucocephalus 
 *
 */
public interface SummaryStatService {

	List<SummaryStat> findSummaryList(Integer time) throws ServiceException;
	
    SummaryStat findSummary(Integer time) throws ServiceException;
	
	void save(SummaryStat summaryStat) throws ServiceException;
	
	void update(SummaryStat summaryStat) throws ServiceException;
	
	void updateLiveMax(Integer num, Integer time) throws ServiceException;
}


