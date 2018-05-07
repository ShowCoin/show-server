package one.show.manage.service;

import one.show.common.exception.ServiceException;
import one.show.manage.domain.ReturnList;
import one.show.manage.domain.UserCDN;

public interface UserCDNService {
	public ReturnList<UserCDN> findUserCDNList(Integer start,  Integer count) throws ServiceException;
	
	public void save(UserCDN userCDN) throws ServiceException;
	
	public void update(UserCDN userCDN) throws ServiceException;
	
	public void delete(Long uid) throws ServiceException;
	
	public UserCDN findUserCDNById(long uid)throws ServiceException;
}
