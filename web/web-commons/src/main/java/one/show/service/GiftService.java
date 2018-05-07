/**
 * 
 */
package one.show.service;

import java.util.List;
import java.util.Map;

import one.show.common.Constant.ADMIN_STATUS;
import one.show.common.exception.ServiceException;

import one.show.manage.thrift.view.GiftListView;
import one.show.manage.thrift.view.GiftTypeView;
import one.show.manage.thrift.view.GiftView;

/**
 * @author Haliaeetus leucocephalus 2018年3月8日 下午4:07:17
 *
 */
public interface GiftService {
	
	public GiftListView getGiftList(Integer giftType, ADMIN_STATUS status, int start, int count) throws ServiceException; 

	public void save(GiftView giftView) throws ServiceException;
	
	public void update(Integer giftId, Map<String, String> updateContent) throws ServiceException;
	
	public void delete(Integer giftId) throws ServiceException;
	
	public List<GiftTypeView> getGiftTypeList(ADMIN_STATUS status) throws ServiceException;
	
	public GiftView getGiftById(Integer giftId) throws ServiceException;
	
	

}


