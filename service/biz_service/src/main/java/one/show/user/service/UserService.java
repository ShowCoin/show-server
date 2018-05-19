package one.show.user.service;

import java.util.List;
import java.util.Map;

import one.show.common.exception.ServiceException;
import one.show.user.domain.ThirdData;
import one.show.user.domain.User;

public interface UserService{
	
	public User findUserById(long id);
	
	
	public void instertUser(User user) throws ServiceException;
	
	public void deletetUser(Long id) throws ServiceException;
	
	/**
	 * 更新用户字段
	 * @param uid
	 * @param updateContent
	 * 用例 :
	 * userService.updateUserById(11, new KV(ImmutableMap.of(
		"city", "beijing",
		"birth","19910103"
		)));
	 */
	void  updateUserById(long uid, Map<String, String> updateContent) throws ServiceException;

	public List<User> findUserListByIds(List<Long> ids);
	
	public List<User> findAllUsersList(Integer start, Integer count) throws ServiceException;

	/**
	 * 判断昵称是否可用
	 * @param nickName
	 * @return
	 */
	public boolean isAllow(String nickName);

	public User findUserByNickName(String nickName);


	/**
	 * 根据靓号获取用户信息
	 * @param pid
	 * @return
	 */
	public User findUserByPopularNo(long pid);


	/**
	 * 用户注册
	 * @param user
	 * @param thirdData
	 * @throws ServiceException
	 */
	public void registerUser(User user, ThirdData thirdData) throws ServiceException;
	
}
