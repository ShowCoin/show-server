package one.show.manage.domain;


/**
 * 后台权限表
 * 
 * @author Haliaeetus leucocephalus
 */

public class AdminFunc  {

	private String funcId;
	private String funcName;
	private String url;
	private Integer funcType;
	private String fatherFuncId;
	private Integer status;

	private boolean hasChild;

	public String getFuncId() {
		return funcId;
	}

	public void setFuncId(String funcId) {
		this.funcId = funcId;
	}

	public String getFuncName() {
		return funcName;
	}

	public void setFuncName(String funcName) {
		this.funcName = funcName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getFuncType() {
		return funcType;
	}

	public void setFuncType(Integer funcType) {
		this.funcType = funcType;
	}

	public String getFatherFuncId() {
		return fatherFuncId;
	}

	public void setFatherFuncId(String fatherFuncId) {
		this.fatherFuncId = fatherFuncId;
	}

	@Override
	public boolean equals(Object obj) {
		AdminFunc func = (AdminFunc) obj;
		if (this.funcId.equalsIgnoreCase(func.getFuncId())) {
			return true;
		} else {
			return false;
		}
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public boolean isHasChild() {
		return hasChild;
	}

	public void setHasChild(boolean hasChild) {
		this.hasChild = hasChild;
	}

}
