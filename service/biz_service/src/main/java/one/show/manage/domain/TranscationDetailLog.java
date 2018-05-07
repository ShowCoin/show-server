package one.show.manage.domain;

import java.io.Serializable;

public class TranscationDetailLog implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7249118041796459479L;
	
	private int id;
	
	private String uid;
	
	private String vid;
	
	private String tid;
	
	private int time;
	
	private int amount;
	
	private String detail;
	
	private int giftnum;
	
	private String giftid;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getVid() {
		return vid;
	}

	public void setVid(String vid) {
		this.vid = vid;
	}

	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public int getGiftnum() {
		return giftnum;
	}

	public void setGiftnum(int giftnum) {
		this.giftnum = giftnum;
	}

	public String getGiftid() {
		return giftid;
	}

	public void setGiftid(String giftid) {
		this.giftid = giftid;
	}
	
	

}
