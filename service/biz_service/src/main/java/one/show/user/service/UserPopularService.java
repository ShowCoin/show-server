package one.show.user.service;

import java.util.List;

import one.show.common.exception.ServiceException;
import one.show.user.domain.UserPopular;

public interface UserPopularService {
	
	public List<UserPopular> findListByUid(long uid)throws ServiceException;
	
	public void  save(UserPopular userPopular)throws ServiceException;
	
	public void  delete(long uid, long popularNo)throws ServiceException;
	
	public void  updateStatus(long uid, long popularNo, int status)throws ServiceException;
}
