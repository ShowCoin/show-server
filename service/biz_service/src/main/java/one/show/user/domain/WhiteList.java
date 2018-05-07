package one.show.user.domain;

import java.io.Serializable;

/**
 * 
 * @author kevin
 *
 */
public class WhiteList implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5645031447261071321L;
	
	private long uid;
	
	private int time;

	public long getUid() {
		return uid;
	}

	public void setUid(long uid) {
		this.uid = uid;
	}


	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}
	
	
	

}
