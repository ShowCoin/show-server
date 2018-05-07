/**
 * 
 */
package one.show.stat.domain;

/**
 * @author Haliaeetus leucocephalus 2018年1月6日 下午5:12:55
 * 
 */
public class RankUserDaily {

	private long id;
	private long uid;
	private double number;
	// 类型 0消费 1收礼 2充值
	private int type;
	private int date;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getUid() {
		return uid;
	}

	public void setUid(long uid) {
		this.uid = uid;
	}

	public double getNumber() {
		return number;
	}

	public void setNumber(double number) {
		this.number = number;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getDate() {
		return date;
	}

	public void setDate(int date) {
		this.date = date;
	}

}