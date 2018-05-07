package one.show.pay.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class TransactionToUid implements Serializable{

	private static final long serialVersionUID = -1525445291484070230L;
	
	private long transactionId;
	
	private int receiveItemId;
	
	private String receiveItemName;
	
	private int receiveItemType;
	
	private BigDecimal receiveItemNumber;
	
	private int actuallyItemId;
	
	private String actuallyItemName;
	
	private int actuallyItemType;
	
	private BigDecimal actuallyItemNumber;
	
	private BigDecimal actuallyItemPrice;
	
	private int actionType;
	
	private String reason;
	
	private long vid;
	
	private long uid;
	
	private int createTime;
	
	private long fromUid;
	
	


	public long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}

	public int getReceiveItemId() {
		return receiveItemId;
	}

	public void setReceiveItemId(int receiveItemId) {
		this.receiveItemId = receiveItemId;
	}

	public String getReceiveItemName() {
		return receiveItemName;
	}

	public void setReceiveItemName(String receiveItemName) {
		this.receiveItemName = receiveItemName;
	}

	public int getReceiveItemType() {
		return receiveItemType;
	}

	public void setReceiveItemType(int receiveItemType) {
		this.receiveItemType = receiveItemType;
	}

	public BigDecimal getReceiveItemNumber() {
		return receiveItemNumber;
	}

	public void setReceiveItemNumber(BigDecimal receiveItemNumber) {
		this.receiveItemNumber = receiveItemNumber;
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


	public long getVid() {
		return vid;
	}

	public void setVid(long liveId) {
		this.vid = liveId;
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

	public long getFromUid() {
		return fromUid;
	}

	public void setFromUid(long fromUid) {
		this.fromUid = fromUid;
	}
	
	
}
