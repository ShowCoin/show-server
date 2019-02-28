package one.show.user.service;

import java.util.Map;

import one.show.common.exception.ServiceException;
import one.show.user.domain.Setting;

/**
 * 
 * @author hank
 *
 */
public interface SettingService {
	
	public void setSwitch(String uid,Map<String, String> paramMap) throws ServiceException;
	
	public Setting getSettingByUid(String uid);

	public Setting getSysSetting() throws ServiceException;
}
