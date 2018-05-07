
package one.show.stat.service;

import java.util.Map;

import one.show.common.exception.ServiceException;
import one.show.stat.domain.RobotStatDaily;

/**
 * @author Haliaeetus leucocephalus 
 *
 * 
 */

public interface RobotStatDailyService {
	
	public RobotStatDaily findByDate(int date) throws ServiceException;
	
	public void save(RobotStatDaily robotStatDaily) throws ServiceException;
	
	public void updateByDate(int date, Map<String, String> updateContent) throws ServiceException;
	
}


