/**
 * 
 */
package one.show.stat.service;

import java.util.List;

import one.show.common.exception.ServiceException;
import one.show.stat.domain.UserStat;

/**
 * @author Haliaeetus leucocephalus 2018年1月6日 下午5:13:12
 *
 */


public interface UserStatService {

	public UserStat findByUid(Long uid);
	
	public void save(UserStat userStat);
	
	public void update(UserStat userStat);
	
	List<UserStat> findByUids(List<Long> uids);
	
	public void delete(Long uid) throws ServiceException;
	
}


