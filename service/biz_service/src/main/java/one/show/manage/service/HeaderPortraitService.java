package one.show.manage.service;

import java.util.List;
import java.util.Map;

import one.show.common.exception.ServiceException;
import one.show.manage.domain.HeaderPortrait;

/**
 * 
 * @author Haliaeetus leucocephalus
 *
 */
public interface HeaderPortraitService {
	public List<HeaderPortrait> findHeaderPortraitList(int pageSize,int pageCount) throws ServiceException;
	public void deleteHeaderPortrait(long id) throws ServiceException;
	public void deleteHeaderPortraitList(List<Long> ids) throws ServiceException;
	public void saveHeaderPortraitList(HeaderPortrait headerPortrait) throws ServiceException;
	public Integer findHeaderPortraitCount() throws ServiceException;
	public void deleteHeaderPortraitByUid(String uid) throws ServiceException;
	public HeaderPortrait findHeaderPortrait(String uid) throws ServiceException;
	public void updateHeaderPortraitByUid(String uid,Map<String,String>params)throws ServiceException;
}
