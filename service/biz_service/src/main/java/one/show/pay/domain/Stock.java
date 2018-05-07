package one.show.pay.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class Stock implements Serializable{

	private static final long serialVersionUID = 4920150063823955641L;
	
	private int id;
	
	private  long uid;
	
	private int itemId;
	
	private String itemName;
	
	private int itemType;
	
	private BigDecimal itemNumber;
	
	private int createTime;
	
	private int updateTime;
	
	private int deadLine;

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

	public int getDeadLine() {
		return deadLine;
	}

	public void setDeadLine(int deadLine) {
		this.deadLine = deadLine;
	}
	
	
}
