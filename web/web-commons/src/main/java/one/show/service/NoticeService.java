/**
 * 
 */
package one.show.service;

import java.util.List;
import java.util.Map;

import one.show.common.exception.ServiceException;

import one.show.manage.thrift.view.NoticeListView;
import one.show.manage.thrift.view.NoticeView;

/**
 * @author Haliaeetus leucocephalus 2018年3月8日 下午4:07:17
 *
 */
public interface NoticeService {
	
	public List<NoticeView> getEffecNoticeList() throws ServiceException; 
	
	public NoticeListView getNoticeList(int start, int count) throws ServiceException; 

	public void save(NoticeView noticeView) throws ServiceException;
	
	public void update(Integer id, Map<String, String> updateContent) throws ServiceException;
	
	public void delete(Integer id) throws ServiceException;
	
	
	public NoticeView getNoticeById(Integer id) throws ServiceException;
	
	

}


