/**
 * 
 */
package one.show.service.impl;

import one.show.service.AdminVideoService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import one.show.manage.thrift.iface.ManageServiceProxy;
import one.show.stat.thrift.iface.StatServiceProxy;
import one.show.user.thrift.iface.UserServiceProxy;
import one.show.video.thrift.iface.VideoServiceProxy;

/**
 * @author hank 2015年8月24日
 * 
 */
@Component
public class AdminVideoServiceImpl implements AdminVideoService {

	private static final Logger log = LoggerFactory
			.getLogger(AdminVideoServiceImpl.class);
	@Autowired
	private VideoServiceProxy.Iface videoServiceClientProxy;
	@Autowired
	private UserServiceProxy.Iface userServiceClientProxy;
	@Autowired
	private StatServiceProxy.Iface statServiceClientProxy;
	@Autowired
	private ManageServiceProxy.Iface manageServiceClientProxy;
	
	
	
}
