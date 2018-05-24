package one.show.service;

import java.util.List;
import java.util.Map;

import one.show.common.exception.ReturnException;
import one.show.common.exception.ServiceException;
import one.show.user.thrift.view.BlackListView;
import one.show.user.thrift.view.ContactView;
import one.show.user.thrift.view.SettingView;
import one.show.user.thrift.view.ThirdDataView;
import one.show.user.thrift.view.UserForbiddenView;
import one.show.user.thrift.view.UserPopularNoView;
import one.show.user.thrift.view.UserView;

public interface UserService{
	
	/**
	 * 用户注册
	 * @param userView
	 * @param thirdDataView
	 * @return
	 * @throws ServiceException
	 */
	public UserView  registerUser(UserView userView, ThirdDataView thirdDataView) throws ReturnException, ServiceException; 
	
	/**
	 * 更新用户设备信息
	 * @param userView
	 * @throws ServiceException
	 */
	public void  updateUserDevice(UserView userView) throws ServiceException; 
	

	/**
	 * 获取用户通用设置
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public SettingView getSettingByUid(String uid) throws ServiceException;
	
	/**
	 * 设置用户通用设置
	 * @param setting
	 * @throws ServiceException
	 */
	public void setSwitch(String uid,Map<String, String> paramMap) throws ServiceException;
	
	/**
	 * 根据id查询用户
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public UserView findUserById(long id) throws ServiceException;
	
	/**
	 * 根据靓号popularNo查询用户
	 * @param pid
	 * @return
	 * @throws ServiceException
	 */
	public UserView findUserByPid(long pid) throws ServiceException;
	
	/**
	 * 根据id删除用户
	 * @param uid
	 * @throws ServiceException
	 */
	public void deletetUserById(Long uid) throws ServiceException;
	
	/**
	 * 获取第三方用户绑定信息
	 * @param tid
	 * @param type
	 * @return
	 */
	public ThirdDataView findThirdDataByTidAndType(String tid, String type) throws ServiceException;
	
	/**
	 * 插入用户
	 * @param userview
	 * @throws ServiceException
	 */
	public void  insertUser(UserView userview) throws ServiceException;
	

	/**
	 * 更新用户字段
	 * @param uid
	 * @param updateContent
	 * @throws ServiceException
	 * 用例 :
	 * userService.updateUserById(11, new KV(ImmutableMap.of(
		"city", "beijing",
		"birth","19910103"
		)));
	 */
	void updateUserById(long uid, Map<String,String> updateContent) throws ServiceException;

	/**
	 * 更新账户信息
	 * @param tid
	 * @param type
	 * @param map
	 * @throws ServiceException
	 */
	public void updateThirdData(String tid,String type, Map<String,String> map) throws ServiceException;
	
	/**
	 * 保存账户信息
	 * @param thirdDataView
	 * @return
	 * @throws ServiceException
	 */
	public int saveThirdData(ThirdDataView thirdDataView) throws ServiceException;
	
	/**
	 * 查询所有账户信息
	 * @param uid
	 * @return
	 * @throws ServiceException
	 */
	public List<ThirdDataView> findThirdDataListByUid(long uid) throws ServiceException;
	
	/**
	 * 获取用户通讯录
	 * @param uid
	 * @return
	 * @throws ServiceException
	 */
	public List<ContactView> findContactListByUid(String uid) throws ServiceException;
	
	/**
	 * 新增用户通讯录
	 * @param contactViewList
	 * @return
	 * @throws ServiceException
	 */
	public void insertContactListByUid(List<ContactView> contactViewList) throws ServiceException;
	
	/**
	 * 删除账户
	 * @param tid
	 * @param type
	 * @throws ServiceException
	 */
	public void deleteThirdData(String tid,String type) throws ServiceException;
	
	/**
	 * 根据uid和账户类型查询账户细腻洗
	 * @param uid
	 * @param type
	 * @return
	 * @throws ServiceException
	 */
	public ThirdDataView findThirdDataViewByUidAndType(long uid,String type) throws ServiceException;

	/**
	 * 根据ids多线程查询用户列表
	 * @param ids
	 * @return
	 * @throws ServiceException
	 */
	List<UserView> findUserListByIds(List<Long> ids) throws ServiceException;
	
	/**
	 * 获取用户权限
	 * @param uid
	 * @return
	 * @throws ServiceException
	 */
	public List<UserForbiddenView> findForbiddenByUid(long uid) throws ServiceException;
	
	/**
	 * 获取用户权限action
	 * @param uid
	 * @return
	 * @throws ServiceException
	 */
	public List<Integer> getForbiddenActionListByUid(long uid) throws ServiceException;

	/**
	 * 添加到黑名单
	 * @param currentUser
	 * @param target_userid
	 * @return
	 * @throws ServiceException
	 */
	int add2BlackList(long currentUser, long target_userid) throws ServiceException;

	/**
	 * 从黑名单移除
	 * @param currentUser
	 * @param target_userid
	 * @throws ServiceException
	 */
	void removeFromBlackList(long currentUser, long target_userid) throws ServiceException;

	/**
	 * 获取黑名单
	 * @param currentUser
	 * @param cursor
	 * @param count
	 * @return
	 * @throws ServiceException
	 */
	List<Long> findBlackList(long currentUser, Integer cursor, Integer count) throws ServiceException;
	
	/**
	 * 根据uid获取黑名单列表
	 * @param uid
	 * @param cursor
	 * @param count
	 * @return
	 * @throws ServiceException
	 */
	List<BlackListView> findBlackListByUid(long uid, Integer cursor, Integer count) throws ServiceException;
	
	/**
	 * 根据tid获取黑名单列表
	 * @param tid
	 * @param cursor
	 * @param count
	 * @return
	 * @throws ServiceException
	 */
	List<BlackListView> findBlackListByTid(long tid, Integer cursor, Integer count) throws ServiceException;
	
	public void saveForbiddenView(UserForbiddenView forbiddenView) throws ServiceException;
	
	public void deleteForbiddenViewByUid(long uid) throws ServiceException;
	
	public void deleteForbiddenViewByUidAndAction(long uid,int action) throws ServiceException;
	
	public Integer findCountBlackListByUid(long uid)throws ServiceException;
	
	public Integer findCountBlackListByTid(long tid)throws ServiceException;

	public boolean isAllow(String nickName) throws ServiceException;
	
	public boolean userIsForbidden(long uid,int action) throws ServiceException;
	
	public UserView findUserByNickName(String nickName) throws ServiceException;
	
	public List<Boolean> findForbiddenListByUidsAndAction(List<Long> uids,int action) throws ServiceException;
	
	List<UserView> getRobotList(int num) throws ServiceException;
	
	List<UserView> getRobotList(int num,List<Long> contains);
	
	List<UserView> getRobotList(int minLevel,int maxLevel);
	
	void saveRoomAdmin(long uid, long tid) throws ServiceException;

    void deleteRoomAdmin(long uid, long tid) throws ServiceException;

    List<Long> findRoomAdminListByUid(long uid, int cursor, int count) throws ServiceException;
    
    public Integer findRoomAdminCountByUid(long uid) throws ServiceException;
    
    public boolean isRoomAdmin(long uid, long tid) throws ServiceException;
    
    public boolean isBlack(long uid, long tid)  throws ServiceException;
    
    /**
     * 赠送靓号
     * @param uid
     * @param popularNo
     * @throws ServiceException
     */
    public void sendPopularNo(long uid, long popularNo)  throws ServiceException;
    
    /**
     * 删除靓号
     * @param uid
     * @param popularNo
     * @throws ServiceException
     */
    public void deletePopularNo(long uid, long popularNo)  throws ServiceException;
    
    /**
     * 用户靓号列表
     * @param uid
     * @return
     * @throws ServiceException
     */
    public List<UserPopularNoView> findPopularNoListByUid(long uid)  throws ServiceException;

	public void deleteThirdDataByUidAndType(long id, String thirdType);
    
}
