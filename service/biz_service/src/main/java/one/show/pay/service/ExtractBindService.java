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

	void saveExtractBind(ExtractBind extractBind) throws ServiceException;
	
	ExtractBind getExtractBindByUid(long uid) throws ServiceException;

	void updateExtractBindByUid(long uid, String alipayAccount, String alipayName) throws ServiceException;
}


