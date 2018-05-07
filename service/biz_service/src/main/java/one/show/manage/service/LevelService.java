package one.show.manage.service;

import java.util.List;

import one.show.common.exception.ServiceException;
import one.show.manage.domain.FanLevel;
import one.show.manage.domain.MasterLevel;

public interface LevelService {
	
	public List<MasterLevel> findMasterLevelList() throws ServiceException;
	
	public List<FanLevel> findFanLevelList() throws ServiceException;
}
