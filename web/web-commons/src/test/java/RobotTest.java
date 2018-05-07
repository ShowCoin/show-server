import java.util.Collections;
import java.util.List;

import one.show.common.RandomUtils;
import one.show.service.RobotService;

import org.apache.thrift.TException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import one.show.relation.thrift.iface.RelationServiceProxy;
import one.show.user.thrift.iface.UserServiceProxy;
import one.show.user.thrift.view.RobotView;



/**
 * @author Haliaeetus leucocephalus  2016年7月16日 下午7:54:23
 *
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextHierarchy({
        @ContextConfiguration(name = "parent", locations = "classpath:applicationContext.xml")
})
public class RobotTest {
	
	private static final Logger log = LoggerFactory
			.getLogger(RobotTest.class);
	
	  	@Autowired
	    private RobotService robotService;
	  	
		@Autowired
		private UserServiceProxy.Iface userServiceClientProxy;
		
		@Autowired
		private RelationServiceProxy.Iface relationServiceClientProxy;

	    @Before
	    public void setUp() throws Exception {

			
	    }


	    @Test
	    public void test() throws Exception {
	    	robotService.sendGift(742956171266244608l, 744810455503085568l);
	    }
	    
	    @Test
	    public void follow() throws Exception {
	    	 List<RobotView> list = null;
	 		try {
	 			list = userServiceClientProxy.findAllRobot();
	 		} catch (TException e1) {
	 			// TODO Auto-generated catch block
	 			e1.printStackTrace();
	 		}
		 	log.info("robot list : "+list.size());
		 	if (list != null){
		 		for(RobotView robot : list){
		 			try {
		 				Collections.shuffle(list);
		 				
		 				int num = RandomUtils.getRandomInteger(8, 40);
		 				List<RobotView> subList = list.subList(0, num);
		 				
		 				for (RobotView r : subList){
		 					relationServiceClientProxy.follow(robot.getUid(), r.getUid());
		 					log.info("uid : "+robot.getUid()+" follow uid : "+r.getUid());
		 				}
		 				
		 			} catch (Exception e) {
		 				log.error(e.getMessage(), e);
		 			}
		 		}
		 		
		 		log.info("follow done");
		 	}
	    }
	    
	   
}


