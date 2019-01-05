/**
 * 
 */
package one.show.manage.service;

import one.show.common.exception.ServiceException;
import one.show.manage.domain.OperateLog;

/**
 * @author Haliaeetus leucocephalus 
 * @desc operation log
 */
public interface OperateLogService {

	public void save(OperateLog operateLog) throws ServiceException;

	public void find(Long uid) throws ServiceException;

	public void update(OperateLog operateLog) throws ServiceException;
	
}


