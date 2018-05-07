package one.show.struc;

import java.io.Serializable;

public class DefenderParam implements Serializable{
	
	private static final long serialVersionUID = -8479010333937475012L;
	private String uid;
	private String nickname;
	private String s_spend;
	private String avatar;
	private String is_vip;
	private String record;
	private int is_foucs;
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getS_spend() {
		return s_spend;
	}
	public void setS_spend(String s_spend) {
		this.s_spend = s_spend;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	
	public String getIs_vip() {
		return is_vip;
	}
	public void setIs_vip(String is_vip) {
		this.is_vip = is_vip;
	}
	public int getIs_foucs() {
		return is_foucs;
	}
	public void setIs_foucs(int is_foucs) {
		this.is_foucs = is_foucs;
	}
	public String getRecord() {
		return record;
	}
	public void setRecord(String record) {
		this.record = record;
	}
	
}
