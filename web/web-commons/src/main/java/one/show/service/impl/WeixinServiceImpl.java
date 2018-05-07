package one.show.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import one.show.service.ThirdpartyService;

import org.json.JSONException;
import org.json.JSONObject;

import one.show.user.thrift.view.UserView;

/**
 * Created by Haliaeetus leucocephalus on 18/1/6.
 */
public class WeixinServiceImpl implements ThirdpartyService {

    @Override
    public UserView getUserInfo(String id,  String token) {
        HttpURLConnection connection = null;
        //Create connection
        URL url = null;
        UserView userView = new UserView();
        try {
            url = new URL("https://api.weixin.qq.com/sns/userinfo?access_token="
                    + token + "&openid=" + id);
            HttpsURLConnection urlConnection = (HttpsURLConnection) url.openConnection();
            try {
                StringBuilder contents = new StringBuilder();
                BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                String line = null;
                while ((line = in.readLine()) != null) {
                    contents.append(line);
                }
                JSONObject obj = new JSONObject(contents.toString());
                userView.setNickname(obj.getString("nickname"));
                userView.setGender(1 - obj.getInt("sex"));
                userView.setProfileImg(obj.getString("headimgurl"));
                // userView.setMood(obj.getString("figureurl"));
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            } finally {
                urlConnection.disconnect();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
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
