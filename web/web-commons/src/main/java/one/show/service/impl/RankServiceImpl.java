package one.show.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import one.show.common.Adapter;
import one.show.common.cache.LocalCache;
import one.show.common.exception.ServiceException;
import one.show.service.PayService;
import one.show.service.RankService;
import one.show.service.UserService;

import org.apache.thrift.TException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import one.show.pay.thrift.view.GiftRankView;
import one.show.stat.thrift.iface.StatServiceProxy;
import one.show.stat.thrift.view.RankUserListView;
import one.show.user.thrift.view.UserView;

/**
 * Created by Andy on 15/8/19.
 */
@Component("rankService")
public class RankServiceImpl implements RankService {

	private static final Logger log = LoggerFactory
			.getLogger(RankServiceImpl.class);

	@Autowired
	UserService userService;

	@Autowired
	PayService payService;
	
	@Autowired
	private StatServiceProxy.Iface statServiceClientProxy;


	@Override
	public RankUserListView findUserRankList(int beginTime, int endTime,
			int type, int start, int count) throws ServiceException {

		try {
			return statServiceClientProxy.findRankUserList(beginTime, endTime, type, start, count);
		} catch (TException e) {
			throw new ServiceException(e);
		}
	}


	@Override
	public List<Map<String, Object>> findDefenderList(final long uid, final int start,
			final int count) throws ServiceException {

		 List<Map<String, Object>> resultList = null;
	        try {
				resultList = new LocalCache<List<Map<String, Object>>>() {

					@Override
					public List<Map<String, Object>> getAliveObject() throws Exception {
						
						List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();

						//守护榜
						List<GiftRankView> ranks = null;
						try {
							ranks = payService.findGiftRanks(uid,start,count);
						} catch (Exception e) {
							log.error(e.getMessage(), e);
						}

				        
				        if (ranks != null){
				        	for(GiftRankView giftRankView : ranks){
				        		 Map<String, Object> map = new HashMap<String, Object>();
				        		 UserView userView = null;
								try {
									userView = userService
									         .findUserById(giftRankView.getFromUid());
								} catch (ServiceException e) {
									log.error(e.getMessage(), e);
								}
				        		 if (userView == null){
				        			 continue;
				        		 }
				        		 
				        		 map.put("uid", giftRankView.getFromUid());
				        		 map.put("nickName", userView.getNickname());
				        		 map.put("pid", userView.getPopularNo());
				        		 map.put("profileImg", Adapter.getAvatar(userView.getProfileImg()));
				        		 map.put("total", giftRankView.getTotal());
				        		 map.put("follow_state", "0");
				        		 resultList.add(map);
				        	}
				        }
				        
				        return resultList;
					}
					
				}.put(5 * 60, "defender_list_"+uid+"_"+start+"_"+count);
			} catch (Exception e) {
				log.error(e.getMessage(), e);
			}
	        
	        return resultList;
	}
	
		
}
