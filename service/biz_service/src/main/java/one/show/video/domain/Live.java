package one.show.video.domain;

import java.io.Serializable;

import org.apache.ibatis.annotations.Result;

/**
 * 直播
 * 
 * @author Haliaeetus leucocephalus
 * @date Thu May 19 12:18:00 CST 2016
 * 
 */
/**
 * @author Haliaeetus leucocephalus
 *
 */
public class Live implements Serializable {

	/** 序列化id */
	private static final long serialVersionUID = 1L;
	/** 直播id */
	private long liveId;
	/** 主播id */
	private long uid;
	
	private String title;
	
	private String topic;
	/** 直播开始时间 */
	private int startTime;
	/** 直播结束时间 */
	private int endTime;
	/** 直播状态 0 结束 1 直播中 2 准备开播放 */
	private int status;
	/** 直播截图 */
	private String snapshot;
	/** 直播创建时间 */
	private int createTime;
	/** 直播流状态: 0等待，1开始直播，2断流，3断流恢复（续播），4结束 */
	private int streamStatus;
	/** 直播流状态对应时间 */
	private int streamTime;
	/** 直播流名 */
	private String streamName;
	/** 客户ip */
	private String ip;
	/** 推流地址 */
	private String rtmp;
	/** CDN类型 */
	private int cdnType;

	/** 帧率 */
	private int frame;
	/** 码率 */
	private int bitrate;
	/** 宽 */
	private int width;
	/** 高 */
	private int height;
	/** 设备id */
	private String did;
	/** 纬度 */
	private double latitude;
	/** 经度 */
	private double longitude;
	/***/
	private String cityName;
	
	private int viewed;

	private int reason;
	
	private int city;
	
	private int province;
	
	private int robotNumber;
	
	private String recordUrl;
	
	private int vodStatus;
	
	private int platform;
	
	private int squarePos;

	public long getLiveId() {
		return liveId;
	}

	public void setLiveId(long liveId) {
		this.liveId = liveId;
	}

	public long getUid() {
		return this.uid;
	}

	public void setUid(long uid) {
		this.uid = uid;
	}
	
	

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public int getStartTime() {
		return this.startTime;
	}

	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}


	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getSnapshot() {
		return this.snapshot;
	}

	public void setSnapshot(String snapshot) {
		this.snapshot = snapshot;
	}

	public int getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(int createTime) {
		this.createTime = createTime;
	}

	public int getStreamStatus() {
		return this.streamStatus;
	}

	public void setStreamStatus(int streamStatus) {
		this.streamStatus = streamStatus;
	}

	public int getStreamTime() {
		return this.streamTime;
	}

	public void setStreamTime(int streamTime) {
		this.streamTime = streamTime;
	}

	public String getStreamName() {
		return this.streamName;
	}

	public void setStreamName(String streamName) {
		this.streamName = streamName;
	}

	public String getIp() {
		return this.ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getRtmp() {
		return this.rtmp;
	}

	public void setRtmp(String rtmp) {
		this.rtmp = rtmp;
	}

	public int getCdnType() {
		return this.cdnType;
	}

	public void setCdnType(int cdnType) {
		this.cdnType = cdnType;
	}


	public int getFrame() {
		return this.frame;
	}

	public void setFrame(int frame) {
		this.frame = frame;
	}

	public int getBitrate() {
		return this.bitrate;
	}

	public void setBitrate(int bitrate) {
		this.bitrate = bitrate;
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

	public String getDid() {
		return this.did;
	}

	public void setDid(String did) {
		this.did = did;
	}


	public double getLatitude() {
		return this.latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return this.longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public int getCity() {
		return city;
	}

	public void setCity(int city) {
		this.city = city;
	}

	public int getProvince() {
		return province;
	}

	public void setProvince(int province) {
		this.province = province;
	}

	public int getViewed() {
		return viewed;
	}

	public void setViewed(int viewed) {
		this.viewed = viewed;
	}

	public int getReason() {
		return reason;
	}

	public void setReason(int reason) {
		this.reason = reason;
	}

	public int getEndTime() {
		return endTime;
	}

	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}

	public int getRobotNumber() {
		return robotNumber;
	}

	public void setRobotNumber(int robotNumber) {
		this.robotNumber = robotNumber;
	}

	public String getRecordUrl() {
		return recordUrl;
	}

	public void setRecordUrl(String recordUrl) {
		this.recordUrl = recordUrl;
	}

	public int getVodStatus() {
		return vodStatus;
	}

	public void setVodStatus(int vodStatus) {
		this.vodStatus = vodStatus;
	}

	public int getPlatform() {
		return platform;
	}

	public void setPlatform(int platform) {
		this.platform = platform;
	}

	public int getSquarePos() {
		return squarePos;
	}

	public void setSquarePos(int squarePos) {
		this.squarePos = squarePos;
	}
	
	
	
}