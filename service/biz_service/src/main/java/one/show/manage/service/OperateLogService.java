/**
 * 
 */
package one.show.manage.service;

import one.show.common.exception.ServiceException;
import one.show.manage.domain.OperateLog;

/**
 * @author Haliaeetus leucocephalus 
 *
 */
public interface OperateLogService {

	public void save(OperateLog operateLog) throws ServiceException;
	
}


