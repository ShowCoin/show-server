package one.show.user.service;

import java.util.List;
import java.util.Map;

import one.show.common.exception.ServiceException;
import one.show.user.domain.Gps;

public interface GpsService {
	public Gps findGpsByUid(long uid) throws ServiceException;
	public void saveGps(Gps gps) throws ServiceException;
	public void updateGps(long uid,Map<String,String> params)throws ServiceException;
	public List<Gps> findNearGpsList(Map<String,String> params,int start,int count) throws ServiceException;
}
