package one.show.struc;

import java.io.Serializable;
/**
 * 视频信息类
 * @author Haliaeetus leucocephalus
 *
 */
public class VideoParams implements Serializable{
	private static final long serialVersionUID = 8160679509804495471L;
	private long vid;
	private int createdAt;
	private int active;
	private int activeAt;
	private int pushed;
	private int pushedAt;
	private int recommended;
	private int recommendedAt;
	private String recommendedBy;
	private String activeBy;
	private String clientVersion;
	private int catalog;
	private String clientAgent;
	private String desc;
	private int direction;
	private String effect;
	private double latitude;
	private double longitude;
	private int isPostSina;
	private double length;
	private int m3u8;
	private int uploadStartTime;
	private int uploadStopTime;
	private int processStartTime;
	private int processStopTime;
	private int publishStartTime;
	private int publishStopLatitude;
	private int publishStopLongitude;
	private int publishStopTime;
	private int recordStartLatitude;
	private int recordStartLongitude;
	private int recordStartTime;
	private int recordStopLatitude;
	private int recordStopLongitude;
	private int recordStopTime;
	private int transcoded;
	private long user;
	private String uuid;
	private String audioPath;
	private String filePath;
	private String img3in1;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	private String city;
	private int needAudio;
	private int showGeo;
	private String type;
	private int album;
	private int weipaiVideo;
	private int posted;
	private int customCoverNum;
	private String defaultImg;
	private int imgLastModified;
	private int deleted;
	public long getVid() {
		return vid;
	}
	public void setVid(long vid) {
		this.vid = vid;
	}
	public int getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(int createdAt) {
		this.createdAt = createdAt;
	}
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
	public int getActiveAt() {
		return activeAt;
	}
	public void setActiveAt(int activeAt) {
		this.activeAt = activeAt;
	}
	public int getPushed() {
		return pushed;
	}
	public void setPushed(int pushed) {
		this.pushed = pushed;
	}
	public int getPushedAt() {
		return pushedAt;
	}
	public void setPushedAt(int pushedAt) {
		this.pushedAt = pushedAt;
	}
	public int getRecommended() {
		return recommended;
	}
	public void setRecommended(int recommended) {
		this.recommended = recommended;
	}
	public int getRecommendedAt() {
		return recommendedAt;
	}
	public void setRecommendedAt(int recommendedAt) {
		this.recommendedAt = recommendedAt;
	}
	public String getRecommendedBy() {
		return recommendedBy;
	}
	public void setRecommendedBy(String recommendedBy) {
		this.recommendedBy = recommendedBy;
	}
	public String getActiveBy() {
		return activeBy;
	}
	public void setActiveBy(String activeBy) {
		this.activeBy = activeBy;
	}
	public String getClientVersion() {
		return clientVersion;
	}
	public void setClientVersion(String clientVersion) {
		this.clientVersion = clientVersion;
	}
	public int getCatalog() {
		return catalog;
	}
	public void setCatalog(int catalog) {
		this.catalog = catalog;
	}
	public String getClientAgent() {
		return clientAgent;
	}
	public void setClientAgent(String clientAgent) {
		this.clientAgent = clientAgent;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public int getDirection() {
		return direction;
	}
	public void setDirection(int direction) {
		this.direction = direction;
	}
	public String getEffect() {
		return effect;
	}
	public void setEffect(String effect) {
		this.effect = effect;
	}
	public int getIsPostSina() {
		return isPostSina;
	}
	public void setIsPostSina(int isPostSina) {
		this.isPostSina = isPostSina;
	}
	public int getM3u8() {
		return m3u8;
	}
	public void setM3u8(int m3u8) {
		this.m3u8 = m3u8;
	}
	public int getUploadStartTime() {
		return uploadStartTime;
	}
	public void setUploadStartTime(int uploadStartTime) {
		this.uploadStartTime = uploadStartTime;
	}
	public int getUploadStopTime() {
		return uploadStopTime;
	}
	public void setUploadStopTime(int uploadStopTime) {
		this.uploadStopTime = uploadStopTime;
	}
	public int getProcessStartTime() {
		return processStartTime;
	}
	public void setProcessStartTime(int processStartTime) {
		this.processStartTime = processStartTime;
	}
	public int getProcessStopTime() {
		return processStopTime;
	}
	public void setProcessStopTime(int processStopTime) {
		this.processStopTime = processStopTime;
	}
	public int getPublishStartTime() {
		return publishStartTime;
	}
	public void setPublishStartTime(int publishStartTime) {
		this.publishStartTime = publishStartTime;
	}
	public int getPublishStopLatitude() {
		return publishStopLatitude;
	}
	public void setPublishStopLatitude(int publishStopLatitude) {
		this.publishStopLatitude = publishStopLatitude;
	}
	public int getPublishStopLongitude() {
		return publishStopLongitude;
	}
	public void setPublishStopLongitude(int publishStopLongitude) {
		this.publishStopLongitude = publishStopLongitude;
	}
	public int getPublishStopTime() {
		return publishStopTime;
	}
	public void setPublishStopTime(int publishStopTime) {
		this.publishStopTime = publishStopTime;
	}
	public int getRecordStartLatitude() {
		return recordStartLatitude;
	}
	public void setRecordStartLatitude(int recordStartLatitude) {
		this.recordStartLatitude = recordStartLatitude;
	}
	public int getRecordStartLongitude() {
		return recordStartLongitude;
	}
	public void setRecordStartLongitude(int recordStartLongitude) {
		this.recordStartLongitude = recordStartLongitude;
	}
	public int getRecordStartTime() {
		return recordStartTime;
	}
	public void setRecordStartTime(int recordStartTime) {
		this.recordStartTime = recordStartTime;
	}
	public int getRecordStopLatitude() {
		return recordStopLatitude;
	}
	public void setRecordStopLatitude(int recordStopLatitude) {
		this.recordStopLatitude = recordStopLatitude;
	}
	public int getRecordStopLongitude() {
		return recordStopLongitude;
	}
	public void setRecordStopLongitude(int recordStopLongitude) {
		this.recordStopLongitude = recordStopLongitude;
	}
	public int getRecordStopTime() {
		return recordStopTime;
	}
	public void setRecordStopTime(int recordStopTime) {
		this.recordStopTime = recordStopTime;
	}
	public int getTranscoded() {
		return transcoded;
	}
	public void setTranscoded(int transcoded) {
		this.transcoded = transcoded;
	}
	
	public long getUser() {
		return user;
	}

	public void setUser(long user) {
		this.user = user;
	}

	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getAudioPath() {
		return audioPath;
	}
	public void setAudioPath(String audioPath) {
		this.audioPath = audioPath;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getImg3in1() {
		return img3in1;
	}
	public void setImg3in1(String img3in1) {
		this.img3in1 = img3in1;
	}
	public int getNeedAudio() {
		return needAudio;
	}
	public void setNeedAudio(int needAudio) {
		this.needAudio = needAudio;
	}
	public int getShowGeo() {
		return showGeo;
	}
	public void setShowGeo(int showGeo) {
		this.showGeo = showGeo;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getAlbum() {
		return album;
	}
	public void setAlbum(int album) {
		this.album = album;
	}
	public int getWeipaiVideo() {
		return weipaiVideo;
	}
	public void setWeipaiVideo(int weipaiVideo) {
		this.weipaiVideo = weipaiVideo;
	}
	public int getPosted() {
		return posted;
	}
	public void setPosted(int posted) {
		this.posted = posted;
	}
	public int getCustomCoverNum() {
		return customCoverNum;
	}
	public void setCustomCoverNum(int customCoverNum) {
		this.customCoverNum = customCoverNum;
	}
	public String getDefaultImg() {
		return defaultImg;
	}
	public void setDefaultImg(String defaultImg) {
		this.defaultImg = defaultImg;
	}
	public int getImgLastModified() {
		return imgLastModified;
	}
	public void setImgLastModified(int imgLastModified) {
		this.imgLastModified = imgLastModified;
	}
	public int getDeleted() {
		return deleted;
	}
	public void setDeleted(int deleted) {
		this.deleted = deleted;
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
	public double getLength() {
		return length;
	}
	public void setLength(double length) {
		this.length = length;
	}
}
