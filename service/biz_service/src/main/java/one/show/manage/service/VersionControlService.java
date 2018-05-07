package one.show.manage.service;

import one.show.common.exception.ServiceException;
import one.show.manage.domain.VersionControl;

public interface VersionControlService {
	public VersionControl findVersionControl(int agentType)throws ServiceException;
}
