/**
 * 
 */
package one.show.stat.domain;

/**
 * @author Haliaeetus leucocephalus 2018年1月6日 下午5:12:55
 * 
 */
public class UserStat {

	private long uid;
	private int fans = 0;
	private int follow = 0;
	private int login = 0;
	private int videos = 0;
	private int viewed = 0;
	private double receive = 0;
	private double spend = 0;
	private double receiveExp = 0;
	private double spendExp = 0;

	

	public long getUid() {
		return uid;
	}


	public void setUid(long uid) {
		this.uid = uid;
	}


	public int getFans() {
		return fans;
	}


	public void setFans(int fans) {
		this.fans = fans;
	}


	public int getFollow() {
		return follow;
	}


	public void setFollow(int follow) {
		this.follow = follow;
	}


	public int getLogin() {
		return login;
	}


	public void setLogin(int login) {
		this.login = login;
	}


	public int getVideos() {
		return videos;
	}


	public void setVideos(int videos) {
		this.videos = videos;
	}


	public int getViewed() {
		return viewed;
	}


	public void setViewed(int viewed) {
		this.viewed = viewed;
	}


	public double getReceive() {
		return receive;
	}


	public void setReceive(double receive) {
		this.receive = receive;
	}


	public double getSpend() {
		return spend;
	}


	public void setSpend(double spend) {
		this.spend = spend;
	}


	public double getReceiveExp() {
		return receiveExp;
	}


	public void setReceiveExp(double receiveExp) {
		this.receiveExp = receiveExp;
	}


	public double getSpendExp() {
		return spendExp;
	}


	public void setSpendExp(double spendExp) {
		this.spendExp = spendExp;
	}


}