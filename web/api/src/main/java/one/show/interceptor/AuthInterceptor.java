package one.show.interceptor;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import one.show.common.cache.LocalCache;
import one.show.common.cache.RemoteCache;
import one.show.common.local.XThreadLocal;
import one.show.service.DeviceService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Haliaeetus leucocephalus on 18-2-22.
 * 验证设备是否被禁用
 */
public class AuthInterceptor implements HandlerInterceptor {

    private static final Logger log = LoggerFactory.getLogger(AuthInterceptor.class);
    
    @Autowired
    private DeviceService deviceService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
    	
    	
    	final String deviceId = XThreadLocal.getInstance().getHeaderParams().getDeviceId();

    	Boolean forbidden = false;
    	
    	if (deviceId == null || deviceId.equals("")){
    		log.warn("deviceId is null["+request.getRequestURI()+"], return true");
//    		throw new SecurityException("5002");
    		return true;
    	}
    	try {
    		 forbidden = new LocalCache<Boolean>(){

    			@Override
    			public Boolean getAliveObject() throws Exception {
    				
    				return new RemoteCache<Boolean>(){

    					@Override
    					public Boolean getAliveObject() throws Exception {
    						return deviceService.deviceIsForbidden(deviceId);
    					}
    				}.put(60*10, "device_is_forbidden_"+deviceId);
    			
    			}
    		}.put(60*10, "device_is_forbidden_"+deviceId);
        	
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
    	
		
		
		
		if (forbidden){
			log.warn("device forbidden["+request.getRequestURI()+"] : "+deviceId);
			throw new SecurityException("5002");
		}else{
			return true;
		}
		
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    

    }

}
