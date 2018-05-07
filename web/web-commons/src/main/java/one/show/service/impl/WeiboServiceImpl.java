package one.show.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import one.show.common.Constant;
import one.show.service.ThirdpartyService;
import one.show.service.UserService;
import one.show.struc.SinaUserParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import weibo4j.Friendships;
import weibo4j.Users;
import weibo4j.model.User;
import weibo4j.model.UserWapper;
import weibo4j.model.WeiboException;
import weibo4j.util.WeiboConfig;

import one.show.user.thrift.view.ThirdDataView;
import one.show.user.thrift.view.UserView;

/**
 * Created by Haliaeetus leucocephalus on 18/1/6.
 */
@Component
public class WeiboServiceImpl implements ThirdpartyService {

	private static final Logger log = LoggerFactory.getLogger(WeiboServiceImpl.class);
	@Autowired
	UserService userService;


	@Override
	public UserView getUserInfo(String id, String token) {
		Users um = new Users(token);
		UserView userView = new UserView();
		try {
			User user = um.showUserById(id+"");
			userView.setNickname(user.getScreenName());
			userView.setGender(user.getGender().equals("m") ? Constant.USER_SEX.MAN
					.getValue() : Constant.USER_SEX.WOMAN.getValue());
			userView.setProfileImg(user.getProfileImageUrl());
			userView.setDescription(user.getDescription());
		} catch (WeiboException e) {
			e.printStackTrace();
		}
		return userView;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<SinaUserParam> getFoucsList(String thirdId, String token)
			throws Exception {
		List<SinaUserParam> resultList = new ArrayList<SinaUserParam>();
		Friendships friendships = new Friendships(token);
		Map properties = new HashMap();
		properties.put("source", WeiboConfig.getValue("client_ID"));
		properties.put("access_token", token);
		properties.put("uid", thirdId);
		
		try {
			UserWapper userWapper = friendships.getFriends(properties);
			if (userWapper != null && userWapper.getUsers()!=null) {
				List<User>  weiboUserList = userWapper.getUsers();
				for (User user : weiboUserList) {
					try {
						String tid = user.getId();
						ThirdDataView thirdDataView = userService.findThirdDataByTidAndType(tid, "sina");
						if (thirdDataView==null) {
							continue;
						}
						SinaUserParam sinaUser = new SinaUserParam();
						sinaUser.setUid(thirdDataView.getUid()+"");
						sinaUser.setId(Long.parseLong(tid));
						sinaUser.setProfile_image_url(user.getProfileImageUrl());
						sinaUser.setScreen_name(user.getScreenName());
						resultList.add(sinaUser);
					} catch (Exception e) {
						log.error(e.getMessage(), e);
					}
				}
			}
		} catch (Exception e) {
		}
		return resultList;
	}
}