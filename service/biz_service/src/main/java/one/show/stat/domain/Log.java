package one.show.stat.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * t_log
 * @author ftx
 * @date Sun Jul 03 17:58:57 CST 2016
 *
 */
public class Log implements Serializable{

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
	/**所在城市*/
	private String city;
	/**0:ios  1:android*/
	private int platform;
	/***/
	private int logType;
	/**直播时长，秒*/
	private int liveTime;
	/**礼物价值*/
	private int sendGift;
	/**充值人民币*/
	private double rechargeRmb;
	/**充值兑换的虚拟货币*/
	private long rechargeXnb;
	/**充值支付类型*/
	private int payType;
	
	private int duration;
	/** 分享渠道**/
	private String channel;
	/**时间*/
	private int time;
	
	private String event;
	
	private int tn;
	
	private String pname;
	
	private String content;
	
	private int aid;
	
	private long vid;
	
	private int giftId;
	
	

	public long getId(){
		return this.id;
	}
	public void setId(long id){
		this.id=id;
	}
	public String getMa(){
		return this.ma;
	}
	public void setMa(String ma){
		this.ma=ma;
	}
	public String getIm(){
		return this.im;
	}
	public void setIm(String im){
		this.im=im;
	}
	public String getIdfa(){
		return this.idfa;
	}
	public void setIdfa(String idfa){
		this.idfa=idfa;
	}
	public String getIdfy(){
		return this.idfy;
	}
	public void setIdfy(String idfy){
		this.idfy=idfy;
	}
	public String getChl(){
		return this.chl;
	}
	public void setChl(String chl){
		this.chl=chl;
	}
	public double getLo(){
		return this.lo;
	}
	public void setLo(double lo){
		this.lo=lo;
	}
	public double getLt(){
		return this.lt;
	}
	public void setLt(double lt){
		this.lt=lt;
	}
	public String getMo(){
		return this.mo;
	}
	public void setMo(String mo){
		this.mo=mo;
	}
	public int getOp(){
		return this.op;
	}
	public void setOp(int op){
		this.op=op;
	}
	public String getCo(){
		return this.co;
	}
	public void setCo(String co){
		this.co=co;
	}
	public String getOs(){
		return this.os;
	}
	public void setOs(String os){
		this.os=os;
	}
	public String getSc(){
		return this.sc;
	}
	public void setSc(String sc){
		this.sc=sc;
	}
	public String getOv(){
		return this.ov;
	}
	public void setOv(String ov){
		this.ov=ov;
	}
	public String getVc(){
		return this.vc;
	}
	public void setVc(String vc){
		this.vc=vc;
	}
	public String getVn(){
		return this.vn;
	}
	public void setVn(String vn){
		this.vn=vn;
	}
	public int getNe(){
		return this.ne;
	}
	public void setNe(int ne){
		this.ne=ne;
	}
	public String getUuid(){
		return this.uuid;
	}
	public void setUuid(String uuid){
		this.uuid=uuid;
	}
	public long getUid(){
		return this.uid;
	}
	public void setUid(long uid){
		this.uid=uid;
	}
	public String getCity(){
		return this.city;
	}
	public void setCity(String city){
		this.city=city;
	}
	public int getPlatform(){
		return this.platform;
	}
	public void setPlatform(int platform){
		this.platform=platform;
	}
	public int getLogType(){
		return this.logType;
	}
	public void setLogType(int logType){
		this.logType=logType;
	}
	public int getLiveTime(){
		return this.liveTime;
	}
	public void setLiveTime(int liveTime){
		this.liveTime=liveTime;
	}
	public int getSendGift(){
		return this.sendGift;
	}
	public void setSendGift(int sendGift){
		this.sendGift=sendGift;
	}
	public double getRechargeRmb(){
		return this.rechargeRmb;
	}
	public void setRechargeRmb(double rechargeRmb){
		this.rechargeRmb=rechargeRmb;
	}
	public long getRechargeXnb(){
		return this.rechargeXnb;
	}
	public void setRechargeXnb(long rechargeXnb){
		this.rechargeXnb=rechargeXnb;
	}
	
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public int getTime(){
		return this.time;
	}
	public void setTime(int time){
		this.time=time;
	}
	public String getChannel() {
		return channel;
	}
	public void setChannel(String channel) {
		this.channel = channel;
	}
	public int getPayType() {
		return payType;
	}
	public void setPayType(int payType) {
		this.payType = payType;
	}
	
	
	
	
}