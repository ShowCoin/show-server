package one.show.manage.domain;

import java.io.Serializable;

/**
 *  用户消费表
 * @author hank 2018/1/15
 *
 */
public class UserPayInfo implements Serializable{
	private static final long serialVersionUID = -3552039746444494843L;
	public String id;
    public int account;
    public int receive;
    public int spend;
    public String vipExpire;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getAccount() {
		return account;
	}
	public void setAccount(int account) {
		this.account = account;
	}
	public int getReceive() {
		return receive;
	}
	public void setReceive(int receive) {
		this.receive = receive;
	}
	public int getSpend() {
		return spend;
	}
	public void setSpend(int spend) {
		this.spend = spend;
	}
	public String getVipExpire() {
		return vipExpire;
	}
	public void setVipExpire(String vipExpire) {
		this.vipExpire = vipExpire;
	}
}