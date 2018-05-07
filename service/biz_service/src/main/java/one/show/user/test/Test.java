package one.show.user.test;

import one.show.common.id.ObjectId;
import one.show.common.id.PopularID;
import one.show.user.dao.UserMapper;
import one.show.user.service.ThirdDataService;
import one.show.user.service.UserService;

import org.apache.thrift.TException;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Test {
	 
	public static void main(String[] args) throws TException {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {
                "applicationContext.xml"});

		ThirdDataService thirdDataService = (ThirdDataService) context.getBean("thridDataService");
		UserService userService = (UserService) context.getBean("userService");
		
		UserMapper userMapper = (UserMapper) context.getBean("userMapper");
//		System.out.println(idServiceClientProxy.nextId());
		
//		User user = new User();
//		user.setId(6);
//		user.setName("刘大");
//		userMapper.insertUser(user);
		
//		User user = userMapper.findById(629925659854188544l);
//    	System.out.println(user.getId()+","+user.getNickname());
		
//		
//		List ids = new ArrayList();
//    	ids.add(1);
//    	ids.add(2);
//    	ids.add(5);
//    	ids.add(6);
//    	ids.add(7);
//    	List<User> list = userMapper.findByIds(ids);
//    	System.out.println("list size = "+list.size());
		/*
		for(int i=0; i<10; i++){
			IDView idView = idServiceClientProxy.nextIdAndPid();
			System.out.println(idView.getId()+","+idView.getPid());
		}
		*/
		
		System.out.println("id=="+ObjectId.get().toString());
		System.out.println(PopularID.getInstance().nextPid());
	}

}
