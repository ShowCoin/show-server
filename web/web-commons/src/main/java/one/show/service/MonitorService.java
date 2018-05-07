/**
 * 
 */
package one.show.service;

import one.show.common.exception.ServiceException;

import one.show.stat.thrift.view.MonitorStatListView;

/**
 * @author Haliaeetus leucocephalus 2018年3月12日 下午10:07:04
 *
 */
public interface MonitorService {
	
	public MonitorStatListView findMonitorStatList(int beginTime, int endTime,
			int type, int start, int count) throws ServiceException;

}


