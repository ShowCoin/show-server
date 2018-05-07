package one.show.service;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;

import one.show.common.HttpsUtil;
import one.show.common.cache.RemoteCache;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.collections4.Transformer;
import org.apache.commons.collections4.TransformerUtils;
import org.apache.commons.collections4.map.TransformedMap;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.google.common.base.Joiner;

/**
 * Created by Haliaeetus leucocephalus on 15/11/16.
 */
@Component
public class WechatPay {
    private static final Logger log = LoggerFactory.getLogger(WechatPay.class);

    private static final String key = "a19657e7a129ec39d570c4863d64316e";
    private static final String appid = "wx49408dc8d6e448e8";
    private static final String secret = "4b1b78e41f417b041257adaa2daf6112";

    public String getToken() throws JSONException {
        String token = null;
        try {
            token = new RemoteCache<String>() {
                @Override
                public String getAliveObject() throws Exception {
                    return _getToken(appid, secret);
                }
            }.put(6600, "wechat:access_token:" + appid);
        } catch (JSONException e1) {
            throw e1;
        }catch (Exception e) {
            log.error(e.getMessage(), e);
            try {
                token = _getToken(appid, secret);
            } catch (JSONException e2) {
                throw e2;
            }
        }

        return token;
    }

    private String _getToken(String appid, String secret) throws JSONException {
        Map<String, String> map = new HashMap<>();
        map.put("grant_type", "client_credential");
        map.put("appid", appid);
        map.put("secret", secret);
        String response = HttpsUtil.post("https://api.weixin.qq.com/cgi-bin/token", map);
        JSONObject obj = new JSONObject(response);

        return obj.getString("access_token");
    }

    public String genSign(SortedMap<String, String> params) throws UnsupportedEncodingException {
        String appkey = "N2CdUjYtACjDZNPxFJd8TfV3W69NBDbSzy30Ysj9IRLnFYsbIIgjNl2ZsWHqO58CfPbcAKZzdBn6zcxUUUt3XPH348We42iyip1gLFDz7BkliyRDiGEt6jl8y9gB7OLR";
        params.put("appkey",appkey);

        String data = Joiner.on("&").withKeyValueSeparator("=").join(
                TransformedMap.transformedMap(params, TransformerUtils.<String>nopTransformer(), new Transformer<String, String>() {
                    @Override
                    public String transform(String s) {
                        try {
                            return URLDecoder.decode(s,"UTF-8");
                        } catch (UnsupportedEncodingException e) {
                            return s;
                        }
                    }
                }));


        return DigestUtils.shaHex(data);
    }

    public String genPackage(SortedMap<String, String> params) throws UnsupportedEncodingException {
        String md5Sign = getMd5Sign(params);

        TransformedMap<String, String> map = TransformedMap.transformedMap(params, TransformerUtils.<String>nopTransformer(), new Transformer<String, String>() {
            @Override
            public String transform(String s) {
                try {
                    // todo 这里应该用的是rawurlencode
                    return URLEncoder.encode(s, "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    return s;
                }
            }
        });
        String data = Joiner.on("&").withKeyValueSeparator("=").join(map);

        return data + "&sign=" + md5Sign;
    }

    public String getMd5Sign(SortedMap<String, String> params) {
        String join = Joiner.on("&").withKeyValueSeparator("=").join(params) + "&key=" + key;
        return DigestUtils.md5Hex(join).toUpperCase();
    }
}
