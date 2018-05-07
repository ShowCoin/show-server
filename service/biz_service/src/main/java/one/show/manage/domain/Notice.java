package one.show.manage.domain;

/**
 * @author Haliaeetus leucocephalus
 *
 * 
 */

import java.io.Serializable;

public class Notice implements Serializable {

	/** 序列化id */
	private static final long serialVersionUID = 1L;
	/***/
	private int id;
	/** 向聊天室推送内容 */
	private String content;
	/***/
	private int updateTime;
	/***/
	private int createTime;
	/** 推送间隔 ，单位分钟 */
	private int interval;
	
	/***/
	private int startTime;
	/***/
	private int endTime;
	
	

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(int updateTime) {
		this.updateTime = updateTime;
	}

	public int getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(int createTime) {
		this.createTime = createTime;
	}

	public int getInterval() {
		return this.interval;
	}

	public void setInterval(int interval) {
		this.interval = interval;
	}

	public int getStartTime() {
		return startTime;
	}

	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}

	public int getEndTime() {
		return endTime;
	}

	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}
	
	
}
