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
	
	/**
	 * 获取通知列表
	 * @return
	 * @throws ServiceException
	 */
	public List<NoticeView> getEffecNoticeList() throws ServiceException; 
	
	/**
	 * 分页获取通知列表
	 * @param start
	 * @param count
	 * @return
	 * @throws ServiceException
	 */
	public NoticeListView getNoticeList(int start, int count) throws ServiceException; 

	/**
	 * 保存通知
	 * @param noticeView
	 * @throws ServiceException
	 */
	public void save(NoticeView noticeView) throws ServiceException;
	
	/**
	 * 更新通知
	 * @param id
	 * @param updateContent
	 * @throws ServiceException
	 */
	public void update(Integer id, Map<String, String> updateContent) throws ServiceException;
	
	/**
	 * 删除通知
	 * @param id
	 * @throws ServiceException
	 */
	public void delete(Integer id) throws ServiceException;
	
	/**
	 * 根据id获取通知
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public NoticeView getNoticeById(Integer id) throws ServiceException;
	
	

}


