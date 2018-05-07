package one.show.manage.domain;

import java.io.Serializable;

/**
 * t_system_config
 * 
 * @author Haliaeetus leucocephalus
 * @date Wed May 25 17:15:29 CST 2016
 * 
 */
public class SystemConfig implements Serializable {

	private static final long serialVersionUID = 943026738339596243L;
	/***/
	private int configId;
	/** 版本 */
	private String version;
	/** 码率 kb */
	private int bitrate;
	/** 帧率 */
	private int frame;
	/** 分辨率，宽 */
	private int width;
	/** 分辨率 高 */
	private int height;
	/** 支付宝开关 */
	private int alipay;
	/** 微信支付开关 */
	private int weixinpay;
	/** 苹果支付开关 */
	private int applepay;
	
	/** 新浪微博分享文案 */
	private String shareSina;
	/** QQ分享文案 */
	private String shareQq;
	/** QQ空间分享文案 */
	private String shareQqzone;
	/** 微信分享文案 */
	private String shareWx;
	/** 微信朋友圈分享文案 */
	private String shareWxPyq;
	/** 广告开关 */
	private int showAd;
	
	/** qq登陆开关 */
	private int showQQLogin;
	
	/** 兑换按钮开关 */
	private int showExchange;
	/***/
	private int createTime;

	public int getConfigId() {
		return this.configId;
	}

	public void setConfigId(int configId) {
		this.configId = configId;
	}

	public String getVersion() {
		return this.version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public int getBitrate() {
		return this.bitrate;
	}

	public void setBitrate(int bitrate) {
		this.bitrate = bitrate;
	}

	public int getFrame() {
		return this.frame;
	}

	public void setFrame(int frame) {
		this.frame = frame;
	}

	public int getWidth() {
		return this.width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return this.height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getAlipay() {
		return this.alipay;
	}

	public void setAlipay(int alipay) {
		this.alipay = alipay;
	}

	public int getWeixinpay() {
		return this.weixinpay;
	}

	public void setWeixinpay(int weixinpay) {
		this.weixinpay = weixinpay;
	}

	public String getShareSina() {
		return this.shareSina;
	}

	public void setShareSina(String shareSina) {
		this.shareSina = shareSina;
	}

	public String getShareQq() {
		return this.shareQq;
	}

	public void setShareQq(String shareQq) {
		this.shareQq = shareQq;
	}

	public String getShareQqzone() {
		return this.shareQqzone;
	}

	public void setShareQqzone(String shareQqzone) {
		this.shareQqzone = shareQqzone;
	}

	public String getShareWx() {
		return this.shareWx;
	}

	public void setShareWx(String shareWx) {
		this.shareWx = shareWx;
	}

	public String getShareWxPyq() {
		return this.shareWxPyq;
	}

	public void setShareWxPyq(String shareWxPyq) {
		this.shareWxPyq = shareWxPyq;
	}

	public int getShowAd() {
		return this.showAd;
	}

	public void setShowAd(int showAd) {
		this.showAd = showAd;
	}

	public int getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(int createTime) {
		this.createTime = createTime;
	}

	public int getShowQQLogin() {
		return showQQLogin;
	}

	public void setShowQQLogin(int showQQLogin) {
		this.showQQLogin = showQQLogin;
	}

	public int getShowExchange() {
		return showExchange;
	}

	public void setShowExchange(int showExchange) {
		this.showExchange = showExchange;
	}

	public int getApplepay() {
		return applepay;
	}

	public void setApplepay(int applepay) {
		this.applepay = applepay;
	}
	
	
}