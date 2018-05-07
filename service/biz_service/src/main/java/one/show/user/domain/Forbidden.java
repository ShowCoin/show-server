package one.show.user.domain;

import java.io.Serializable;

/**
 * 
 * @author hank
 * @version 2015/8/18
 * 
 *	用户权限表
 */
public class Forbidden implements Serializable{


	private static final long serialVersionUID = -5205635188749179048L;
	
	private long id;

	//用户id
	private long uid;
	
	//过期时间
	private int expireTime;
	
	//用户权限标识
	private int action;
	
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

	public long getUid() {
		return uid;
	}

	public void setUid(long uid) {
		this.uid = uid;
	}

	public int getExpireTime() {
		return expireTime;
	}

	public void setExpireTime(int expireTime) {
		this.expireTime = expireTime;
	}

	public int getAction() {
		return action;
	}

	public void setAction(int action) {
		this.action = action;
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