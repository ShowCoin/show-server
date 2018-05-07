/**
 * 
 */
package one.show.user.domain;

import java.io.Serializable;

import one.show.common.Constant;

/**
 * @author kevin 
 * 第三方登陆信息，按tid分表
 * 
 */
public class ThirdData implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5710691859227999911L;
	private String tid;
	private String type;
	private String token;
	private long uid;
	private int createTime;
	
	public int getPublicStatus() {
		return publicStatus;
	}

	public void setPublicStatus(int publicStatus) {
		this.publicStatus = publicStatus;
	}

	private int publicStatus= Constant.THIRD_BIND_PUBLIC_STATUS.YES.ordinal();


	public ThirdData() {
	}

	public ThirdData(String tid, String type, String token, long uid) {
		this.tid = tid;
		this.type = type;
		this.token = token;
		this.uid = uid;
		this.createTime = (int)(System.currentTimeMillis()/1000);
	}

	public long getUid() {
		return uid;
	}

	public void setUid(long uid) {
		this.uid = uid;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public int getCreateTime() {
		return createTime;
	}

	public void setCreateTime(int createTime) {
		this.createTime = createTime;
	}
}
