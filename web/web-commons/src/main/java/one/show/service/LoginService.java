
package one.show.service;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;

import one.show.common.Loader;
import one.show.common.RandomUtils;
import one.show.common.exception.ReturnException;
import one.show.common.exception.ServiceException;
import one.show.common.util.FileUtil;
import one.show.struc.LoginParam;
import one.show.user.thrift.view.UserView;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Haliaeetus leucocephalus  2016年5月28日 上午12:13:22
 *
 * 
 */

public abstract class LoginService {

	private static final Logger log = LoggerFactory.getLogger(LoginService.class);
	
	
	public abstract UserView login(LoginParam loginParam, UserService userService) throws ReturnException, ServiceException;
	

	
	private String upload(String imageUrl){
		
		InputStream is  = null;
		try {
			URL url = new URL(imageUrl);
			 // 打开连接  
	        URLConnection con = url.openConnection();  
	        //设置请求超时为2s  
	        con.setConnectTimeout(2*1000);  
	        // 输入流  
	        is = con.getInputStream();  
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return null;
		}  
        
		
		if (is  == null){
			return null;
		}
		
		String date = new SimpleDateFormat("YMM/dd/HH/").format(new Date());
		String timestamp = String.valueOf(System.currentTimeMillis() / 1000L)+RandomUtils.generateNumber(5);
		String remotePath = "/avatar/" + date  + "/" + timestamp + ".jpg";
		
		try {
			FileUtil.copyFile(imageUrl, "/data/temp"+remotePath);
//			TencentSDK.uploadFile("showone", remotePath, new File("/data/temp"+remotePath));
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return null;
		}

		return Loader.getInstance().getProps("file.xiubi.url")+remotePath;
		
		
	}
	
	
	
}


