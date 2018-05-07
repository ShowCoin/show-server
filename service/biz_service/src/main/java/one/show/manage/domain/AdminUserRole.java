package one.show.manage.domain;


/**
 * 后台角色用户关系表
 * 
 * @author Haliaeetus leucocephalus
 */
public class AdminUserRole {

	private String userName;
	private Integer roleId;


	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

}
