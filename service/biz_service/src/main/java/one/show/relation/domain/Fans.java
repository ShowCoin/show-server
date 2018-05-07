/**
 * 
 */
package one.show.relation.domain;

/**
 * @author kevin 
 * 我的粉丝
 */
public class Fans {

	private Long uid;

	// fans id
	private Long fid;
	private Integer time;
	
	public Fans(){
		
	}
	
	public Fans(Long uid, Long fid){
		this.uid = uid;
		this.fid = fid;
		this.time = (int)(System.currentTimeMillis()/1000);
	}

	public Fans(Long uid, Long fid, Integer time) {
		this.uid = uid;
		this.fid = fid;
		this.time = time;
	}

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public Long getFid() {
		return fid;
	}

	public void setFid(Long fid) {
		this.fid = fid;
	}

	public Integer getTime() {
		return time;
	}

	public void setTime(Integer time) {
		this.time = time;
	}

}
