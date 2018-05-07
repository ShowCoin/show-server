/**
 * 
 */
package one.show.service.impl;

import one.show.common.exception.ServiceException;
import one.show.service.OperateLogService;

import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import one.show.manage.thrift.iface.AdminSystemServiceProxy;
import one.show.manage.thrift.view.OperateLogView;

/**
 * @author Haliaeetus leucocephalus 2015年11月13日 上午11:33:14
 *
 */
@Component
public class OperateLogServiceImpl implements OperateLogService {

	@Autowired
	private AdminSystemServiceProxy.Iface adminSystemServiceClientProxy;
	
	/* (non-Javadoc)
	 * @see one.show.service.OperateLogService#save(one.show.manage.thrift.view.OperateLogView)
	 */
	@Override
	public void save(OperateLogView operateLogView) throws ServiceException {

		try {
			adminSystemServiceClientProxy.saveOperateLog(operateLogView);
		} catch (TException e) {
			throw new ServiceException(e);
		}
	}

}


