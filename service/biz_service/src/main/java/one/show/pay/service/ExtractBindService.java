/**
 * 
 */
package one.show.pay.service;

import one.show.common.exception.ServiceException;
import one.show.pay.domain.ExtractBind;

/**
 * @author hank
 *
 */
public interface ExtractBindService {

	public void saveExtractBind(ExtractBind extractBind) throws ServiceException;
	
	public ExtractBind getExtractBindByUid(long uid) throws ServiceException;


	public void updateExtractBindByUid(long uid, String alipayAccount, String alipayName) throws ServiceException;
}


