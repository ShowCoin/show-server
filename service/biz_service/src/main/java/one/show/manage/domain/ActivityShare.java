package one.show.manage.domain;

import java.io.Serializable;


/**
 * t_activity_share
 * @author hank
 * @date Mon Aug 08 21:19:49 CST 2016
 *
 */
public class ActivityShare implements Serializable{

	/**序列化id*/
	private static final long serialVersionUID = 1L;
	/**设备id*/
	private String did;
	/**分享次数*/
	private int shareTimes;
	/**分享奖励*/
	private String shareReward;
	/**最近分享*/
	private int lastShareTime;
	public String getDid() {
		return did;
	}
	public void setDid(String did) {
		this.did = did;
	}
	public int getShareTimes(){
		return this.shareTimes;
	}
	public void setShareTimes(int shareTimes){
		this.shareTimes=shareTimes;
	}
	public String getShareReward(){
		return this.shareReward;
	}
	public void setShareReward(String shareReward){
		this.shareReward=shareReward;
	}
	public int getLastShareTime(){
		return this.lastShareTime;
	}
	public void setLastShareTime(int lastShareTime){
		this.lastShareTime=lastShareTime;
	}
}
