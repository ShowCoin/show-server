package one.show.struc;

import java.io.Serializable;

public class TopCommentParam implements Serializable{
	
	private static final long serialVersionUID = -3611111777522665358L;
	private String reply_id;
	private String comment_id;
	private String reply_userid;
	private String user_id;
	private String reply_nickname;
	private String user_nickname;
	private String reply_user_avatar;
	private String user_avatar;
	private String reply_content;
	private String comment_content;
	private String reply_time;
	private String comment_time;
	private String is_vip;
	private String comment_from_device;
	
	
	public String getReply_id() {
		return reply_id;
	}
	public String getComment_id() {
		return comment_id;
	}
	public void setComment_id(String comment_id) {
		this.comment_id = comment_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_nickname() {
		return user_nickname;
	}
	public void setUser_nickname(String user_nickname) {
		this.user_nickname = user_nickname;
	}
	public String getUser_avatar() {
		return user_avatar;
	}
	public void setUser_avatar(String user_avatar) {
		this.user_avatar = user_avatar;
	}
	public String getComment_content() {
		return comment_content;
	}
	public void setComment_content(String comment_content) {
		this.comment_content = comment_content;
	}
	public String getComment_time() {
		return comment_time;
	}
	public void setComment_time(String comment_time) {
		this.comment_time = comment_time;
	}
	public void setReply_id(String reply_id) {
		this.reply_id = reply_id;
	}
	public String getReply_userid() {
		return reply_userid;
	}
	public void setReply_userid(String reply_userid) {
		this.reply_userid = reply_userid;
	}
	public String getReply_nickname() {
		return reply_nickname;
	}
	public void setReply_nickname(String reply_nickname) {
		this.reply_nickname = reply_nickname;
	}
	public String getReply_user_avatar() {
		return reply_user_avatar;
	}
	public void setReply_user_avatar(String reply_user_avatar) {
		this.reply_user_avatar = reply_user_avatar;
	}
	public String getReply_content() {
		return reply_content;
	}
	public void setReply_content(String reply_content) {
		this.reply_content = reply_content;
	}
	public String getReply_time() {
		return reply_time;
	}
	public void setReply_time(String reply_time) {
		this.reply_time = reply_time;
	}
	public String getIs_vip() {
		return is_vip;
	}
	public void setIs_vip(String is_vip) {
		this.is_vip = is_vip;
	}
	public String getComment_from_device() {
		return comment_from_device;
	}
	public void setComment_from_device(String comment_from_device) {
		this.comment_from_device = comment_from_device;
	}
	
}