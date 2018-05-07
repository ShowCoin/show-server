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
	public List<Long> searchUser(String keyword,int cursor,int count) throws ServiceException, ParseException, IOException;
	public void deleteUser(Long uid) throws ServiceException, IOException;
	public void insertUser(UserSearchView user) throws ServiceException, IOException;
	public void updateUser(UserSearchView user) throws ServiceException, IOException;
}
