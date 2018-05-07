package one.show.pay.domain;

import java.io.Serializable;

public class GiftRank  implements Serializable{

	private static final long serialVersionUID = 1L;

	private long uid;
	
	private long fromUid;
	
	private int total;
	
	private int time;

	public long getUid() {
		return uid;
	}

	public void setUid(long uid) {
		this.uid = uid;
	}

	public long getFromUid() {
		return fromUid;
	}

	public void setFromUid(long fromUid) {
		this.fromUid = fromUid;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "GiftRank [uid=" + uid + ", fromUid=" + fromUid + ", total="
				+ total + ", time=" + time + "]";
	}
	
}
