
package one.show.manage.domain;

import java.io.Serializable;

/**
 * @author Haliaeetus leucocephalus  
 *
 * 
 */

public class RobotSendGiftRatio implements Serializable{
	
	/***/
	private int giftId;
	/**最小连续次数*/
	private int minCount;
	/**最大连续次数*/
	private int maxCount;
	/**概率, 0.01% ~ 100%*/
	private double ratio;
	/***/
	private int createTime;
	public int getGiftId() {
		return giftId;
	}
	public void setGiftId(int giftId) {
		this.giftId = giftId;
	}
	public int getMinCount() {
		return minCount;
	}
	public void setMinCount(int minCount) {
		this.minCount = minCount;
	}
	public int getMaxCount() {
		return maxCount;
	}
	public void setMaxCount(int maxCount) {
		this.maxCount = maxCount;
	}
	public double getRatio() {
		return ratio;
	}
	public void setRatio(double ratio) {
		this.ratio = ratio;
	}
	public int getCreateTime() {
		return createTime;
	}
	public void setCreateTime(int createTime) {
		this.createTime = createTime;
	}
	
	

}


