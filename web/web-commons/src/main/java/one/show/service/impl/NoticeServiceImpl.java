
package one.show.service.impl;

import java.util.List;
import java.util.Map;

import one.show.common.exception.ServiceException;
import one.show.service.NoticeService;

import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import one.show.manage.thrift.iface.ManageServiceProxy;
import one.show.manage.thrift.view.NoticeListView;
import one.show.manage.thrift.view.NoticeView;

/**
 * @author Haliaeetus leucocephalus  2016年6月2日 下午9:44:48
 *
 * 
 */
@Component
public class NoticeServiceImpl implements NoticeService {

	@Autowired
	private ManageServiceProxy.Iface manageServiceClientProxy;
	
	@Override
	public NoticeListView getNoticeList(int start, int count)
			throws ServiceException {
		try {
			return manageServiceClientProxy.findNoticeList(start, count);
		} catch (TException e) {
			throw new ServiceException(e);
		}
	
	}

	@Override
	public void save(NoticeView noticeView) throws ServiceException {

		try {
			 manageServiceClientProxy.addNotice(noticeView);
		} catch (TException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public void update(Integer id, Map<String, String> updateContent)
			throws ServiceException {

		try {
			 manageServiceClientProxy.updateNoticeById(id, updateContent);
		} catch (TException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public void delete(Integer id) throws ServiceException {

		try {
			 manageServiceClientProxy.deleteNoticeById(id);
		} catch (TException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public NoticeView getNoticeById(Integer id) throws ServiceException {

		try {
			 return manageServiceClientProxy.findNoticeById(id);
		} catch (TException e) {
			throw new ServiceException(e);
		}
		
	}

	@Override
	public List<NoticeView> getEffecNoticeList() throws ServiceException {
		try {
			return manageServiceClientProxy.findEffecNoticeList();
		} catch (TException e) {
			throw new ServiceException(e);
		}
	}

}


