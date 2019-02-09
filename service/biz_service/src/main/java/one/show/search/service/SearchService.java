package one.show.search.service;

import java.io.IOException;
import java.util.List;

import one.show.search.thrift.view.UserSearchView;

import org.apache.lucene.queryparser.classic.ParseException;

import one.show.common.exception.ServiceException;

/**
 * @author Haliaeetus leucocephalus 
 *
 */
public interface SearchService {
	
	/**
	 *
	 * 从索引中搜索用户
	 * @param keyword 可以传昵称、ID
	 * @param cursor
	 * @param count
	 * @return
	 * @throws ServiceException
	 * @throws ParseException
	 * @throws IOException
	 */
	public List<Long> searchUser(String keyword,int cursor,int count) throws ServiceException, ParseException, IOException;
	
	/**
	 * 删除用户
	 * @param uid
	 * @throws ServiceException
	 * @throws IOException
	 */
	public void deleteUser(Long uid) throws ServiceException, IOException;
	
	/**
	 * 加入一个用户信息到索引文件
	 * @param user
	 * @throws ServiceException
	 * @throws IOException
	 */
	public void insertUser(UserSearchView user) throws ServiceException, IOException;
	
	/**
	 * 更新用户信息
	 * @param user
	 * @throws ServiceException
	 * @throws IOException
	 */
	public void updateUser(UserSearchView user) throws ServiceException, IOException;

	/**
	 * 重新生成索引
	 * @throws ServiceException
	 * @throws IOException
	 */
	public void recreateIndex() throws ServiceException, IOException;

	/**
	 * 生成索引2
	 * @throws ServiceException
	 */
	public void mulSearch() throws ServiceException;


}
