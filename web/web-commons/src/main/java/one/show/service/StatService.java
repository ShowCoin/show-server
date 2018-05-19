/**
 * 
 */
package one.show.service;

import java.util.List;

import one.show.common.exception.ServiceException;

import org.apache.thrift.TException;

import one.show.stat.thrift.view.SummaryStatView;
import one.show.stat.thrift.view.UserStatView;
import one.show.stat.thrift.view.VideoStatView;

/**
 * @author Haliaeetus leucocephalus 2018年1月6日 下午10:43:52
 *
 */
public interface StatService {
	
	/**
	 * 获取用户统计数据
	 * @param uid
	 * @return
	 * @throws ServiceException
	 */
	public UserStatView findUserStatByUid(Long uid) throws ServiceException;
	
	/**
	 * 获取视频统计数据
	 * @param vid
	 * @return
	 * @throws ServiceException
	 */
	public VideoStatView findVideoStatByVid(Long vid) throws ServiceException;
	
	/**
	 * 根据ids获取userstat列表
	 * @param uids
	 * @return
	 * @throws ServiceException
	 */
	List<UserStatView> findUserStatByUids(List<Long> uids) throws ServiceException;

	/**
	 * 根据vids获取视频状态列表
	 * @param filteredVids
	 * @return
	 * @throws ServiceException
	 */
	List<VideoStatView> findVideoStatByVids(List<Long> filteredVids) throws ServiceException;
	
	/**
	 * 根据时间获取统计列表
	 * @param time
	 * @return
	 * @throws ServiceException
	 */
	List<SummaryStatView> getSummaryStatList(Integer time) throws ServiceException;
	
	/**
	 * 删除userstat
	 * @param uid
	 * @throws ServiceException
	 */
	public void deleteUserStat(Long uid) throws ServiceException;
}


