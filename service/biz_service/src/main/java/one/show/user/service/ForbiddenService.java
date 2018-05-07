/**
 * 
 */
package one.show.user.service;

import java.util.List;

import one.show.common.exception.ServiceException;
import one.show.user.domain.Forbidden;

/**
 * @author hank
 *
 */
public interface ForbiddenService {
	
	/**
	 * 获取用户权限信息
	 * @param uid
	 * @return
	 */
	public List<Forbidden> findForbiddenListByUid(long uid) throws ServiceException;
	
	
	/**
	 * 获取用户权限action
	 * @param uid
	 * @return
	 */
	public List<Integer> getForbiddenActionListByUid(long uid) throws ServiceException;
	
	/**
	 * 添加用户权限
	 * @param forbidden
	 * @throws ServiceException
	 */
	public void saveForbidden(Forbidden forbidden) throws ServiceException;
	
	public void deleteForbiddenByUid(long uid) throws ServiceException;
	
	public void deleteForbiddenByUidAndAction(long uid,int action) throws ServiceException;

	public boolean findForbiddenByActionAndUid(long uid,int action) throws ServiceException;
	
	public List<Boolean> findForbiddenListByUidsAndAction(List<Long> uids,int action) throws ServiceException;
}