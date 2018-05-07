/**
 * 
 */
package one.show.manage.service;

import java.util.List;
import java.util.Map;

import one.show.common.Constant.ADMIN_STATUS;
import one.show.common.exception.ServiceException;
import one.show.manage.domain.Gift;
import one.show.manage.domain.GiftType;
import one.show.manage.domain.ReturnList;

/**
 * @author Haliaeetus leucocephalus 2018年3月8日 下午3:43:32
 *
 */
public interface GiftService {
	
	public ReturnList<Gift> getGiftList(Integer giftType, ADMIN_STATUS status, Integer start, Integer count) throws ServiceException;
	
	public Gift getGiftById(Integer giftId) throws ServiceException;
	
	public void save(Gift gift) throws ServiceException;
	
	public void delete(Integer giftId) throws ServiceException; 
	
	public void update(Integer giftId, Map<String, String> updateContent) throws ServiceException; 
	
	public List<GiftType> getGiftTypeList(ADMIN_STATUS status)throws ServiceException;

}


