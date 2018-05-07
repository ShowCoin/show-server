package one.show.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 添加删除cookie
 * 
 */
public class CookieUtil {
	
	private static Logger logger = LoggerFactory.getLogger(CookieUtil.class);


    public static void write(HttpServletResponse response, String name, String value, String domain, String path, int age) {
    	
        Cookie cookie = new Cookie(name, value);
        cookie.setMaxAge(age);
        if (domain != null && !domain.equals("")){
        	cookie.setDomain(domain);
        }
        
        cookie.setPath(path);
        response.addCookie(cookie);
    }
    

	public static String read(HttpServletRequest request, String cookieName) {

        String value = null;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                if (cookies[i].getName().equalsIgnoreCase(cookieName)) {
                    value = cookies[i].getValue();
                    break;
                }
            }
        }
        
        return value;
    }

    public static void delete(HttpServletRequest request, HttpServletResponse response, String cookieName) {
        Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            Cookie c = null;
            for (int i = 0; i < cookies.length; i++) {
                c = cookies[i];
                if (c.getName().equalsIgnoreCase(cookieName)) {
                    c.setMaxAge(0);
                    response.addCookie(c);
                    break;
                }
                c = null;
            }
        }
    }

   

}
