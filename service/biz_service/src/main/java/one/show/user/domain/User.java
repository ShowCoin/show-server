package one.show.user.domain;

import java.io.Serializable;

import one.show.common.Constant.USER_SEX;

/**
 * @author kevin
 * @version Last modified 15/3/5
 * @since 0.0.1
 *        <p/>
 *        用户表，按uid分表
 */
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -330461472967666007L;
	
	/**主播ID*/
	private long id;
	/**消费等级*/
	private int fanLevel;
	/**是否当前正在直播 0 没有直播，1 正在直播*/
	private int islive;
	/**昵称*/
	private String nickname;
	/**主播级别*/
	private int masterLevel = 1;
	/**财富等级*/
	private int showLevel = 0;
	/**最后登录时间*/
	private int lastLogintime;
	/**最后直播时间*/
	private int lastLivetime;
	/**最后活跃时间*/
	private int lastActivetime;
	/**生日*/
	private String birthday;
	/**0 普通用户  1签约主播*/
	private int role;
	/**签约状态  0 未签约 ， 1 正在申请成为签约主播 ， 2 签约通过，3签约拒绝*/
	private int signStatus;
	/**靓号*/
	private long popularNo;
	/**注册时间*/
	/**是否是假人 0不是  1是*/
	private int isrobot;
	/**总消费*/
	private double totalFanValue;
	/**总收入*/
	private double totalMasterValue;
	/**纬度*/
	private double latitude;
	/**经度*/
	private double longitude;
	/**性别 2女  1男  0未知*/
	private int gender = 2;
	/**是否新用户*/
	private int isNew = 0;
	/**是否巡管*/
	private int isAdmin = 0;
	
	//old

	// 是否被审核
	private int active;

	// 用户创建时间
	private int createTime;

	private String profileImg;
	
	private String largeProfileImg;

	private String city;

	private int age;
	/**星座*/
	private String constellation;

	private String description;
	/**融云token*/
	private String ryToken;
	
	private String deviceUuid;
	/**手机号*/
	private String phoneNumber;
	
	private String lastLoginType;
	
	private int notifyConfig = 63;
	
	private long familyId;

	private String ip;

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getVipExpire() {
		return vipExpire;
	}

	public String getLargeProfileImg() {
		return largeProfileImg;
	}

	public void setLargeProfileImg(String largeProfileImg) {
		this.largeProfileImg = largeProfileImg;
	}

	public void setVipExpire(int vipExpire) {
		this.vipExpire = vipExpire;
	}

	// vip过期时间
	private int vipExpire;

	private int catalog;

	//心情
	private String mood;
	
	private int updateTime;

	// 自我介绍
	
	public long getId() {
		return id;
	}

	public int getShowLevel() {
		return showLevel;
	}

	public void setShowLevel(int showLevel) {
		this.showLevel = showLevel;
	}

	public int getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getFanLevel() {
		return fanLevel;
	}

	public void setFanLevel(int fanLevel) {
		this.fanLevel = fanLevel;
	}

	public int getIslive() {
		return islive;
	}

	public void setIslive(int islive) {
		this.islive = islive;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public int getMasterLevel() {
		return masterLevel;
	}

	public void setMasterLevel(int masterLevel) {
		this.masterLevel = masterLevel;
	}

	public int getLastLogintime() {
		return lastLogintime;
	}

	public void setLastLogintime(int lastLogintime) {
		this.lastLogintime = lastLogintime;
	}

	public int getLastLivetime() {
		return lastLivetime;
	}

	public void setLastLivetime(int lastLivetime) {
		this.lastLivetime = lastLivetime;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public int getSignStatus() {
		return signStatus;
	}

	public void setSignStatus(int signStatus) {
		this.signStatus = signStatus;
	}

	public long getPopularNo() {
		return popularNo;
	}

	public void setPopularNo(long popularNo) {
		this.popularNo = popularNo;
	}

	public int getIsrobot() {
		return isrobot;
	}

	public void setIsrobot(int isrobot) {
		this.isrobot = isrobot;
	}

	public double getTotalFanValue() {
		return totalFanValue;
	}

	public void setTotalFanValue(double totalFanValue) {
		this.totalFanValue = totalFanValue;
	}

	public double getTotalMasterValue() {
		return totalMasterValue;
	}

	public void setTotalMasterValue(double totalMasterValue) {
		this.totalMasterValue = totalMasterValue;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public int getCreateTime() {
		return createTime;
	}

	public void setCreateTime(int createTime) {
		this.createTime = createTime;
	}

	public String getProfileImg() {
		return profileImg;
	}

	public void setProfileImg(String profileImg) {
		this.profileImg = profileImg;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int birth) {
		this.age = birth;
	}

	public String getConstellation() {
		return constellation;
	}

	public void setConstellation(String constellation) {
		this.constellation = constellation;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getCatalog() {
		return catalog;
	}

	public void setCatalog(int catalog) {
		this.catalog = catalog;
	}

	public String getMood() {
		return mood;
	}

	public void setMood(String mood) {
		this.mood = mood;
	}

	public int getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(int updateTime) {
		this.updateTime = updateTime;
	}


	public int getIsNew() {
		return isNew;
	}

	public void setIsNew(int isNew) {
		this.isNew = isNew;
	}

	public String getRyToken() {
		return ryToken;
	}

	public void setRyToken(String ryToken) {
		this.ryToken = ryToken;
	}

	public String getDeviceUuid() {
		return deviceUuid;
	}

	public void setDeviceUuid(String deviceUuid) {
		this.deviceUuid = deviceUuid;
	}

	public String getLastLoginType() {
		return lastLoginType;
	}

	public void setLastLoginType(String lastLoginType) {
		this.lastLoginType = lastLoginType;
	}

	public int getNotifyConfig() {
		return notifyConfig;
	}

	public void setNotifyConfig(int notifyConfig) {
		this.notifyConfig = notifyConfig;
	}

	
	public long getFamilyId() {
		return familyId;
	}

	public void setFamilyId(long familyId) {
		this.familyId = familyId;
	}
	
	
	public int getLastActivetime() {
		return lastActivetime;
	}

	public void setLastActivetime(int lastActivetime) {
		this.lastActivetime = lastActivetime;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	/**
	 * 获取性别
	 * @return
	 */
	public String getSex4Display(){
		
	   if(gender==USER_SEX.MAN.ordinal()){
			return "m";
		}else if(gender==USER_SEX.WOMAN.ordinal()){
			return "f";
		}else{
			return null;
		}
	}

}
