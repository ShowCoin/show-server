package one.show.manage.service;

import one.show.common.exception.ServiceException;
import one.show.manage.domain.VersionControl;

public interface VersionControlService {
	/**
	 * 获取版本更新信息
	 * @param agentType 0android  1ios
	 * @return
	 * @throws ServiceException
	 */
	public VersionControl findVersionControl(int agentType)throws ServiceException;
}
