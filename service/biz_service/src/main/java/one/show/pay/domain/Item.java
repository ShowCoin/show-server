/**
 * 
 */
package one.show.pay.domain;

import java.math.BigDecimal;

/**
 * @author hank
 *
 */
public class Item {
	
	private int id;
	private int type;
	private BigDecimal price;
	private BigDecimal number;
	private String name;
	
	
	public BigDecimal getNumber() {
		return number;
	}
	public void setNumber(BigDecimal number) {
		this.number = number;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}


