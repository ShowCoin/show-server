package one.show.pay.domain;

import java.math.BigDecimal;

/**
 * 库存日志类
 * @author hank
 *
 */
public class StockLog{
	private int id;
	private long uid;
	
	private int itemId;
	private String itemName;
	private int itemType;
	private BigDecimal itemNumber;

	
	private int operate;
	private int actionTime;
	private int actionType;
	private String actionDesc;
	private BigDecimal beforeChange;
	private BigDecimal afterChange;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public long getUid() {
		return uid;
	}
	public void setUid(long uid) {
		this.uid = uid;
	}
	
	public int getActionType() {
		return actionType;
	}
	public void setActionType(int actionType) {
		this.actionType = actionType;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getItemType() {
		return itemType;
	}
	public void setItemType(int itemType) {
		this.itemType = itemType;
	}
	public BigDecimal getItemNumber() {
		return itemNumber;
	}
	public void setItemNumber(BigDecimal itemNumber) {
		this.itemNumber = itemNumber;
	}
	public int getOperate() {
		return operate;
	}
	public void setOperate(int operate) {
		this.operate = operate;
	}
	public int getActionTime() {
		return actionTime;
	}
	public void setActionTime(int actionTime) {
		this.actionTime = actionTime;
	}
	public String getActionDesc() {
		return actionDesc;
	}
	public void setActionDesc(String actionDesc) {
		this.actionDesc = actionDesc;
	}
	public BigDecimal getBeforeChange() {
		return beforeChange;
	}
	public void setBeforeChange(BigDecimal beforeChange) {
		this.beforeChange = beforeChange;
	}
	public BigDecimal getAfterChange() {
		return afterChange;
	}
	public void setAfterChange(BigDecimal afterChange) {
		this.afterChange = afterChange;
	}
	
	
	
	
	
	
}
