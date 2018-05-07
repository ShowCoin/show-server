package one.show.user.domain;

import java.io.Serializable;


/**
 * 用户家族关系
 * @author hank
 * @date Fri Aug 05 15:16:00 CST 2016
 *
 */
public class FamilyMember implements Serializable{

	/**序列化id*/
	private static final long serialVersionUID = 1L;
	/**家族id*/
	private long familyId;
	/**主播id*/
	private long userId;
	/**角色 0家族长  1普通成员*/
	private int role;
	/**加入时间*/
	private int joinTime;

	public long getFamilyId(){
		return this.familyId;
	}
	public void setFamilyId(long familyId){
		this.familyId=familyId;
	}
	public long getUserId(){
		return this.userId;
	}
	public void setUserId(long userId){
		this.userId=userId;
	}
	public int getRole(){
		return this.role;
	}
	public void setRole(int role){
		this.role=role;
	}
	public int getJoinTime(){
		return this.joinTime;
	}
	public void setJoinTime(int joinTime){
		this.joinTime=joinTime;
	}
}
