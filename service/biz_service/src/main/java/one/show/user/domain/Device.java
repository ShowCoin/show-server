package one.show.user.domain;

import java.io.Serializable;

public class Device implements Serializable{
	
	private static final long serialVersionUID = 8221358519660997234L;
	private String deviceUuid;
	//平台
	private String platform;
	private long uid;
	//app版本
	private String appVersion;
	private String channel;
	private String deviceName;
	//#内核版本
	private String kernelVersion;
	//推送id
	private String pushId;
	//手机类型
	private String phoneType;
	//手机号码
	private String phoneNumber;
	//手机系统
	private String os;
	//创建时间
	private int createTime;
	//更新时间
	private int updateTime;
	//分辨率
	private String sc;
	
	public String getDeviceUuid() {
		return deviceUuid;
	}
	public void setDeviceUuid(String deviceUuid) {
		this.deviceUuid = deviceUuid;
	}
	public String getPlatform() {
		return platform;
	}
	public void setPlatform(String platform) {
		this.platform = platform;
	}
	public long getUid() {
		return uid;
	}
	public void setUid(long uid) {
		this.uid = uid;
	}
	public String getAppVersion() {
		return appVersion;
	}
	public void setAppVersion(String appVersion) {
		this.appVersion = appVersion;
	}
	public String getChannel() {
		return channel;
	}
	public void setChannel(String channel) {
		this.channel = channel;
	}
	public String getDeviceName() {
		return deviceName;
	}
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}
	public String getKernelVersion() {
		return kernelVersion;
	}
	public void setKernelVersion(String kernelVersion) {
		this.kernelVersion = kernelVersion;
	}
	public String getPushId() {
		return pushId;
	}
	public void setPushId(String pushId) {
		this.pushId = pushId;
	}
	public String getPhoneType() {
		return phoneType;
	}
	public void setPhoneType(String phoneType) {
		this.phoneType = phoneType;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getOs() {
		return os;
	}
	public void setOs(String os) {
		this.os = os;
	}
	public int getCreateTime() {
		return createTime;
	}
	public void setCreateTime(int createTime) {
		this.createTime = createTime;
	}
	public int getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(int updateTime) {
		this.updateTime = updateTime;
	}
	public String getSc() {
		return sc;
	}
	public void setSc(String sc) {
		this.sc = sc;
	}
	
	
	
}
