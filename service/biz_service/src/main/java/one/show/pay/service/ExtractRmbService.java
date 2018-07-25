/**
 * 
 */
package one.show.pay.service;

import java.util.List;
import java.util.Map;

import one.show.common.exception.ServiceException;
import one.show.pay.domain.ExtractRmb;
import one.show.pay.domain.ReturnList;

import one.show.pay.thrift.view.ExtractRmbView;

/**
 * @author hank
 *
 */
public interface ExtractRmbService {
	
	 Long getMaxBatchNo();

	 void saveExtractRmb(ExtractRmb extractRmb) throws ServiceException;
	
	 ReturnList<ExtractRmb> getExtractRmbListByUid(Map<String,String> paramMap, Integer start, Integer count) throws ServiceException;

	 Double getExtractRmbTotalByUid(long uid,String key, Map<String, String> paramMap) throws ServiceException;

	 void updateExtractRmbById(long id, Map<String, String> paramMap) throws ServiceException;
	
	 List<ExtractRmb> getExtractRmbListByBatchNo(long batchNo) throws ServiceException;
	
	 List<ExtractRmb> getExtractRmbListByStatus(int status,Integer count);

	 ExtractRmbView getExtractRmbViewById(long id);

	 Double getExtractRmbTotalCount();

	 BigDecimal getLastestRate(int symble);
}


