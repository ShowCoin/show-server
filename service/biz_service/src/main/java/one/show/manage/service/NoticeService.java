
package one.show.manage.service;

import java.util.List;
import java.util.Map;

import one.show.common.exception.ServiceException;
import one.show.manage.domain.Notice;
import one.show.manage.domain.ReturnList;

/**
 * 
 * 通知服务
 * @author Haliaeetus leucocephalus  
 *
 * 
 */

public interface NoticeService {
	public Notice findById(Integer id) throws ServiceException;
	
	public void insert(Notice notice)throws ServiceException;
	
	public void delete(Integer id)throws ServiceException;
	
	public void update(Map<String, String> updateContent, Integer id)throws ServiceException;
	
	public List<Notice> findEffecNoticeList()throws ServiceException;
	
	public ReturnList<Notice> findNoticeList(Integer start, Integer count)throws ServiceException;
	
	public Integer findNoticeListCount()throws ServiceException;

	public Integer findNoticeCount(Integer id)throws ServiceException;

}


