package one.show.service;

import java.util.List;

import one.show.common.exception.ServiceException;

import one.show.search.thrift.view.UserSearchView;

/**
 * Created by Haliaeetus leucocephalus on 18/1/18.
 */
public interface SearchService {
	/**
	 * 根据关键字搜索用户
	 * @param keyword
	 * @param cursor
	 * @param count
	 * @return
	 * @throws ServiceException
	 */
    List<Long> searchUser(String keyword, Integer cursor, Integer count) throws ServiceException;
    /**
     * 插入用户
     * @param user
     * @throws ServiceException
     */
    void insertUser(UserSearchView user) throws ServiceException;
    /**
     * 更新用户
     * @param user
     * @throws ServiceException
     */
	void updateUser(UserSearchView user) throws ServiceException;
	/**
	 * 删除用户
	 * @param uid
	 * @throws ServiceException
	 */
	public void deleteUser(Long uid) throws ServiceException;
}
