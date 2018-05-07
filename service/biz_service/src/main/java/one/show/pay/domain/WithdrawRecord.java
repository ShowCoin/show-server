package one.show.pay.domain;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 提现表
 * @author hank
 * @date Mon Apr 30 14:19:05 CST 2018
 *
 */
public class WithdrawRecord implements Serializable{

	/**序列化id*/
	private static final long serialVersionUID = 1L;
	/***/
	private long id;
	/**用户id*/
	private long uid;
	/**0申请中  1提现成功 2提现失败  99恶意刷币*/
	private int status;
	/**提取的秀币数量*/
	private BigDecimal showNumber;
	/**手续费*/
	private BigDecimal serviceFee;
	/**提现前秀币数量*/
	private BigDecimal beforeChange;
	/**提现后秀币数量*/
	private BigDecimal afterChange;
	/**提现币种*/
	private int coinType;
	/**提现币数量*/
	private BigDecimal coinNumber;
	/**交易流水号*/
	private String tradeNo;
	/**转出地址*/
	private String fromAddress;
	/**转入地址*/
	private String toAddress;
	/**币币兑换率*/
	private double exchangeRate;
	/**交易时间*/
	private int tradeTime;
	/**备注*/
	private String comment;
	/**创建时间*/
	private int createTime;
	/**更新时间*/
	private int updateTime;
	/**完成时间*/
	private int finishTime;

	public long getId(){
		return this.id;
	}
	public void setId(long id){
		this.id=id;
	}
	public long getUid(){
		return this.uid;
	}
	public void setUid(long uid){
		this.uid=uid;
	}
	public int getStatus(){
		return this.status;
	}
	public void setStatus(int status){
		this.status=status;
	}
	public BigDecimal getShowNumber(){
		return this.showNumber;
	}
	public void setShowNumber(BigDecimal showNumber){
		this.showNumber=showNumber;
	}
	public BigDecimal getBeforeChange(){
		return this.beforeChange;
	}
	public void setBeforeChange(BigDecimal beforeChange){
		this.beforeChange=beforeChange;
	}
	public BigDecimal getAfterChange(){
		return this.afterChange;
	}
	public void setAfterChange(BigDecimal afterChange){
		this.afterChange=afterChange;
	}
	public int getCoinType(){
		return this.coinType;
	}
	public void setCoinType(int coinType){
		this.coinType=coinType;
	}
	public BigDecimal getCoinNumber(){
		return this.coinNumber;
	}
	public void setCoinNumber(BigDecimal coinNumber){
		this.coinNumber=coinNumber;
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
	public double getExchangeRate(){
		return this.exchangeRate;
	}
	public void setExchangeRate(double exchangeRate){
		this.exchangeRate=exchangeRate;
	}
	public int getTradeTime(){
		return this.tradeTime;
	}
	public void setTradeTime(int tradeTime){
		this.tradeTime=tradeTime;
	}
	public String getComment(){
		return this.comment;
	}
	public void setComment(String comment){
		this.comment=comment;
	}
	public int getCreateTime(){
		return this.createTime;
	}
	public void setCreateTime(int createTime){
		this.createTime=createTime;
	}
	public int getUpdateTime(){
		return this.updateTime;
	}
	public void setUpdateTime(int updateTime){
		this.updateTime=updateTime;
	}
	public int getFinishTime(){
		return this.finishTime;
	}
	public void setFinishTime(int finishTime){
		this.finishTime=finishTime;
	}
	public BigDecimal getServiceFee() {
		return serviceFee;
	}
	public void setServiceFee(BigDecimal serviceFee) {
		this.serviceFee = serviceFee;
	}
}
