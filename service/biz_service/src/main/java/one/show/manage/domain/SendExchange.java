package one.show.manage.domain;

import java.io.Serializable;

/**
 * 
 * @author hank
 *
 */
public class SendExchange implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6300672503378845496L;
	
	private int id;
	
	private int sendType;
	
	private long uid;
	
	private int vipType;
	
	private int createAt;

	private String sendBy;
	
	private double goldNum;
	
	private String reason;
	
	
	
	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public double getGoldNum() {
		return goldNum;
	}

	public void setGoldNum(double goldNum) {
		this.goldNum = goldNum;
	}

	public String getSendBy() {
		return sendBy;
	}

	public void setSendBy(String sendBy) {
		this.sendBy = sendBy;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSendType() {
		return sendType;
	}

	public void setSendType(int sendType) {
		this.sendType = sendType;
	}

	
	public long getUid() {
		return uid;
	}

	public void setUid(long uid) {
		this.uid = uid;
	}

	public int getVipType() {
		return vipType;
	}

	public void setVipType(int vipType) {
		this.vipType = vipType;
	}

	public int getCreateAt() {
		return createAt;
	}

	public void setCreateAt(int createAt) {
		this.createAt = createAt;
	}
	
	
}
