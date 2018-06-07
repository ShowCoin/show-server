package one.show.pay.domain;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 充值记录表
 * @author hank
 * @date Mon Apr 30 14:06:09 CST 2018
 *
 */
public class ChargeRecord implements Serializable{

	/**序列化id*/
	private static final long serialVersionUID = 1L;
	/**唯一id*/
	private long id;
	/**交易号*/
	private String tradeNo;
	/**转出地址*/
	private String fromAddress;
	/**转入地址*/
	private String toAddress;
	/**用户id*/
	private long uid;
	/**充值币类型*/
	private int coinType;
	/**充值币数量*/
	private BigDecimal coinNum;
	/**币币转换率*/
	private double exchangeRate;
	/**秀币数量*/
	private BigDecimal showCoinNum;
	/**交易时间*/
	private int tradeTime;
	/**创建时间*/
	private int createTime;

	public long getId(){
		return this.id;
	}
	public void setId(long id){
		this.id=id;
	}
	public String getTradeNo(){
		return this.tradeNo;
	}
	public void setTradeNo(String tradeNo){
		this.tradeNo=tradeNo;
	}
	public String getFromAddress(){
		return this.fromAddress;
	}
	public void setFromAddress(String fromAddress){
		this.fromAddress=fromAddress;
	}
	public String getToAddress(){
		return this.toAddress;
	}
	public void setToAddress(String toAddress){
		this.toAddress=toAddress;
	}
	public long getUid(){
		return this.uid;
	}
	public void setUid(long uid){
		this.uid=uid;
	}
	public int getCoinType(){
		return this.coinType;
	}
	public void setCoinType(int coinType){
		this.coinType=coinType;
	}
	public BigDecimal getCoinNum(){
		return this.coinNum;
	}
	public void setCoinNum(BigDecimal coinNum){
		this.coinNum=coinNum;
	}
	public double getExchangeRate(){
		return this.exchangeRate;
	}
	public void setExchangeRate(double exchangeRate){
		this.exchangeRate=exchangeRate;
	}
	public BigDecimal getShowCoinNum(){
		return this.showCoinNum;
	}
	public void setShowCoinNum(BigDecimal showCoinNum){
		this.showCoinNum=showCoinNum;
	}
	public int getTradeTime(){
		return this.tradeTime;
	}
	public void setTradeTime(int tradeTime){
		this.tradeTime=tradeTime;
	}
	public int getCreateTime(){
		return this.createTime;
	}
	public void setCreateTime(int createTime){
		this.createTime=createTime;
	}
}
