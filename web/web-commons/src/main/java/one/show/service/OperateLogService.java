/**
 * 
 */
package one.show.service;

import one.show.common.exception.ServiceException;

import one.show.manage.thrift.view.OperateLogView;

/**
 * @author Haliaeetus leucocephalus 2015年11月13日 上午11:31:37
 *
 */
public interface OperateLogService {

	public void save(OperateLogView operateLogView) throws ServiceException;
	
}


