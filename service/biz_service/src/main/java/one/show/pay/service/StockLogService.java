/**
 * 
 */
package one.show.pay.service;

import java.util.Map;

import one.show.common.exception.ServiceException;
import one.show.pay.domain.ReturnList;
import one.show.pay.domain.StockLog;

/**
 * @author hank
 *
 */
public interface StockLogService {

	public ReturnList<StockLog> findStockLogListByUidAndParam(long uid,Map<String,String> params, Integer start, Integer count) throws ServiceException;

	public Double getStockLogItemTotalByUid(long uid, Map<String, String> paramMap) throws ServiceException;

	public void saveStockLog(StockLog stockLog) throws ServiceException;

	public BigDecimal getPendingStockLog(long userId) throws ServiceException;

	public BigDecimal getUserStockLog(long userId) throws ServiceException;

	public List<StockLog> getUserStockLog(long userId) throws ServiceException;

	public List<StockLog> getUserLastestStockLog(long userId,int count) throws ServiceException;
	
}


