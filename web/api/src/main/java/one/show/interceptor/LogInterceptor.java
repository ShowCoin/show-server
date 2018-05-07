package one.show.interceptor;

import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import one.show.common.JacksonUtil;
import one.show.utils.IPUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Haliaeetus leucocephalus on 18/1/23.
 */
public class LogInterceptor  implements HandlerInterceptor {
    private static final Logger log = LoggerFactory.getLogger(LogInterceptor.class);

    private static String logversion = "1.0";

    private String uniqid;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        uniqid = String.valueOf(UUID.randomUUID());

        Map<String, Object> map = new HashMap<>();
        map.put("timestamp", System.currentTimeMillis());
        map.put("uniqid", uniqid);
        map.put("ip", IPUtil.getIP(httpServletRequest));
        map.put("machine", httpServletRequest.getLocalName());
        map.put("machineip", IPUtil.getLocalIP());
        map.put("logversion", logversion);
        map.put("type", "request");

        map.put("uri", httpServletRequest.getRequestURI());
        map.put("method", httpServletRequest.getMethod());

        Map<String, String> headers = new HashMap<String, String>();

        Enumeration headerNames = httpServletRequest.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = (String) headerNames.nextElement();
            String value = httpServletRequest.getHeader(key);
            headers.put(key, value);
        }

        map.put("headers", headers);
        map.put("para", httpServletRequest.getParameterMap());
        log.info(JacksonUtil.writeToJsonString(map));

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object apiHandler, ModelAndView modelAndView) throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("timestamp", System.currentTimeMillis());
        map.put("uniqid", uniqid);
        map.put("logversion", logversion);
        map.put("type", "response");

        map.put("status", httpServletResponse.getStatus());

        Map<String, String> headers = new HashMap<String, String>();
        Collection<String> headerNames = httpServletResponse.getHeaderNames();
        for (String headerName : headerNames) {
            headers.put(headerName, httpServletResponse.getHeader(headerName));
        }
        
        
        
        
        map.put("headers", headers);
        
        log.info(JacksonUtil.writeToJsonString(map));
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
