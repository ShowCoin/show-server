
package one.show.stat.service;

import one.show.common.exception.ServiceException;
import one.show.stat.domain.ActionLog;

/**
 * @author Haliaeetus leucocephalus  
 *
 * 
 */

public interface ActionLogService {

	public void save(ActionLog log) throws ServiceException;

	public void find(long startTime, long endTime) throws ServiceException;
}


