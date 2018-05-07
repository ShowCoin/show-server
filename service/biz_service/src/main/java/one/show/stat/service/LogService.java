
package one.show.stat.service;

import one.show.common.exception.ServiceException;
import one.show.stat.domain.Log;

/**
 * @author Haliaeetus leucocephalus 
 *
 * 
 */

public interface LogService {

	public void save(Log log) throws ServiceException;
}


