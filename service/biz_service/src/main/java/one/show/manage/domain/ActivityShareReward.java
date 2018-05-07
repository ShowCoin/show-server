package one.show.manage.domain;

import java.io.Serializable;


/**
 * t_activity_share_reward
 * @author hank
 * @date Tue Aug 09 19:00:34 CST 2016
 *
 */
public class ActivityShareReward implements Serializable{

	/**序列化id*/
	private static final long serialVersionUID = 1L;
	/***/
	private int shareDate;
	/***/
	private int reward1;
	/***/
	private int reward2;
	/***/
	private int reward3;
	/***/
	private int createTime;
	/***/
	private int updateTime;

	public int getShareDate(){
		return this.shareDate;
	}
	public void setShareDate(int shareDate){
		this.shareDate=shareDate;
	}
	public int getReward1(){
		return this.reward1;
	}
	public void setReward1(int reward1){
		this.reward1=reward1;
	}
	public int getReward2(){
		return this.reward2;
	}
	public void setReward2(int reward2){
		this.reward2=reward2;
	}
	public int getReward3(){
		return this.reward3;
	}
	public void setReward3(int reward3){
		this.reward3=reward3;
	}
	public int getCreateTime(){
		return this.createTime;
	}
	public void setCreateTime(int createTime){
		this.createTime=createTime;
	}
	public int getUpdateTime(){
		return this.updateTime;
	}
	public void setUpdateTime(int updateTime){
		this.updateTime=updateTime;
	}
}
