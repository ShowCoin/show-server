package one.show.manage.domain;

import java.io.Serializable;

/**
 * 头像审核
 * @author Haliaeetus leucocephalus
 *
 */
public class HeaderPortrait implements Serializable{

	private static final long serialVersionUID = 7677445027569124102L;
	/**
	 * 主键id
	 */
	private long id;
	/**
	 * 头像地址
	 */
	private String img;
	/**
	 * 昵称
	 */
	private String nickName;
	/**
	 * 创建时间
	 */
	private int createAt;
	/**
	 * 用户id
	 */
	private long uid;

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public int getCreateAt() {
		return createAt;
	}
	public void setCreateAt(int createAt) {
		this.createAt = createAt;
	}
	public long getUid() {
		return uid;
	}
	public void setUid(long uid) {
		this.uid = uid;
	}

}
