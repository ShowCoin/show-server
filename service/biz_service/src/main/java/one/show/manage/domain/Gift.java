/**
 * 
 */
package one.show.manage.domain;

import java.io.Serializable;

/**
 * @author Haliaeetus leucocephalus 2018年3月8日 下午3:19:33
 *
 */
public class Gift implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2131440435570822168L;
	
	
	private Integer id;
	
	private String name;
	
	private Double price;
	
	private Integer exp;
	
	private String image;
	
	private String icon;
	
	private Integer type;
	
	private Integer status;
	
	private Integer createTime;
	
	private Integer sort;
	
	private String extend;


	

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

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Integer createTime) {
		this.createTime = createTime;
	}

	public Integer getExp() {
		return exp;
	}

	public void setExp(Integer exp) {
		this.exp = exp;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public String getExtend() {
		return extend;
	}

	public void setExtend(String extend) {
		this.extend = extend;
	}

	
	

}


