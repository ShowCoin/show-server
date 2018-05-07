package one.show.interceptor;


import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import one.show.common.DESUtil;
import one.show.common.TimeUtil;
import one.show.common.local.XThreadLocal;
import one.show.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Haliaeetus leucocephalus on 18-2-22.
 */
public class UserInterceptor implements HandlerInterceptor {

    private static final Logger log = LoggerFactory.getLogger(UserInterceptor.class);
    

    @Autowired
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler){


        final String uid_str = request.getHeader("User-Id");
        String token = request.getHeader("User-Token");


        XThreadLocal.getInstance().setCurrentUser(null);
        
        if (uid_str != null && token != null){
        	String[] arr = null;
        	try{
        		DESUtil du = new DESUtil();
            	String plain = du.decrypt(token);
            	arr = plain.split("\\|");
        	}catch(Exception e){
        		log.info("token解析失败　:"+token);
        		
        	}
        	
        	
        	if (arr != null && arr.length == 2 && arr[0].equalsIgnoreCase(uid_str)){
        		Date lastDate = new Date();
    			Integer loginTime = Integer.parseInt(arr[1]);
        		if((loginTime- (int)(lastDate.getTime()/1000)) >= 30 * 24 * 3600){
        			XThreadLocal.getInstance().setCurrentUser(null);
        		}else{
        			XThreadLocal.getInstance().setCurrentUser(Long.parseLong(arr[0]));
        		}
        		
        		XThreadLocal.getInstance().setCurrentUser(Long.parseLong(arr[0]));
				log.info("login time:"+TimeUtil.intDate2String(loginTime, "yyyy-MM-dd HH:mm:ss"));
				
        	}
        	
        	
        }
        
        
    	
        return true;

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    

    }

}
