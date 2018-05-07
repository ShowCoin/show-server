/**
 * 
 */
package one.show.user.service;

import java.util.List;
import java.util.Map;

import one.show.common.exception.ServiceException;
import one.show.user.domain.ThirdData;

/**
 * @author kevin 
 *
 */
public interface ThirdDataService {
	
	/**
	 * 获取第三方用户绑定信息
	 * @param tid
	 * @param type
	 * @return
	 */
	public ThirdData findByTidAndType(String tid, String type);

	/**
	 *
	 * @param thirdData
	 * @return -1 duplicate key
	 * @throws ServiceException
	 */
	public int save(ThirdData thirdData) throws ServiceException;
	
	
	public void updateThridData(String tid,String type, Map<String,String> map) throws ServiceException;
	
	public void deleteThirdData(String tid,String type) throws ServiceException;

	public List<ThirdData> findThirdDataListByUid(long uid) throws ServiceException;

	public ThirdData findThirdDataByUidAndType(long uid, String type) throws ServiceException;
	
}


