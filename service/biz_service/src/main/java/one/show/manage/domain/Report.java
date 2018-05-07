package one.show.manage.domain;

import java.io.Serializable;

/**
 * 举报表
 * 
 * 
 */
public class Report implements Serializable {
	private static final long serialVersionUID = -8756245085590374032L;
	public long id;
	public long uid;
	public String contact;
	public String content;
	public int createTime;

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

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getCreateTime() {
		return createTime;
	}

	public void setCreateTime(int createTime) {
		this.createTime = createTime;
	}

	
}