package one.show.user.domain;

import java.io.Serializable;

public class UserDevice implements Serializable{

	/**序列化id*/
	private static final long serialVersionUID = 1L;
	/**用户id*/
	private long uid;
	/**设备id*/
	private String deviceUuid;
	/**创建时间*/
	private int createTime;

	public long getUid(){
		return this.uid;
	}
	public void setUid(long uid){
		this.uid=uid;
	}
	public String getDeviceUuid(){
		return this.deviceUuid;
	}
	public void setDeviceUuid(String deviceUuid){
		this.deviceUuid=deviceUuid;
	}
	public int getCreateTime(){
		return this.createTime;
	}
	public void setCreateTime(int createTime){
		this.createTime=createTime;
	}
}
