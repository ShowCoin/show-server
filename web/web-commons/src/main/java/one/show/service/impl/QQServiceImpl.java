package one.show.service.impl;

import java.util.HashMap;
import java.util.List;

import one.show.common.Constant;
import one.show.service.ThirdpartyService;

import org.json.JSONException;
import org.json.JSONObject;

import one.show.user.thrift.view.UserView;
import com.qq.open.OpenApiV3;
import com.qq.open.OpensnsException;

/**
 * Created by Haliaeetus leucocephalus on 18/1/6.
 */
public class QQServiceImpl implements ThirdpartyService {
    private String appid = "1105352619";
    private String appkey = "NohBQw0YywMIwuNQ";
    String serverName = "openapi.tencentyun.com";
    String pf = "qzone";
    OpenApiV3 sdk = new OpenApiV3(appid, appkey);

    public QQServiceImpl() {
        sdk.setServerName(serverName);
    }

    @Override
    public UserView getUserInfo(String id,  String token) {

        String scriptName = "/v3/user/get_info";

        // 指定HTTP请求协议类型
        String protocol = "http";

        // 填充URL请求参数
        HashMap<String,String> params = new HashMap<String, String>();
        params.put("openid", id+"");
        params.put("openkey", token);
        params.put("pf", pf);

        UserView userView = new UserView();

        try
        {
            String resp = sdk.api(scriptName, params, protocol);
            JSONObject obj = new JSONObject(resp);
            userView.setNickname(obj.getString("nickname"));
            userView.setGender(obj.getString("gender").equals("男") ? Constant.USER_SEX.MAN.getValue() : Constant.USER_SEX.WOMAN.getValue());
            userView.setProfileImg(obj.getString("figureurl"));
            // userView.setMood(obj.getString(""));
        }
        catch (OpensnsException e)
        {
            System.out.printf("Request Failed. code:%d, msg:%s\n", e.getErrorCode(), e.getMessage());
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return userView;
    }

	@Override
	public List<UserView> getFoucsList(String id, String token) {
		// TODO Auto-generated method stub
		return null;
	}
}
