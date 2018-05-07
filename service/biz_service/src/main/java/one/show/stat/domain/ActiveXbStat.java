
package one.show.stat.domain;

import java.io.Serializable;

/**
 * @author Haliaeetus leucocephalus 
 *
 * 
 */

public class ActiveXbStat implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2170538511877581740L;
	/***/
	private long id;
	/***/
	private long uid;
	/**收到礼物价值*/
	private double giftPrice;
	/**收到礼物次数*/
	private int giftCount;
	/**分享次数*/
	private int shareCount;
	/**最高在线人数*/
	private int onlineCount;
	/**时间，小时*/
	private int time;
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
	public double getGiftPrice() {
		return giftPrice;
	}
	public void setGiftPrice(double giftPrice) {
		this.giftPrice = giftPrice;
	}
	public int getGiftCount() {
		return giftCount;
	}
	public void setGiftCount(int giftCount) {
		this.giftCount = giftCount;
	}
	public int getShareCount() {
		return shareCount;
	}
	public void setShareCount(int shareCount) {
		this.shareCount = shareCount;
	}
	public int getOnlineCount() {
		return onlineCount;
	}
	public void setOnlineCount(int onlineCount) {
		this.onlineCount = onlineCount;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	
	

}


