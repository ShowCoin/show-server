package one.show.user.domain;

import java.io.Serializable;

/**
 * 
 * @author kevin
 *
 */
public class Robot implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3065542199287827554L;

	private long uid;
	
	private long popularNo;
	
	private String nickName;
	
	private String portrait;
	
	private String description;
	
	private int gender;
	
	private int createTime;

	public long getUid() {
		return uid;
	}

	public void setUid(long uid) {
		this.uid = uid;
	}

	
	public long getPopularNo() {
		return popularNo;
	}

	public void setPopularNo(long popularNo) {
		this.popularNo = popularNo;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getPortrait() {
		return portrait;
	}

	public void setPortrait(String portrait) {
		this.portrait = portrait;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public int getCreateTime() {
		return createTime;
	}

	public void setCreateTime(int createTime) {
		this.createTime = createTime;
	}
	
	
	
	
	

}
