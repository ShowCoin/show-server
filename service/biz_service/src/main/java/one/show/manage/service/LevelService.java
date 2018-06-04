package one.show.manage.service;

import java.util.List;

import one.show.common.exception.ServiceException;
import one.show.manage.domain.FanLevel;
import one.show.manage.domain.MasterLevel;

/**
 * 等级服务
 *
 */
public interface LevelService {

	/**
	 * 主播等级列表
	 * 
	 * @return
	 * @throws ServiceException
	 */
	public List<MasterLevel> findMasterLevelList() throws ServiceException;

	/**
	 * 粉丝等级列表
	 * 
	 * @return
	 * @throws ServiceException
	 */
	public List<FanLevel> findFanLevelList() throws ServiceException;
}
