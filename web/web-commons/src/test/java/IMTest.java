import java.util.HashMap;
import java.util.List;
import java.util.Map;

import one.show.common.JacksonUtil;
import one.show.common.exception.ServiceException;
import one.show.common.im.IMUtils;
import one.show.common.im.MessageFactory;
import one.show.common.im.SystemMessage;

import com.google.common.collect.ImmutableList;


public class IMTest {

	public static void main(String[] args) {
		boolean result = false;
		try {

//			result = IMUtils.getInstants().createChatRoom("750291518618730496", "房间");
//			result = IMUtils.getInstants().rollbackKickChatRoomUser("738343975949312000", String.valueOf(740083958267650048l));
//			IMUtils.getInstants().getToken("742956173212401664", "自定义一对一消息", "http://file0.xiubi.com/avatar/201606/02/19//146486551404968.jpg");
			List<String> ids = ImmutableList.of("738343975949312000");
//			result = IMUtils.getInstants().publishSystemMessage(ids, new TxtMessage("这里是消息内容"), "这里是pushcontent", "{\"type\":\"3\"} ");
			result = IMUtils.getInstants().publishSystemMessage("753815404861849600", MessageFactory.createSystemMessage(SystemMessage.UPDATE_USER_SHOWCOIN, "199"));
//			JSONArray arr = IMUtils.getInstants().wordFilterList();
//			System.out.print(arr.toString());
			
//			IMUtils.getInstants().refreshUser("738338939366162432", "系统消息", "http://file0.xiubi.com/avatar/201606/02/19//146486551404968.jpg");
//			result = IMUtils.getInstants().publishBroadcastMessage(new TxtMessage("广播消息"), "pushcontent" , "{\"pushData\":\"hello\"}", null);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		System.out.println(result);
		
//		String data = "{\"type\":4,\"data\":{\"uid\":\"33\",\"nickName\":\"ces\",\"fanLevel\":4}}";
//		ChatRoomMessage cm = null;
//		
//		try {
//			
//			JSONObject msg = new JSONObject();
//			JSONObject json = new JSONObject();
//			try {
//				json.put("giftId", 2);
//				json.put("giftName", "樱花雨");
//				json.put("giftImg", "http://img.meelive.cn/OTc4MzYxNDUxODkzMDk4.jpg");
//				json.put("giftIcon", "http://img.meelive.cn/NTg4MzMxNDUxODkzMDkw.jpg");
//				json.put("num", 2);
//				json.put("count", 10);
//				json.put("fromUid", "737529241767387136");
//				json.put("fromNickName","土圭垚㙓");
//				json.put("fromUserImg", "http://wx.qlogo.cn/mmopen/j8cooK2zCqrjedcibLfJUZCNkD8qBKibR4cl8NOJXWdmXrUBVdOUj5bkkajGubgYzXEpmmVBl22gBiav4saL3dibFW1kMSx8wqR5/0");
//				
//				msg.put("type", ChatRoomMessage.TYPE_GIFT);
//				msg.put("data", json);
//			} catch (JSONException e) {
//				throw new ServiceException(e);
//			}
//			cm =  new ChatRoomMessage("chatRoomMsg",msg.toString());
//			
//			result = IMUtils.getInstants().publishChatroomMessage("0", ImmutableList.of("1"), cm);
//		} catch (ServiceException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		
//		Map<String, Object> params = new HashMap<String, Object>();
//		params.put("giftId", 2);
//		params.put("giftName", "樱花雨");
//		params.put("giftImg", "http://img.meelive.cn/OTc4MzYxNDUxODkzMDk4.jpg");
//		params.put("giftIcon", "http://img.meelive.cn/NTg4MzMxNDUxODkzMDkw.jpg");
//		params.put("num", 2);
//		params.put("count", 10);
//		params.put("fromUid", "737529241767387136");
//		params.put("fromNickName","土圭垚㙓");
//		params.put("fromUserImg", "http://wx.qlogo.cn/mmopen/j8cooK2zCqrjedcibLfJUZCNkD8qBKibR4cl8NOJXWdmXrUBVdOUj5bkkajGubgYzXEpmmVBl22gBiav4saL3dibFW1kMSx8wqR5/0");
//		try {
//			System.out.println(JacksonUtil.writeToJsonString(MessageFactory.createGiftMessage(params)));
//			IMUtils.getInstants().publishChatroomMessage(String.valueOf("1234567"), ImmutableList.of("1"), MessageFactory.createGiftMessage(params));
//		} catch (ServiceException e1) {
			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		
//		try {
//			ChatRoomMessage msg = MessageFactory.createHeartMessage(737529241767387136L,"土圭垚㙓",1);
//			IMUtils.getInstants().publishChatroomMessage( "1", msg);
//		} catch (ServiceException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		
//		try {
//			List<ChatroomInfo> list = IMUtils.getInstants().getChatRoom(ImmutableList.of("738669717476220928"));
//			System.out.println(list);
//		} catch (ServiceException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		List<Long> map;
//		try {
//			map = IMUtils.getInstants().queryChatRoomUsers("1");
//			System.out.println(TypeUtil.typeToString("users", map));
//		} catch (ServiceException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		try {
//			IMUtils.getInstants().blockChatRoomUser("1", "736494904515108864",1);
//		IMUtils.getInstants().blockChatRoomUser("1", "737890244380205056",1);
//		} catch (ServiceException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
	}
}
