/**
 * 
 */
package one.show.pay.service;

import java.util.List;
import java.util.Map;

import one.show.common.Constant.ACTION;
import one.show.common.exception.ServiceException;
import one.show.common.exception.StockNotEnoughException;
import one.show.pay.domain.Item;
import one.show.pay.domain.Stock;

/**
 * @author hank
 *
 */
public interface StockService {
	
	
	public void increase(long uid, Item item,  ACTION action, Integer expire,
			String actionDesc) throws ServiceException;
	
	
	public void reduce(long uid, Item item,  ACTION action, Integer expire,
			String actionDesc) throws ServiceException, StockNotEnoughException;
	
	/**
	 * 冻结
	 * @param uid
	 * @param item
	 * @param action
	 * @param actionDesc
	 * @throws ServiceException
	 * @throws StockNotEnoughException
	 */
	public void freeze(long uid, Item item,  ACTION action, 
			String actionDesc) throws ServiceException, StockNotEnoughException;
	
	
	/**
	 * 解冻
	 * @param uid
	 * @param item
	 * @param action
	 * @param actionDesc
	 * @throws ServiceException
	 * @throws StockNotEnoughException
	 */
	public void unfreeze(long uid, Item item,  ACTION action, 
			String actionDesc) throws ServiceException, StockNotEnoughException;
	    
	
	public List<Stock> findStockByUidAndParam(long uid,Map<String,String> params) throws ServiceException;
	
	public Stock findStockByUidAndItem(long uid, Integer itemType, Integer itemId) throws ServiceException;
	
	
	public List<Stock> findAllStock0(Integer tbid) throws ServiceException;
	
	public List<Stock> findAllStock1(Integer tbid) throws ServiceException;
}