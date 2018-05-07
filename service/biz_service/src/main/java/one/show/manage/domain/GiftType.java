/**
 * 
 */
package one.show.manage.domain;

import java.io.Serializable;

/**
 * @author Haliaeetus leucocephalus 2018年3月8日 下午5:47:17
 *
 */
public class GiftType implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6637122556253310073L;
	
	
	private Integer id;
	
	private String name;
	
	private Integer status;

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
	

}


