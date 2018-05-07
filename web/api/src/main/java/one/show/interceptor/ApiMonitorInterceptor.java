package one.show.interceptor;


import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import one.show.common.Constant.STAT_ACTION;
import one.show.common.JacksonUtil;
import one.show.common.mq.Publisher;
import one.show.common.mq.Queue;
import one.show.utils.IPUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StopWatch;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Haliaeetus leucocephalus on 18-2-22.
 */
public class ApiMonitorInterceptor implements HandlerInterceptor {

    private static final Logger log = LoggerFactory.getLogger(ApiMonitorInterceptor.class);
    
    private ThreadLocal<StopWatch> stopWatchLocal = new ThreadLocal<StopWatch>();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        StopWatch stopWatch = new StopWatch(); 
        response.setCharacterEncoding("utf-8");

        stopWatch.start();
        
        stopWatchLocal.set(stopWatch);

        return true;

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

		

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    	StopWatch stopWatch = stopWatchLocal.get();
    			
    	stopWatch.stop();
    	
    	 StringBuilder b = new StringBuilder();

         Enumeration<String> em = request.getParameterNames();

         int t = 0;

         while (em.hasMoreElements()) {
             if (t++ > 0) {
                 b.append(" , ");
             }
             String name = em.nextElement();
             b.append(name).append("=").append(request.getParameter(name));
         }
         

        String content = "ip : " + IPUtil.getIP(request) + " , uri : " + request.getRequestURI() + " , param : " + b.toString()+ " , time " + stopWatch.getTotalTimeMillis() + " ms";

       
		
        try {

		 	Map map = new HashMap();
	        map.put("ip", IPUtil.getIP(request));
			map.put("uri", request.getRequestURI());
			map.put("status", response.getStatus());
			map.put("action", STAT_ACTION.API_REQ.toString());
			map.put("time", stopWatch.getTotalTimeMillis());
			
			Publisher.getInstance().sendMessage(JacksonUtil.writeToJsonString(map), Queue.MONITOR);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}

        log.info(content);

    }
    
   

}
