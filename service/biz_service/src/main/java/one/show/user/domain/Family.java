package one.show.user.domain;

import java.io.Serializable;

public class Family  implements Serializable{

	/**序列化id*/
	private static final long serialVersionUID = 1L;
	/***/
	private long id;
	/**家族名字*/
	private String name;
	/**家族长id*/
	private long ownerId;
	/**家族长真实姓名*/
	private String ownerName;
	/**家族长性别*/
	private int ownerSex;
	/**家族长联系电话*/
	private String contactNo;
	/**家族状态*/
	private int status;
	/**支付宝账号*/
	private String alipayAccount;
	/**支付宝名称*/
	private String alipayName;
	/**家族创建时间*/
	private int createTime;
	
	private String type;

	public long getId(){
		return this.id;
	}
	public void setId(long id){
		this.id=id;
	}
	public String getName(){
		return this.name;
	}
	public void setName(String name){
		this.name=name;
	}
	public long getOwnerId(){
		return this.ownerId;
	}
	public void setOwnerId(long ownerId){
		this.ownerId=ownerId;
	}
	public String getOwnerName(){
		return this.ownerName;
	}
	public void setOwnerName(String ownerName){
		this.ownerName=ownerName;
	}
	public int getOwnerSex(){
		return this.ownerSex;
	}
	public void setOwnerSex(int ownerSex){
		this.ownerSex=ownerSex;
	}
	public String getContactNo(){
		return this.contactNo;
	}
	public void setContactNo(String contactNo){
		this.contactNo=contactNo;
	}
	
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getAlipayAccount(){
		return this.alipayAccount;
	}
	public void setAlipayAccount(String alipayAccount){
		this.alipayAccount=alipayAccount;
	}
	public String getAlipayName(){
		return this.alipayName;
	}
	public void setAlipayName(String alipayName){
		this.alipayName=alipayName;
	}
	public int getCreateTime(){
		return this.createTime;
	}
	public void setCreateTime(int createTime){
		this.createTime=createTime;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
}