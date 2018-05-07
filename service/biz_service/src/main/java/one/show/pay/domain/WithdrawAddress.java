package one.show.pay.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * t_withdraw_address
 * @author hank
 * @mail <a href="mailto:hank">hank@show.one</a> 
 * @date Sat May 05 16:59:51 CST 2018
 *
 */
public class WithdrawAddress implements Serializable{

	/**序列化id*/
	private static final long serialVersionUID = 1L;
	/***/
	private int id;
	/***/
	private long uid;
	/***/
	private String name;
	/**地址类型*/
	private int type;
	/***/
	private String address;
	/**是否认证地址*/
	private boolean isVerify;
	/***/
	private int createTime;
	/**地址类型 0 ETH  1 BTC*/
	private int updateTime;

	public int getId(){
		return this.id;
	}
	public void setId(int id){
		this.id=id;
	}
	public long getUid(){
		return this.uid;
	}
	public void setUid(long uid){
		this.uid=uid;
	}
	public String getName(){
		return this.name;
	}
	public void setName(String name){
		this.name=name;
	}
	public int getType(){
		return this.type;
	}
	public void setType(int type){
		this.type=type;
	}
	public String getAddress(){
		return this.address;
	}
	public void setAddress(String address){
		this.address=address;
	}
	public boolean getIsVerify(){
		return this.isVerify;
	}
	public void setIsVerify(boolean isVerify){
		this.isVerify=isVerify;
	}
	public int getCreateTime(){
		return this.createTime;
	}
	public void setCreateTime(int createTime){
		this.createTime=createTime;
	}
	public int getUpdateTime(){
		return this.updateTime;
	}
	public void setUpdateTime(int updateTime){
		this.updateTime=updateTime;
	}
}