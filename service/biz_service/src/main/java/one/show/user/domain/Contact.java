/**

 * 
 */
package one.show.user.domain;

/**
 * @author kevin 
 * 用户手机通讯录 按uid分表
 * 
 */
public class Contact {

	private String uid;
	private String name;
	private String email;
	private String number;

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

}
