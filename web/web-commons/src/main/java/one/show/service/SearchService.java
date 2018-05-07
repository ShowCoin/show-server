package one.show.service;

import java.util.List;

import one.show.common.exception.ServiceException;

import one.show.search.thrift.view.UserSearchView;

/**
 * Created by Haliaeetus leucocephalus on 18/1/18.
 */
public interface SearchService {
    List<Long> searchUser(String keyword, Integer cursor, Integer count) throws ServiceException;
    void insertUser(UserSearchView user) throws ServiceException;
	void updateUser(UserSearchView user) throws ServiceException;
	public void deleteUser(Long uid) throws ServiceException;
}
