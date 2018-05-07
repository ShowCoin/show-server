package one.show.user.domain;

import java.io.Serializable;

/**
 * 
 * @author hank
 * @version 2015/8/18
 * 
 *	设备权限表
 */
public class DeviceForbidden implements Serializable{

	private static final long serialVersionUID = -1828348610045751225L;
	
	private long id;

	//用户id
	private String did;
	
	//过期时间
	private int expireTime;
	
	//操作人
	private String forbiddenby;	
	
	//操作时间
	private int createTime;	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDid() {
		return did;
	}

	public void setDid(String did) {
		this.did = did;
	}

	public int getExpireTime() {
		return expireTime;
	}

	public void setExpireTime(int expireTime) {
		this.expireTime = expireTime;
	}

	public String getForbiddenby() {
		return forbiddenby;
	}

	public void setForbiddenby(String forbiddenby) {
		this.forbiddenby = forbiddenby;
	}

	public int getCreateTime() {
		return createTime;
	}

	public void setCreateTime(int createTime) {
		this.createTime = createTime;
	}

	
}