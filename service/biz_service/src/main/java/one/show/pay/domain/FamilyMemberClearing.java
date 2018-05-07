package one.show.pay.domain;

/**
 * @author hank
 * 
 * 
 */

public class FamilyMemberClearing {

	/** 结算id */
	private int cid;
	/** 家族id */
	private long familyId;
	/** 主播id */
	private long userId;
	/** 角色 0家族长 1普通成员 */
	private int role;
	/** 结算珍珠数 */
	private int userZz;
	/** 结算金额 */
	private double userIncome;
	/** 直播时长 */
	private int userLiveDuration;
	/** 直播有效天数 */
	private int userLiveEffectiveDays;
	/** 创建时间 */
	private int createTime;

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public long getFamilyId() {
		return familyId;
	}

	public void setFamilyId(long familyId) {
		this.familyId = familyId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public int getUserZz() {
		return userZz;
	}

	public void setUserZz(int userZz) {
		this.userZz = userZz;
	}

	public double getUserIncome() {
		return userIncome;
	}

	public void setUserIncome(double userIncome) {
		this.userIncome = userIncome;
	}

	public int getUserLiveDuration() {
		return userLiveDuration;
	}

	public void setUserLiveDuration(int userLiveDuration) {
		this.userLiveDuration = userLiveDuration;
	}

	public int getUserLiveEffectiveDays() {
		return userLiveEffectiveDays;
	}

	public void setUserLiveEffectiveDays(int userLiveEffectiveDays) {
		this.userLiveEffectiveDays = userLiveEffectiveDays;
	}

	public int getCreateTime() {
		return createTime;
	}

	public void setCreateTime(int createTime) {
		this.createTime = createTime;
	}

}
