/**
 * 
 */
package one.show.relation.domain;

/**
 * @author kevin  
 * 我关注的人的feed
 */
public class Feed {

	private long id;
	private long uid;

	// follow id
	private long fid;
	private int type;
	private String point;
	private int time;
	private int vodStatus;

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

	public long getFid() {
		return fid;
	}

	public void setFid(long fid) {
		this.fid = fid;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getPoint() {
		return point;
	}

	public void setPoint(String point) {
		this.point = point;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public int getVodStatus() {
		return vodStatus;
	}

	public void setVodStatus(int vodStatus) {
		this.vodStatus = vodStatus;
	}

}
