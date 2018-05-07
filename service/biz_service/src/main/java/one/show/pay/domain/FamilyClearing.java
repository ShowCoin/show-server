package one.show.pay.domain;

/**
 * @author hank
 * 
 * 
 */

public class FamilyClearing {

	/***/
	private int id;
	/** 家族id */
	private long familyId;
	/** 主播累计珍珠数 */
	private int userZzTotal;
	/** 主播累计收益 */
	private double userIncomeTotal;
	/** 主播累计直播时长 */
	private int userLiveDurationTotal;
	/** 有效主播数 */
	private int effectiveUsers;
	/** 家族结算比例 */
	private double familyClearingRatio;
	/** 家族收益 */
	private double familyIncome;
	/** 家族长id */
	private long ownerId;
	/** 0 未审核 1审核通过 2审核拒绝 */
	private int status;
	/** 家族创建时间 */
	private int createTime;
	/** 转账时间 */
	private int finishTime;
	
	/** 总计付款金额（主播+家族长提成） */
	private double totalPayment;
	
	private String orderId;
	private String reason;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getFamilyId() {
		return familyId;
	}

	public void setFamilyId(long familyId) {
		this.familyId = familyId;
	}

	public int getUserZzTotal() {
		return userZzTotal;
	}

	public void setUserZzTotal(int userZzTotal) {
		this.userZzTotal = userZzTotal;
	}

	public double getUserIncomeTotal() {
		return userIncomeTotal;
	}

	public void setUserIncomeTotal(double userIncomeTotal) {
		this.userIncomeTotal = userIncomeTotal;
	}

	public int getUserLiveDurationTotal() {
		return userLiveDurationTotal;
	}

	public void setUserLiveDurationTotal(int userLiveDurationTotal) {
		this.userLiveDurationTotal = userLiveDurationTotal;
	}

	public int getEffectiveUsers() {
		return effectiveUsers;
	}

	public void setEffectiveUsers(int effectiveUsers) {
		this.effectiveUsers = effectiveUsers;
	}

	public double getFamilyClearingRatio() {
		return familyClearingRatio;
	}

	public void setFamilyClearingRatio(double familyClearingRatio) {
		this.familyClearingRatio = familyClearingRatio;
	}

	public double getFamilyIncome() {
		return familyIncome;
	}

	public void setFamilyIncome(double familyIncome) {
		this.familyIncome = familyIncome;
	}

	public long getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(long ownerId) {
		this.ownerId = ownerId;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getCreateTime() {
		return createTime;
	}

	public void setCreateTime(int createTime) {
		this.createTime = createTime;
	}

	public int getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(int finishTime) {
		this.finishTime = finishTime;
	}

	public double getTotalPayment() {
		return totalPayment;
	}

	public void setTotalPayment(double totalPayment) {
		this.totalPayment = totalPayment;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
	
	

}
