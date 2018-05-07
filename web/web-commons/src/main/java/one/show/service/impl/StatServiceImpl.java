/**
 * 
 */
package one.show.service.impl;

import one.show.common.exception.ServiceException;
import one.show.service.StatService;

import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import one.show.stat.thrift.iface.StatServiceProxy;
import one.show.stat.thrift.view.SummaryStatView;
import one.show.stat.thrift.view.UserStatView;
import one.show.stat.thrift.view.VideoStatView;

import java.util.List;

/**
 * @author Haliaeetus leucocephalus 2018年1月6日 下午10:46:13
 *
 */

@Component("statService")
public class StatServiceImpl implements StatService {
	
	@Autowired
	private StatServiceProxy.Iface statServiceClientProxy;

	/* (non-Javadoc)
	 * @see StatService#findUserStatByUid(java.lang.String)
	 */
	@Override
	public UserStatView findUserStatByUid(Long uid) throws ServiceException {
		try {
			return statServiceClientProxy.findUserStatByUid(uid);
		} catch (TException e) {
			throw new ServiceException(e);
		}
	}
	
	@Override
	public VideoStatView findVideoStatByVid(Long vid) throws ServiceException {
		try {
			return statServiceClientProxy.findVideoStatByVid(vid);
		} catch (TException e) {
			throw new ServiceException(e);
		}
	}



	@Override
	public List<UserStatView> findUserStatByUids(List<Long> uids) throws ServiceException {
		try {
			return statServiceClientProxy.findUserStatByUids(uids);
		} catch (TException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public List<VideoStatView> findVideoStatByVids(List<Long> vids) throws ServiceException {
		try {
			return statServiceClientProxy.findVideoStatByVids(vids);
		} catch (TException e) {
			throw new ServiceException(e);
		}
	}

	/* (non-Javadoc)
	 * @see one.show.service.StatService#getSummaryStatList(java.lang.Integer)
	 */
	@Override
	public List<SummaryStatView> getSummaryStatList(Integer time)
			throws ServiceException {
		try {
			return statServiceClientProxy.getSummaryStatList(time);
		} catch (TException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public void deleteUserStat(Long uid) throws ServiceException {

		try {
			statServiceClientProxy.deleteUserStat(uid);
		} catch (TException e) {
			throw new ServiceException(e);
		}
		
	}

}


