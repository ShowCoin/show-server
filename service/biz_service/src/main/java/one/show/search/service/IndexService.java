package one.show.search.service;

import one.show.common.exception.ServiceException;

public interface IndexService {
	
	
	/**
	 * 创建索引文件
	 * @param indexPath 索引文件位置
	 * @throws ServiceException
	 */
	public void createUserIndex(String indexPath) throws ServiceException;

	public void createAllIndex() throws ServiceException;

	public void recoverIndex() throws ServiceException;
	
}
