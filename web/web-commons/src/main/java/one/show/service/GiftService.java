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
	
	/**
	 * 获得礼物列表
	 * @param giftType
	 * @param status
	 * @param start
	 * @param count
	 * @return
	 * @throws ServiceException
	 */
	public GiftListView getGiftList(Integer giftType, ADMIN_STATUS status, int start, int count) throws ServiceException; 

	/**
	 * 保存礼物
	 * @param giftView
	 * @throws ServiceException
	 */
	public void save(GiftView giftView) throws ServiceException;
	
	/**
	 * 更新礼物
	 * @param giftId
	 * @param updateContent
	 * @throws ServiceException
	 */
	public void update(Integer giftId, Map<String, String> updateContent) throws ServiceException;
	
	/**
	 * 删除礼物
	 * @param giftId
	 * @throws ServiceException
	 */
	public void delete(Integer giftId) throws ServiceException;
	
	/**
	 * 根据状态获得礼物列表
	 * @param status
	 * @return
	 * @throws ServiceException
	 */
	public List<GiftTypeView> getGiftTypeList(ADMIN_STATUS status) throws ServiceException;
	
	/**
	 * 根据ID获得礼物
	 * @param giftId
	 * @return
	 * @throws ServiceException
	 */
	public GiftView getGiftById(Integer giftId) throws ServiceException;
	
	

}


