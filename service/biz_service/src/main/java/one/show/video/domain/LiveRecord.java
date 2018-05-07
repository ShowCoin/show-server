package one.show.video.domain;

import java.io.Serializable;

public class LiveRecord implements Serializable{

	/**序列化id*/
	private static final long serialVersionUID = 1L;
	/***/
	private long id;
	/**cdn   0 网宿*/
	private int cdnType;
	/**状态*/
	private int status;
	/**直播id*/
	private long liveid;
	/**user id*/
	private long uid;
	/**空间名*/
	private String bucket;
	/**视频格式 0 flv  1 mp3*/
	private int format;
	/**录制参数,包含输出格式、码率等信息。*/
	private String ops;
	/**输出文件名列表*/
	private String keys;
	/**录播地址*/
	private String urls;
	
	private double duration;
	/**创建时间*/
	private int createTime;
	
	private int updateTime;

	public long getId(){
		return this.id;
	}
	public void setId(long id){
		this.id=id;
	}
	public int getCdnType(){
		return this.cdnType;
	}
	public void setCdnType(int cdnType){
		this.cdnType=cdnType;
	}
	public int getStatus(){
		return this.status;
	}
	public void setStatus(int status){
		this.status=status;
	}
	public long getLiveid(){
		return this.liveid;
	}
	public void setLiveid(long liveid){
		this.liveid=liveid;
	}
	public long getUid(){
		return this.uid;
	}
	public void setUid(long uid){
		this.uid=uid;
	}
	public String getBucket(){
		return this.bucket;
	}
	public void setBucket(String bucket){
		this.bucket=bucket;
	}
	public int getFormat(){
		return this.format;
	}
	public void setFormat(int format){
		this.format=format;
	}
	public String getOps(){
		return this.ops;
	}
	public void setOps(String ops){
		this.ops=ops;
	}
	public String getKeys(){
		return this.keys;
	}
	public void setKeys(String keys){
		this.keys=keys;
	}
	public String getUrls(){
		return this.urls;
	}
	public void setUrls(String urls){
		this.urls=urls;
	}
	public int getCreateTime(){
		return this.createTime;
	}
	public void setCreateTime(int createTime){
		this.createTime=createTime;
	}
	public int getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(int updateTime) {
		this.updateTime = updateTime;
	}
	public double getDuration() {
		return duration;
	}
	public void setDuration(double duration) {
		this.duration = duration;
	}
}
