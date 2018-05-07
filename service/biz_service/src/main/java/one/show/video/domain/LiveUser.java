package one.show.video.domain;

import java.io.Serializable;

import one.show.common.Constant.STATUS;

/**
 * 直播
 * @author Haliaeetus leucocephalus
 * @date Thu May 19 13:59:18 CST 2016
 *
 */
public class LiveUser implements Serializable{

	/**序列化id*/
	private static final long serialVersionUID = 1L;
	/**直播id*/
	private long liveId;
	/**主播id*/
	private long uid;
	/**直播截图*/
	private String snapshot;
	/**直播创建时间*/
	private int createTime;

	private String streamName;
	
	private int cdnType;
	private int viewed;
	
	private int status = STATUS.ENABLED.ordinal();
	
	private int vodStatus = STATUS.DISABLE.ordinal();
	
	public long getLiveId() {
		return liveId;
	}
	public void setLiveId(long liveId) {
		this.liveId = liveId;
	}
	public long getUid(){
		return this.uid;
	}
	public void setUid(long uid){
		this.uid=uid;
	}
	public String getSnapshot(){
		return this.snapshot;
	}
	public void setSnapshot(String snapshot){
		this.snapshot=snapshot;
	}
	public int getCreateTime(){
		return this.createTime;
	}
	public void setCreateTime(int createTime){
		this.createTime=createTime;
	}
	public int getViewed() {
		return viewed;
	}
	public void setViewed(int viewed) {
		this.viewed = viewed;
	}
	public String getStreamName() {
		return streamName;
	}
	public void setStreamName(String streamName) {
		this.streamName = streamName;
	}
	public int getCdnType() {
		return cdnType;
	}
	public void setCdnType(int cdnType) {
		this.cdnType = cdnType;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getVodStatus() {
		return vodStatus;
	}
	public void setVodStatus(int vodStatus) {
		this.vodStatus = vodStatus;
	}
	
	
	
	
}