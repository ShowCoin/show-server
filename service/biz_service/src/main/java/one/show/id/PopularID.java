package one.show.id;

import one.show.common.Constant;
import one.show.common.lock.DistributedLock;
import one.show.common.zk.BaseZookeeper;

import org.apache.zookeeper.WatchedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class PopularID extends BaseZookeeper{
	
	
	protected static final Logger LOG = LoggerFactory.getLogger(PopularID.class);
	
	private static PopularID pid = new PopularID();
	
	
	private Long initId = 23220760l;
	
	private Long beginId = initId;
	
	private Integer offset = 10000;
	
	private Long endId = beginId + offset;
	
	 
	private PopularID(){

		try {
			connect();
			
			if(!exists(Constant.ZK_PID_PATH_HOME, false)){
                // 创建根节点
            	createPersistentNode(Constant.ZK_PID_PATH_HOME, String.valueOf(initId).getBytes());
            }
			
			flushBeginId();
			
		}catch (Exception e) {
			LOG.error(e.getMessage(), e);
		}
	}
	
	public final static PopularID getInstance() {
		return pid;
	}
	
	private void flushBeginId(){
		DistributedLock dl = new DistributedLock("popular_id");
		try {
			dl.lock();
			String data = getData(Constant.ZK_PID_PATH_HOME, false);
	    	
	    	beginId = Long.parseLong(data) + 1;
	    	
	    	endId = beginId + offset;
			
			setData(Constant.ZK_PID_PATH_HOME, String.valueOf(endId).getBytes(), -1);
			
			LOG.info("flush popular id ["+beginId+" ~ "+endId+"]");
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
		}finally{
			dl.unlock();
		}
		
	}
	
	public synchronized Long nextPid() {
		long id = beginId++;
		if (id > endId){
			flushBeginId();
			nextPid();
		}
		return id;
	}


	/* (non-Javadoc)
	 * @see one.show.common.zk.BaseZookeeper#nodeChildrenChanged(org.apache.zookeeper.WatchedEvent)
	 */
	@Override
	public void nodeChildrenChanged(WatchedEvent event) {
		// TODO Auto-generated method stub
		
	}


	/* (non-Javadoc)
	 * @see one.show.common.zk.BaseZookeeper#connected(org.apache.zookeeper.WatchedEvent)
	 */
	@Override
	public void connected(WatchedEvent event) {

		
	}


}
