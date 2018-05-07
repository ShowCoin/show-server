package one.show.pay.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class TransactionFrom implements Serializable{

	private static final long serialVersionUID = -5940788715938860254L;

	private long transactionId;
	
	private int giveItemId;
	
	private String giveItemName;
	
	private int giveItemType;
	
	private BigDecimal giveItemNumber;
	
	private int actuallyItemId;
	
	private String actuallyItemName;
	
	private int actuallyItemType;
	
	private BigDecimal actuallyItemNumber;
	
	private BigDecimal actuallyItemPrice;
	
	private int actionType;
	
	private String reason;
	
	private long uid;
	
	private int createTime;

	private long toUid;



	public long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}

	public int getGiveItemId() {
		return giveItemId;
	}

	public void setGiveItemId(int giveItemId) {
		this.giveItemId = giveItemId;
	}

	public String getGiveItemName() {
		return giveItemName;
	}

	public void setGiveItemName(String giveItemName) {
		this.giveItemName = giveItemName;
	}

	public int getGiveItemType() {
		return giveItemType;
	}

	public void setGiveItemType(int giveItemType) {
		this.giveItemType = giveItemType;
	}

	public BigDecimal getGiveItemNumber() {
		return giveItemNumber;
	}

	public void setGiveItemNumber(BigDecimal giveItemNumber) {
		this.giveItemNumber = giveItemNumber;
	}

	public int getActuallyItemId() {
		return actuallyItemId;
	}

	public void setActuallyItemId(int actuallyItemId) {
		this.actuallyItemId = actuallyItemId;
	}

	public String getActuallyItemName() {
		return actuallyItemName;
	}

	public void setActuallyItemName(String actuallyItemName) {
		this.actuallyItemName = actuallyItemName;
	}

	public int getActuallyItemType() {
		return actuallyItemType;
	}

	public void setActuallyItemType(int actuallyItemType) {
		this.actuallyItemType = actuallyItemType;
	}

	public BigDecimal getActuallyItemNumber() {
		return actuallyItemNumber;
	}

	public void setActuallyItemNumber(BigDecimal actuallyItemNumber) {
		this.actuallyItemNumber = actuallyItemNumber;
	}

	public BigDecimal getActuallyItemPrice() {
		return actuallyItemPrice;
	}

	public void setActuallyItemPrice(BigDecimal actuallyItemPrice) {
		this.actuallyItemPrice = actuallyItemPrice;
	}

	public int getActionType() {
		return actionType;
	}

	public void setActionType(int actionType) {
		this.actionType = actionType;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public long getUid() {
		return uid;
	}

	public void setUid(long uid) {
		this.uid = uid;
	}

	public int getCreateTime() {
		return createTime;
	}

	public void setCreateTime(int createTime) {
		this.createTime = createTime;
	}

	public long getToUid() {
		return toUid;
	}

	public void setToUid(long toUid) {
		this.toUid = toUid;
	}
	
	
}
