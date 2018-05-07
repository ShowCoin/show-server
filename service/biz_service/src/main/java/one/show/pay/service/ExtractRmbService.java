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
	
	public Long getMaxBatchNo();

	public void saveExtractRmb(ExtractRmb extractRmb) throws ServiceException;
	
	public ReturnList<ExtractRmb> getExtractRmbListByUid(Map<String,String> paramMap, Integer start, Integer count) throws ServiceException;

	public Double getExtractRmbTotalByUid(long uid,String key, Map<String, String> paramMap) throws ServiceException;

	public void updateExtractRmbById(long id, Map<String, String> paramMap) throws ServiceException;
	
	public List<ExtractRmb> getExtractRmbListByBatchNo(long batchNo) throws ServiceException;
	
	public List<ExtractRmb> getExtractRmbListByStatus(int status,Integer count);

	public ExtractRmbView getExtractRmbViewById(long id);

	public Double getExtractRmbTotalCount();
}


