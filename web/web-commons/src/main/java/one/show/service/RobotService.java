
package one.show.service;

import java.util.List;

import one.show.common.exception.ServiceException;

import one.show.user.thrift.view.UserView;

/**
 * @author Haliaeetus leucocephalus  2016年7月16日 下午4:21:17
 *
 * 
 */

public interface RobotService {
	
	/**
	 * 机器人送礼
	 * @param uid
	 * @param roomId
	 * @throws ServiceException
	 */
	public void sendGift(Long uid, Long liveId) throws ServiceException;
	
	
	/**
	 * 机器人关注
	 * @param uid
	 * @param fid
	 * @throws ServiceException
	 */
	public void follow(Long uid, Long fid, Long liveId) throws ServiceException;
	
	
	/**
	 * 机器人点赞
	 * @param uid
	 * @param roomId
	 * @throws ServiceException
	 */
	public void like(List<UserView> robotList, Long liveId) throws ServiceException;
	
	
	/**
	 * 机器人发言
	 * @param uid
	 * @param roomId
	 * @throws ServiceException
	 */
	public void speak(Long uid, Long liveId) throws ServiceException;
	
	
	/**
	 * 增长机器人
	 * @param liveId
	 * @throws ServiceException
	 */
	public void increase(Long liveId) throws ServiceException;
	
	/**
	 * 进入房间
	 * @param liveId
	 * @throws ServiceException
	 */
	public void enter(Long liveId, UserView robot) throws ServiceException;

}


