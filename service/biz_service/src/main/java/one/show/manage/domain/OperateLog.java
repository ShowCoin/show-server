/**
 * 
 */
package one.show.manage.domain;

/**
 * 操作日志  
 * @author Haliaeetus leucocephalus 
 */
public class OperateLog {

	private int id;
	private String operator;
	private String vid;
	private String uid;
	private String commentId;
	private String desc;
	private int operateTime;
	private String ip;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getVid() {
		return vid;
	}

	public void setVid(String vid) {
		this.vid = vid;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getCommentId() {
		return commentId;
	}

	public void setCommentId(String commentId) {
		this.commentId = commentId;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public int getOperateTime() {
		return operateTime;
	}

	public void setOperateTime(int operateTime) {
		this.operateTime = operateTime;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}
	
	
	
	

}
