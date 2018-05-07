
package one.show.service.impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

import one.show.common.Constant.LIVE_STATUS;
import one.show.common.client.redis.JedisUtil;
import one.show.common.exception.ServiceException;
import one.show.service.VideoService;
import one.show.service.VideoWallService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import one.show.video.thrift.view.LiveView;

/**
 * @author Haliaeetus leucocephalus  2016年6月7日 下午9:49:10
 *
 * 
 */
@Component("videoWallService")
public class VideoWallServiceImpl implements VideoWallService {
	
	private static final Logger log = LoggerFactory.getLogger(VideoServiceImpl.class);

	@Autowired
	protected VideoService videoService;
	 

	/**
	 * 	刷新用户最后心跳时间
	 */
	@Override
	public void dieSession(String employee) {
		Map<String, Integer> employeeMap = (Map<String, Integer>) JedisUtil.get(employeeKey);
        if (employeeMap == null) {
            return;
        }

        Integer date = employeeMap.get(employee);
        if (date != null) {
            date = (int) (System.currentTimeMillis() / 1000l);
            employeeMap.put(employee, date);
            JedisUtil.set(employeeKey, employeeMap);
        }

		
	}

	/**
	 * 注册监控人员
	 */
	@Override
	public Map<String, LiveView> registEmployee(String employeeName) {
        Map<String, Integer> employee = (Map<String, Integer>) JedisUtil.get(employeeKey);
        if (employee == null) {
            employee = new LinkedHashMap<String, Integer>();
        }

        // 更新监控人员缓存
        employee.put(employeeName, (int) (System.currentTimeMillis() / 1000l));
        JedisUtil.set(employeeKey, employee);

        // 调整重新分配监控任务
        try {
			reloadQueue();
			reAlloc();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
        
        Map<String,LiveView> task = (Map<String,LiveView>) JedisUtil.get(taskKey + employeeName);
        return task;
	}
	
	/**
	 * 重新载入正在直播的
	 * @throws Exception
	 */
	 private void reloadQueue() throws Exception {
	        // 新开启或结束的直播入队列
	        Queue<Map<Long, LiveView>> liveQueue = (Queue<Map<Long, LiveView>>) JedisUtil.get(queueKey);
	        if (liveQueue == null) {
	            liveQueue = new ArrayBlockingQueue<Map<Long, LiveView>>(10000);
	        }
	        liveQueue.clear();
	        // 取出当前正在直播的列表
	        Map<String, String> condition = new HashMap<String, String>();
		    condition.put("status", "1");
	        List<LiveView> liveLst = videoService.getLiveList(condition, "create_time", 0, Integer.MAX_VALUE);
	       
	        if(liveLst!=null)
		        for (LiveView live : liveLst) {
		            Map<Long, LiveView> map = new LinkedHashMap<Long, LiveView>();
		            map.put(live.getLiveId(), live);
		            liveQueue.add(map);
		        }

	        JedisUtil.set(queueKey, liveQueue);
	  }

	 /**
     * 重新分配监控任务
     */
    private void reAlloc() throws Exception {
        // 直播任务
        Queue<Map<String, LiveView>> liveQueue = (Queue<Map<String, LiveView>>) JedisUtil.get(queueKey);
        if (liveQueue == null || liveQueue.size() == 0) {
            return;
        }

        // 监控人员
        Map<String, Integer> employee = (Map<String, Integer>) JedisUtil.get(employeeKey);

        if (employee.size() == 0)
            return;
        // 每个监控的任务数
        int factor = liveQueue.size() / employee.size();
        if (liveQueue.size() % employee.size() > 0) {
            factor = factor + 1;
        }

        Iterator<String> it = employee.keySet().iterator();

        // 分配任务
        while (it.hasNext()) {
            Object employeeId = it.next();
            Map<String, LiveView> task = (Map<String, LiveView>) JedisUtil.get(taskKey + employeeId);
            if (task == null) {
                task = new LinkedHashMap<String, LiveView>();
            }
            task.clear();
            for (int i = 0; i < factor; i++) {
                if (liveQueue.size() > 0) {
                    task.putAll(liveQueue.poll());
                }
            }
            JedisUtil.set(taskKey + employeeId, task);
        }
    }

	@Override
	public void notifyMonitor(List<Long> ids, LIVE_STATUS status) {

		if (status != LIVE_STATUS.END && status != LIVE_STATUS.IN) {
            return;
        }
        // 新开启或结束的直播入队列
        Queue<Map<Long,LiveView>> liveQueue = (Queue<Map<Long,LiveView>>) JedisUtil.get(queueKey);
        if (liveQueue == null) {
            liveQueue = new ArrayBlockingQueue<Map<Long,LiveView>>(10000);
        }
        for (Long liveId : ids) {
               
            Map<Long,LiveView> map = new LinkedHashMap<Long,LiveView>();
            LiveView live = null;
			try {
				live = videoService.getLiveById(liveId);
			} catch (ServiceException e) {
				log.error(e.getMessage(), e);
			}
            if(live == null)
                continue;
            map.put(liveId, live);
            if (status == LIVE_STATUS.IN)
                liveQueue.add(map);
            else
                liveQueue.remove(map);
        }
        JedisUtil.set(queueKey, liveQueue);
        // 调整监控任务
        try {
			microAdjust(ids, status);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}

	}
	
	  /**
     * 局部微调监控任务
     */
    private void microAdjust(List<Long> ids, LIVE_STATUS stauts) throws Exception {
        // 监控人员
        Map<String, Integer> employee = (Map<String, Integer>) JedisUtil.get(employeeKey);
        if (employee == null || employee.size() == 0) {
            return;
        }

        // 新的监控任务
        for (Long key : ids) {
        	  // 每个监控的任务数
            Iterator<String> it = employee.keySet().iterator();
            
            // 结束直播
            if (stauts == LIVE_STATUS.END) {
                while (it.hasNext()) {
                    Object employeeId = it.next();
                    Map<Long, LiveView> task = (Map<Long, LiveView>) JedisUtil.get(taskKey + employeeId);
                    if (task.get(key) != null) {
                        task.remove(key);
                        JedisUtil.set(taskKey + employeeId, task);
                        break;
                    }
                }
            } else {
                // 分配任务
                Object employeeId = getMinTask(it);
                Map<Long,LiveView> task = (Map<Long,LiveView>) JedisUtil.get(taskKey + employeeId);

                LiveView live = videoService.getLiveById(key);
                if(live == null)
                       continue;
                task.put(key, live);
                JedisUtil.set(taskKey + employeeId, task);
            }
        }
    }
    


    // 找到任务量最小的监控人员
    private Object getMinTask(Iterator<String> it) throws Exception {
        int taskSize = Integer.MAX_VALUE;
        Object ret = null;
        while (it.hasNext()) {
            Object employeeId = it.next();
            Map<String,LiveView> task = (Map<String,LiveView>) JedisUtil.get(taskKey + employeeId);
            if (task == null || task.size() < taskSize) {
                taskSize = task.size();
                ret = employeeId;
                break;
            }
        }
        return ret;
    }

	@Override
	public void logoutEmployee(Object employeeId) {

		 // 摘除监控人员
        Map<String, Integer> employee = (Map<String, Integer>) JedisUtil.get(employeeKey);
        if (employee == null) {
            employee = new LinkedHashMap<String, Integer>();
        }
        
        if (employee.get(employeeId) != null){
        	 employee.remove(employeeId);
             JedisUtil.set(employeeKey, employee);
             Map<Long,LiveView> task = (Map<Long,LiveView>) JedisUtil.get(taskKey + employee);
             if(task!=null)
             	task.clear();
             else
             	task = new LinkedHashMap<Long, LiveView>();
             JedisUtil.set(taskKey + employee, task);
             // 调整重新分配监控任务
             try {
     			reloadQueue();
     			if (employee.size() > 0)
     		            reAlloc();
     		} catch (Exception e) {
     			// TODO Auto-generated catch block
     			e.printStackTrace();
     		}
        }
        
	}

	@Override
	public Map<Long, LiveView> getTask(Object employeeId) {
		Map<Long,LiveView> task = (Map<Long,LiveView>) JedisUtil.get(taskKey + employeeId);
        return task;
	}

	@Override
	public Map<String, Map<Long, LiveView>> getMonitorList() {
		Map<String,Map<Long,LiveView>> ret = new LinkedHashMap<String,Map<Long,LiveView>>();
        // 监控人员
        Map<String,Integer> employee = (Map<String,Integer>) JedisUtil.get(employeeKey);
        Iterator<String> it = employee.keySet().iterator();
        while (it.hasNext()) {
            String employeeId = it.next();
            Map<Long,LiveView> task = (Map<Long,LiveView>) JedisUtil.get(taskKey + employeeId);
            ret.put(employeeId, task);
        }
        return ret;
	}

}


