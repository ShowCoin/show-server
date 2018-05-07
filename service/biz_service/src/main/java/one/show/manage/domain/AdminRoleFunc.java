package one.show.manage.domain;


/**
 * 后台角色权限关系表
 * 
 * @author Haliaeetus leucocephalus
 */
public class AdminRoleFunc {

	private Integer roleId;
	private String funcId;


	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getFuncId() {
		return funcId;
	}

	public void setFuncId(String funcId) {
		this.funcId = funcId;
	}

}
