
package one.show.struc;

import java.io.Serializable;

/**
 * @author Haliaeetus leucocephalus  2016年5月28日 上午12:15:52
 *
 * 
 */

public class LoginParam  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2675933614255747834L;
	private String thirdType;
	private String thirdToken;
	private String thirdId;
	private String wxUsId;
	private String thirdNickname;
	private Integer thirdSex;
	private String thirdHeadimage;
	private String thirdUserdesc;
	private String city;
	
	private String pwd;
	private String phone;
	private String email;
	
	
	
	public String getWxUsId() {
		return wxUsId;
	}
	public void setWxUsId(String wxUsId) {
		this.wxUsId = wxUsId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getThirdType() {
		return thirdType;
	}
	public void setThirdType(String thirdType) {
		this.thirdType = thirdType;
	}
	public String getThirdToken() {
		return thirdToken;
	}
	public void setThirdToken(String thirdToken) {
		this.thirdToken = thirdToken;
	}
	public String getThirdId() {
		return thirdId;
	}
	public void setThirdId(String thirdId) {
		this.thirdId = thirdId;
	}
	public String getThirdNickname() {
		return thirdNickname;
	}
	public void setThirdNickname(String thirdNickname) {
		this.thirdNickname = thirdNickname;
	}

	
	public Integer getThirdSex() {
		return thirdSex;
	}
	public void setThirdSex(Integer thirdSex) {
		this.thirdSex = thirdSex;
	}
	public String getThirdHeadimage() {
		return thirdHeadimage;
	}
	public void setThirdHeadimage(String thirdHeadimage) {
		this.thirdHeadimage = thirdHeadimage;
	}
	public String getThirdUserdesc() {
		return thirdUserdesc;
	}
	public void setThirdUserdesc(String thirdUserdesc) {
		this.thirdUserdesc = thirdUserdesc;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	

}


