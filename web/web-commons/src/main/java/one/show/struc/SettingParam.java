package one.show.struc;

public class SettingParam {
	//免打扰
	private int no_disturb;
	
	//被关注
	private int notify_follow;
	
	//通知不显示消息正文
	private int default_text;	
	
	//被打招呼
	private int hi;	
	
	//被@
	private int notify_at;	

	//分享送礼到视频
	private int share_when_like;

	//好友进入
	private int friends_entry;

	//被评论
	private int notify_comment;

	//被喜欢
	private int notify_like;

	//被推荐
	private int pushed;

	//震动
	private int vibration;

	//好友发布新视频
	private int publish_video;

	//收到礼物
	private int gift_video;

	//分享评论到视频
	private int share_when_comment;

	
	public SettingParam() {
		this.no_disturb = 0;
		this.notify_follow = 0;
		this.default_text = 0;
		this.hi = 0;
		this.notify_at = 0;
		this.share_when_like = 0;
		this.friends_entry = 0;
		this.notify_comment = 0;
		this.notify_like = 0;
		this.pushed = 0;
		this.vibration = 0;
		this.publish_video = 0;
		this.gift_video = 0;
		this.share_when_comment = 0;
	}

	public int getNo_disturb() {
		return no_disturb;
	}

	public void setNo_disturb(int no_disturb) {
		this.no_disturb = no_disturb;
	}

	public int getNotify_follow() {
		return notify_follow;
	}

	public void setNotify_follow(int notify_follow) {
		this.notify_follow = notify_follow;
	}

	public int getDefault_text() {
		return default_text;
	}

	public void setDefault_text(int default_text) {
		this.default_text = default_text;
	}

	public int getNotify_at() {
		return notify_at;
	}

	public void setNotify_at(int notify_at) {
		this.notify_at = notify_at;
	}

	public int getShare_when_like() {
		return share_when_like;
	}

	public void setShare_when_like(int share_when_like) {
		this.share_when_like = share_when_like;
	}

	public int getFriends_entry() {
		return friends_entry;
	}

	public void setFriends_entry(int friends_entry) {
		this.friends_entry = friends_entry;
	}

	public int getNotify_comment() {
		return notify_comment;
	}

	public void setNotify_comment(int notify_comment) {
		this.notify_comment = notify_comment;
	}

	public int getNotify_like() {
		return notify_like;
	}

	public void setNotify_like(int notify_like) {
		this.notify_like = notify_like;
	}

	public int getPublish_video() {
		return publish_video;
	}

	public void setPublish_video(int publish_video) {
		this.publish_video = publish_video;
	}

	public int getGift_video() {
		return gift_video;
	}

	public void setGift_video(int gift_video) {
		this.gift_video = gift_video;
	}

	public int getShare_when_comment() {
		return share_when_comment;
	}

	public void setShare_when_comment(int share_when_comment) {
		this.share_when_comment = share_when_comment;
	}

	public int getHi() {
		return hi;
	}

	public void setHi(int hi) {
		this.hi = hi;
	}

	public int getPushed() {
		return pushed;
	}

	public void setPushed(int pushed) {
		this.pushed = pushed;
	}

	public int getVibration() {
		return vibration;
	}

	public void setVibration(int vibration) {
		this.vibration = vibration;
	}
}
