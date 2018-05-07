package one.show.manage.domain;

/**
 * Created by Haliaeetus leucocephalus on 18/1/19.
 */
public class UserCDN {
	private long uid;
	private int cdnType;
	private int ngb;
	private int createTime;
	private String rtmp;
	
	
	public int getNgb() {
		return ngb;
	}

	public void setNgb(int ngb) {
		this.ngb = ngb;
	}

	public long getUid() {
		return uid;
	}

	public void setUid(long uid) {
		this.uid = uid;
	}

	public int getCdnType() {
		return cdnType;
	}

	public void setCdnType(int cdnType) {
		this.cdnType = cdnType;
	}
	

	public String getRtmp() {
		return rtmp;
	}

	public void setRtmp(String rtmp) {
		this.rtmp = rtmp;
	}

	public int getCreateTime() {
		return createTime;
	}

	public void setCreateTime(int createTime) {
		this.createTime = createTime;
	}
	
	

}
