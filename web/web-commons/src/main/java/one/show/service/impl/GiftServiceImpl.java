/**
 * 
 */
package one.show.service.impl;

import java.util.List;
import java.util.Map;

import one.show.common.Constant.ADMIN_STATUS;
import one.show.common.exception.ServiceException;
import one.show.service.GiftService;

import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import one.show.manage.thrift.iface.ManageServiceProxy;
import one.show.manage.thrift.view.GiftListView;
import one.show.manage.thrift.view.GiftTypeView;
import one.show.manage.thrift.view.GiftView;

/**
 * @author Haliaeetus leucocephalus 2018年3月8日 下午4:08:26
 *
 */

@Component("giftService")
public class GiftServiceImpl implements GiftService {

	@Autowired
	private ManageServiceProxy.Iface manageServiceClientProxy;
	
	/* (non-Javadoc)
	 * @see one.show.service.GiftService#getGiftList(java.lang.Integer, one.show.common.Constant.ADMIN_STATUS, int, int)
	 */
	@Override
	public GiftListView getGiftList(Integer giftType, ADMIN_STATUS status,
			int start, int count) throws ServiceException {

		try {
			return manageServiceClientProxy.findGiftList(giftType==null?-1:giftType, status==null?-1:status.ordinal(), start, count);
		} catch (TException e) {
			throw new ServiceException(e);
		}
	}

	/* (non-Javadoc)
	 * @see one.show.service.GiftService#save(one.show.manage.thrift.view.GiftView)
	 */
	@Override
	public void save(GiftView giftView) throws ServiceException {

		try {
			manageServiceClientProxy.saveGift(giftView);
		} catch (TException e) {
			throw new ServiceException(e);
		}
	}

	/* (non-Javadoc)
	 * @see one.show.service.GiftService#delete(java.lang.Integer)
	 */
	@Override
	public void delete(Integer giftId) throws ServiceException {

		try {
			manageServiceClientProxy.deleteGift(giftId);
		} catch (TException e) {
			throw new ServiceException(e);
		}
	}

	/* (non-Javadoc)
	 * @see one.show.service.GiftService#getGiftTypeList(one.show.common.Constant.ADMIN_STATUS)
	 */
	@Override
	public List<GiftTypeView> getGiftTypeList(ADMIN_STATUS status)
			throws ServiceException {
		try {
			return manageServiceClientProxy.findGiftTypeList(status==null?-1:status.ordinal());
		} catch (TException e) {
			throw new ServiceException(e);
		}
	}

	/* (non-Javadoc)
	 * @see one.show.service.GiftService#update(java.lang.Integer, java.util.Map)
	 */
	@Override
	public void update(Integer giftId, Map<String, String> updateContent)
			throws ServiceException {

		try {
			manageServiceClientProxy.updateGift(giftId, updateContent);
		} catch (TException e) {
			throw new ServiceException(e);
		}
	}

	/* (non-Javadoc)
	 * @see one.show.service.GiftService#getGiftById(java.lang.Integer)
	 */
	@Override
	public GiftView getGiftById(Integer giftId) throws ServiceException {
		try {
			return manageServiceClientProxy.findGiftById(giftId);
		} catch (TException e) {
			throw new ServiceException(e);
		}
	}

}


