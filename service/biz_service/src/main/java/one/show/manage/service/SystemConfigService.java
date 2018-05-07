package one.show.manage.service;

import java.util.List;
import java.util.Map;

import one.show.common.exception.ServiceException;
import one.show.manage.domain.SystemConfig;

public interface SystemConfigService {
	public List<SystemConfig> getSystemConfigList(Map<String, String> paramMap,int start,int count) throws ServiceException;
	public void addSystemConfig(SystemConfig systemConfig) throws ServiceException;
    public void deleteSystemConfig(String configId) throws ServiceException;
	public SystemConfig getSystemConfig(String configId) throws ServiceException;
	public void updateSystemConfig(SystemConfig systemConfig) throws ServiceException;
	public SystemConfig getSystemConfigByVersion(String version) throws ServiceException;
}