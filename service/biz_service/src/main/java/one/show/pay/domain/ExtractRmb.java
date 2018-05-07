package one.show.pay.domain;

/**
 * 提现操作表
 * @author hank
 *
 */
public class ExtractRmb{
	private long id;
	private String orderId;
	private long uid;
	private int status;
	private double itemNumber;
	private double rmbNumber;
	private int createTime;
	private int updateTime;
	private String reason;
	private String comment;
	private String alipayAccount;
	private String alipayName;
	private double beforeChange;
	private double afterChange;
	private int finishTime;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getUid() {
		return uid;
	}
	public void setUid(long uid) {
		this.uid = uid;
	}
	
	public double getItemNumber() {
		return itemNumber;
	}
	public void setItemNumber(double itemNumber) {
		this.itemNumber = itemNumber;
	}
	public double getBeforeChange() {
		return beforeChange;
	}
	public void setBeforeChange(double beforeChange) {
		this.beforeChange = beforeChange;
	}
	public double getAfterChange() {
		return afterChange;
	}
	public void setAfterChange(double afterChange) {
		this.afterChange = afterChange;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public double getRmbNumber() {
		return rmbNumber;
	}
	public void setRmbNumber(double rmbNumber) {
		this.rmbNumber = rmbNumber;
	}
	public int getCreateTime() {
		return createTime;
	}
	public void setCreateTime(int createTime) {
		this.createTime = createTime;
	}
	public int getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(int updateTime) {
		this.updateTime = updateTime;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getAlipayAccount() {
		return alipayAccount;
	}
	public void setAlipayAccount(String alipayAccount) {
		this.alipayAccount = alipayAccount;
	}
	public String getAlipayName() {
		return alipayName;
	}
	public void setAlipayName(String alipayName) {
		this.alipayName = alipayName;
	}
	public int getFinishTime() {
		return finishTime;
	}
	public void setFinishTime(int finishTime) {
		this.finishTime = finishTime;
	}
}