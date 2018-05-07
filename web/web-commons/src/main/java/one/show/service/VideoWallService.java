
package one.show.service;

import java.util.List;
import java.util.Map;

import one.show.common.Constant.LIVE_STATUS;

import one.show.video.thrift.view.LiveView;

/**
 * @author Haliaeetus leucocephalus  2016年6月7日 下午9:48:31
 *
 * 
 */

public interface VideoWallService {
	
	public static String queueKey = "liveQueue";
	public static String employeeKey = "employee";
	public static String taskKey = "task_";
	
	
	/**
	 * 监控心跳检测
	 * @param employee
	 */
	public void dieSession(String employee) ;
	
	/**
	 * 注册监控人员
	 * @param employeeName
	 * @return
	 */
	public Map<String, LiveView> registEmployee(String employeeName);
	
	/**
	 * 注销监控人员
	 * @param employeeId
	 */
	public void logoutEmployee(Object employeeId);
	/**
	 * 新开播的或者结束直播的，要更新队列
	 * @param ids
	 * @param status
	 */
	public void notifyMonitor(List<Long> ids, LIVE_STATUS status);
	
	/**
	 * 获取一个人的监控任务
	 * @param employeeId
	 * @return
	 */
	public Map<Long,LiveView> getTask(Object employeeId);
	
	/**
	 * 获取当前监控人员列表
	 * @return
	 */
	public Map<String,Map<Long,LiveView>> getMonitorList();

}


