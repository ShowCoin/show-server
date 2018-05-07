/**
 * 
 */
package one.show.relation.domain;

/**
 * @author kevin 
 * 我关注的
 */
public class Follow {

	private Long uid;

	// follow id
	private Long fid;
	private Integer time;
	
	public Follow(){
		
	}
	
	public Follow(Long uid, Long fid){
		this.uid = uid;
		this.fid = fid;
		this.time = (int)(System.currentTimeMillis()/1000);
	}

	public Follow(Long uid, Long fid, Integer time) {
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
