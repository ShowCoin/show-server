package one.show.pay.domain;

import java.io.Serializable;

/**
 * 充值配置表
 * @author hank
 * @date Mon Jun 06 16:18:50 CST 2016
 *
 */
public class PayConfig implements Serializable{

	/**序列化id*/
	private static final long serialVersionUID = 1L;
	/***/
	private int id;
	/**支付的金额*/
	private double chargeCount;
	/**获得的ShowCoin数*/
	private int ShowCoin;
	/**显示的ShowCoin数*/
	private int displayShowCoin;
	/***/
	private String productId;
	/***/
	private String varItem;
	/**平台  1  android   0 iOS*/
	private int platform;
	private int itemType;
	private int itemId;

	public int getId(){
		return this.id;
	}
	public void setId(int id){
		this.id=id;
	}
	public double getChargeCount(){
		return this.chargeCount;
	}
	public void setChargeCount(double chargeCount){
		this.chargeCount=chargeCount;
	}

	
	
	public int getShowCoin() {
		return ShowCoin;
	}
	public void setShowCoin(int showCoin) {
		ShowCoin = showCoin;
	}
	public int getDisplayShowCoin() {
		return displayShowCoin;
	}
	public void setDisplayShowCoin(int displayShowCoin) {
		this.displayShowCoin = displayShowCoin;
	}
	public String getProductId(){
		return this.productId;
	}
	public void setProductId(String productId){
		this.productId=productId;
	}
	public String getVarItem(){
		return this.varItem;
	}
	public void setVarItem(String varItem){
		this.varItem=varItem;
	}
	public int getPlatform(){
		return this.platform;
	}
	public void setPlatform(int platform){
		this.platform=platform;
	}
	public int getItemType() {
		return itemType;
	}
	public void setItemType(int itemType) {
		this.itemType = itemType;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
}
