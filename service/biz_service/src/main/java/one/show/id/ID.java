package one.show.id;

import java.util.List;

import one.show.common.Constant;
import one.show.common.IPUtil;
import one.show.common.Loader;
import one.show.common.zk.BaseZookeeper;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ID extends BaseZookeeper{
	
	
	protected static final Logger LOG = LoggerFactory.getLogger(ID.class);
	
	private static ID id = new ID();
	
	private IdWorker idWorker = null;
	

	private ID(){

		try {
			connect();
			
			if(!exists(Constant.ZK_ID_PATH_HOME, false)){
                // 创建根节点
            	createPersistentNode(Constant.ZK_ID_PATH_HOME, new byte[0]);
            }
            
			String address =  IPUtil.getLocalIP();
			List<String> subList = getChildren(Constant.ZK_ID_PATH_HOME, false);  
			
			Long workerId = null;
		    for (String subNode : subList) {  
		    		String[] ipAndId = subNode.split("_");
		    		if (ipAndId[0].equalsIgnoreCase(address)){
		    			workerId = Long.parseLong(ipAndId[1]);
		    			break;
		    		}
		     }  
		    
		    if (workerId == null){
		    	String createdPath = createPersistentSeqNode(Constant.ZK_ID_PATH_HOME+ "/"+address+"_", address.getBytes("utf-8"));
				
				workerId = Long.parseLong(createdPath.substring(createdPath.indexOf("_")+1));
		    }
		        
			
			long datacenterId = Long.parseLong(Loader.getInstance().getProps("datacenter.id"));
			
			LOG.info("IdWorker init. workerId:"+workerId+", datacenterId:"+datacenterId);
			idWorker = new IdWorker(workerId, datacenterId);
		}catch (Exception e) {
			LOG.error(e.getMessage(), e);
		}finally{
			try {
				close();
			} catch (InterruptedException e) {
				LOG.error(e.getMessage(), e);
			}
			
		}
		
	}
	
	
	public static Long nextId() {
		return id.idWorker.nextId();
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
