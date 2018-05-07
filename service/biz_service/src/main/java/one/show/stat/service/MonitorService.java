/**
 * 
 */
package one.show.stat.service;

import one.show.common.exception.ServiceException;
import one.show.stat.domain.MonitorStat;
import one.show.stat.domain.ReturnList;

/**
 * @author Haliaeetus leucocephalus 2018年3月12日 下午10:07:52
 *
 */
public interface MonitorService {
	
	public ReturnList<MonitorStat> findMonitorStatList(int beginTime, int endTime,
			int type, int start, int count) throws ServiceException;
	
	public void updateMonitorStatById(Long id, String statement) throws ServiceException;
	
	public void save(MonitorStat monitorStat) throws ServiceException;
	
	public MonitorStat findMonitorStat(String name, int type, int time) throws ServiceException;

}


