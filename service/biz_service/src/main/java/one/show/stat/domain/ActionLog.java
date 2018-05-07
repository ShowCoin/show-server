package one.show.stat.domain;

import java.io.Serializable;

/**
 * t_log
 * @author ftx
 * @date Sun Jul 03 17:58:57 CST 2016
 *
 */
public class ActionLog implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3559871311946926453L;
	/***/
	private long id;
	/**MAC地址，仅对WIFI连接时有效*/
	private String ma;
	/**IMEI串号*/
	private String im;
	/***/
	private String idfa;
	/***/
	private String idfy;
	/**渠道号*/
	private String chl;
	/**经度*/
	private double lo;
	/**纬度*/
	private double lt;
	/**机型*/
	private String mo;
	/**终端运营商名称 1移动  2联通  3电信*/
	private int op;
	/**终端所处国家*/
	private String co;
	/**操作系统名称*/
	private String os;
	/**屏幕分辨率*/
	private String sc;
	/**操作系统版本*/
	private String ov;
	/**应用版本号*/
	private String vc;
	/**应用版本名*/
	private String vn;
	/**联网方式 1：未知、 2：2g、 3：3g、 4：4g、 5：WIFI*/
	private int ne;
	/**设备id*/
	private String uuid;
	/**用户id*/
	private long uid;
	/**全局事件序号，每次发送事件增加1*/
	private int tn;
	/**页面名称*/
	private String pname;
	/**聊天内容*/
	private String content;
	/**广告id*/
	private int aid;
	/**直播ID*/
	private long vid;
	/**所在城市*/
	private String city;
	/**0:ios  1:android*/
	private int platform;
	/**事件名称*/
	private String event;
	/**送礼id*/
	private int giftId;
	/**礼物价值*/
	private int sendGift;
	/**充值人民币*/
	private double amount;
	/***/
	private int payType;
	/**session时间 ，秒*/
	private int duration;
	/**分享渠道*/
	private String channel;
	/**时间*/
	private int time;
	
	private String ip;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMa() {
		return ma;
	}

	public void setMa(String ma) {
		this.ma = ma;
	}

	public String getIm() {
		return im;
	}

	public void setIm(String im) {
		this.im = im;
	}

	public String getIdfa() {
		return idfa;
	}

	public void setIdfa(String idfa) {
		this.idfa = idfa;
	}

	public String getIdfy() {
		return idfy;
	}

	public void setIdfy(String idfy) {
		this.idfy = idfy;
	}

	public String getChl() {
		return chl;
	}

	public void setChl(String chl) {
		this.chl = chl;
	}

	public double getLo() {
		return lo;
	}

	public void setLo(double lo) {
		this.lo = lo;
	}

	public double getLt() {
		return lt;
	}

	public void setLt(double lt) {
		this.lt = lt;
	}

	public String getMo() {
		return mo;
	}

	public void setMo(String mo) {
		this.mo = mo;
	}

	public int getOp() {
		return op;
	}

	public void setOp(int op) {
		this.op = op;
	}

	public String getCo() {
		return co;
	}

	public void setCo(String co) {
		this.co = co;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public String getSc() {
		return sc;
	}

	public void setSc(String sc) {
		this.sc = sc;
	}

	public String getOv() {
		return ov;
	}

	public void setOv(String ov) {
		this.ov = ov;
	}

	public String getVc() {
		return vc;
	}

	public void setVc(String vc) {
		this.vc = vc;
	}

	public String getVn() {
		return vn;
	}

	public void setVn(String vn) {
		this.vn = vn;
	}

	public int getNe() {
		return ne;
	}

	public void setNe(int ne) {
		this.ne = ne;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public long getUid() {
		return uid;
	}

	public void setUid(long uid) {
		this.uid = uid;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getPlatform() {
		return platform;
	}

	public void setPlatform(int platform) {
		this.platform = platform;
	}

	public int getSendGift() {
		return sendGift;
	}

	public void setSendGift(int sendGift) {
		this.sendGift = sendGift;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getPayType() {
		return payType;
	}

	public void setPayType(int payType) {
		this.payType = payType;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public int getTn() {
		return tn;
	}

	public void setTn(int tn) {
		this.tn = tn;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public long getVid() {
		return vid;
	}

	public void setVid(long vid) {
		this.vid = vid;
	}

	public int getGiftId() {
		return giftId;
	}

	public void setGiftId(int giftId) {
		this.giftId = giftId;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}
	
	

	
	
	
}