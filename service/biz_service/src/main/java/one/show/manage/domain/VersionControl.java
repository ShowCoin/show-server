package one.show.manage.domain;

import java.io.Serializable;

public class VersionControl implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7384389218395095172L;
	
	/**
	 * 主键id
	 */
	private long id;
	/**
	 * 强制更新
	 */
	private String coercionVersion;
	/**
	 * 建议更新
	 */
	private String adviceVersion;
	/**
	 * 下载地址
	 */
	private String downloadUrl;
	
	/**
	 * ios还是android
	 */
	private int agentType;
	
	/**
	 * title
	 */
	private String title;
	
	/**
	 * msg
	 */
	private String msg;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCoercionVersion() {
		return coercionVersion;
	}
	public void setCoercionVersion(String coercionVersion) {
		this.coercionVersion = coercionVersion;
	}
	public String getAdviceVersion() {
		return adviceVersion;
	}
	public void setAdviceVersion(String adviceVersion) {
		this.adviceVersion = adviceVersion;
	}
	public String getDownloadUrl() {
		return downloadUrl;
	}
	public void setDownloadUrl(String downloadUrl) {
		this.downloadUrl = downloadUrl;
	}
	public int getAgentType() {
		return agentType;
	}
	public void setAgentType(int agentType) {
		this.agentType = agentType;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}
