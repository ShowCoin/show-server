package one.show.search.service;

import one.show.common.exception.ServiceException;

public interface IndexService {
	
	public void createUserIndex(String indexPath) throws ServiceException;
	
}
