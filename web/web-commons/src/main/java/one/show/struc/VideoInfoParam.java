package one.show.struc;

import java.io.Serializable;
import java.util.List;
import java.util.Random;

public class VideoInfoParam implements Serializable{
	

	private static final long serialVersionUID = -2521048786201918892L;
	private String video_play_url = "";
	private String like_state = "0";
	private String video_like_num = "0";
	private String share_count = "0";
	private String video_id = "";
	private String user_id = "";
	private String video_duration = "0";
	private String user_avatar = "";
	private String s_receive = "0";
	private String s_receive_value = "0";
	private String video_screenshots_v = "";
	private String created_at = "0";
	private String video_reply_num = "0";
	private String video_play_num = "0";
	private String video_capture_time = "0";
	private String video_capture_location = "未知";
	private String video_desc = "";
	private String video_screenshots = "";
	private String video_release_time = "0";
	private String nickname = "";
	private String is_vip = "0";
	private String video_capture_device = "";
	private String blog_id = "";
	private String current_rank = "";
	private List<DefenderParam> defender_list;
	private List<TopCommentParam> top_reply_list;
	private String color = "";
	private String follow_status = "0";
	private String my_send_total = "0";
	private int posted = 1;
	
	public VideoInfoParam() {
		Random ra = new Random(System.currentTimeMillis());
	    String [] strArr = new String[]{"f9f3ff","fcf7ed","f0f2f1","f4ece9","ebf3f7","f9efef","f7ebf2","e7f7f5","e8eef7","f9f9ef"};
		this.color = strArr[ra.nextInt(9)];
	}
	
	
	public int getPosted() {
		return posted;
	}



	public void setPosted(int posted) {
		this.posted = posted;
	}



	public String getFollow_status() {
		return follow_status;
	}

	public void setFollow_status(String follow_status) {
		this.follow_status = follow_status;
	}
	
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getIs_vip() {
		return is_vip;
	}
	public void setIs_vip(String is_vip) {
		this.is_vip = is_vip;
	}
	public String getVideo_play_url() {
		return video_play_url;
	}
	public void setVideo_play_url(String video_play_url) {
		this.video_play_url = video_play_url;
	}
	
	public String getVideo_capture_time() {
		return video_capture_time;
	}
	public void setVideo_capture_time(String video_capture_time) {
		this.video_capture_time = video_capture_time;
	}
	public String getVideo_release_time() {
		return video_release_time;
	}
	public void setVideo_release_time(String video_release_time) {
		this.video_release_time = video_release_time;
	}
	public String getUser_avatar() {
		return user_avatar;
	}
	public String getLike_state() {
		return like_state;
	}
	public void setLike_state(String like_state) {
		this.like_state = like_state;
	}
	public void setUser_avatar(String user_avatar) {
		this.user_avatar = user_avatar;
	}
	public String getS_receive() {
		return s_receive;
	}
	public void setS_receive(String s_receive) {
		this.s_receive = s_receive;
	}
	public String getVideo_screenshots_v() {
		return video_screenshots_v;
	}
	public void setVideo_screenshots_v(String video_screenshots_v) {
		this.video_screenshots_v = video_screenshots_v;
	}
	public String getVideo_like_num() {
		return video_like_num;
	}
	public void setVideo_like_num(String video_like_num) {
		this.video_like_num = video_like_num;
	}
	
	public String getVideo_id() {
		return video_id;
	}

	public void setVideo_id(String video_id) {
		this.video_id = video_id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getBlog_id() {
		return blog_id;
	}

	public void setBlog_id(String blog_id) {
		this.blog_id = blog_id;
	}

	public String getVideo_duration() {
		return video_duration;
	}
	public void setVideo_duration(String video_duration) {
		this.video_duration = video_duration;
	}
	public String getCreated_at() {
		return created_at;
	}
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	public String getVideo_reply_num() {
		return video_reply_num;
	}
	public void setVideo_reply_num(String video_reply_num) {
		this.video_reply_num = video_reply_num;
	}
	public String getVideo_play_num() {
		return video_play_num;
	}
	public void setVideo_play_num(String video_play_num) {
		this.video_play_num = video_play_num;
	}
	public String getVideo_capture_location() {
		return video_capture_location;
	}
	public void setVideo_capture_location(String video_capture_location) {
		this.video_capture_location = video_capture_location;
	}
	public String getVideo_desc() {
		return video_desc;
	}
	public void setVideo_desc(String video_desc) {
		this.video_desc = video_desc;
	}
	public String getVideo_screenshots() {
		return video_screenshots;
	}
	public void setVideo_screenshots(String video_screenshots) {
		this.video_screenshots = video_screenshots;
	}
	public String getVideo_capture_device() {
		return video_capture_device;
	}
	public void setVideo_capture_device(String video_capture_device) {
		this.video_capture_device = video_capture_device;
	}
	public String getCurrent_rank() {
		return current_rank;
	}
	public void setCurrent_rank(String current_rank) {
		this.current_rank = current_rank;
	}
	public List<DefenderParam> getDefender_list() {
		return defender_list;
	}
	public void setDefender_list(List<DefenderParam> defender_list) {
		this.defender_list = defender_list;
	}
	public List<TopCommentParam> getTop_reply_list() {
		return top_reply_list;
	}
	public void setTop_reply_list(List<TopCommentParam> top_reply_list) {
		this.top_reply_list = top_reply_list;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}

	public String getShare_count() {
		return share_count;
	}

	public void setShare_count(String share_count) {
		this.share_count = share_count;
	}
	
	public String getMy_send_total() {
		return my_send_total;
	}

	public void setMy_send_total(String my_send_total) {
		this.my_send_total = my_send_total;
	}
	
	public String getS_receive_value() {
		return s_receive_value;
	}


	public void setS_receive_value(String s_receive_value) {
		this.s_receive_value = s_receive_value;
	}
}