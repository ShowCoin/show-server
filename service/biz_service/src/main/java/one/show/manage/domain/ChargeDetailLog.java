package one.show.manage.domain;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import one.show.common.DateCalculateUtil;

public class ChargeDetailLog implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -497442809677447084L;
	
	private int id;
	
	private String uid;
	
	private String device;
	
	private String platform;
	
	private String channel;
	
	private String verifiedtime;
	
	private int money;
	
	private String product_id;
	
	private String transcation_id;
	
	private int purchase_date;
	
	private String detail;
	
	private int verified;
	
	private String receipt;
	
	private String charge_type;

	private int endVipTime;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getDevice() {
		return device;
	}

	public void setDevice(String device) {
		this.device = device;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String getVerifiedtime() {
		return verifiedtime;
	}

	public void setVerifiedtime(String verifiedtime) {
		this.verifiedtime = verifiedtime;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public String getProduct_id() {
		return product_id;
	}

	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}

	public String getTranscation_id() {
		return transcation_id;
	}

	public void setTranscation_id(String transcation_id) {
		this.transcation_id = transcation_id;
	}

	public int getPurchase_date() {
		return purchase_date;
	}

	public void setPurchase_date(int purchase_date) {
		this.purchase_date = purchase_date;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public int getVerified() {
		return verified;
	}

	public void setVerified(int verified) {
		this.verified = verified;
	}

	public String getReceipt() {
		return receipt;
	}

	public void setReceipt(String receipt) {
		this.receipt = receipt;
	}

	public String getCharge_type() {
		return charge_type;
	}

	public void setCharge_type(String charge_type) {
		this.charge_type = charge_type;
	}
	
	public String getProductId4DisPlay() {
		String product = getProduct_id();
		if(product!=null){
			if(product.contains("vip")){
				return "vip";
			}else if(product.contains("gold")){
				return "金币";
			}
		}
		return product;
	}
	public String getProductDetail4DisPlay(){
		String productId = getProductId4DisPlay();
		int money = getMoney();
		String detail=null;
		if(productId!=null){
			if("vip".equals(productId)){
				if(money==12){
					detail = "1个月";
				}else if(money==30){
					detail = "3个月";
				}else if(money==60){
					detail="6个月";
				}else if(money==118){
					detail="12个月";
				}
			}else if("金币".equals(productId)){
				if(money==12){
					detail = "1200金币";
				}else if(money==30){
					detail = "3000金币";
				}else if(money==50){
					detail = "5000金币";
				}else if(money==98){
					detail = "10000金币";
				}else if(money==198){
					detail = "20000金币";
				}else if(money==298){
					detail = "30000金币";
				}else if(money==498){
					detail = "50000金币";
				}
			}
		}
		return detail;
	}
	
	public int getEndVipTime() {
		return endVipTime();
	}

	

	public int endVipTime(){
		String productId = getProductId4DisPlay();
		int money = getMoney();
		int endTime = 0;
		Integer startTime = getPurchase_date();
		Long time = new Long(startTime)*1000;
		if(productId!=null){
			if("vip".equals(productId)){
				if(money==12){
					endTime = (int)(DateCalculateUtil.addMonth(new Date((long)(time)), 1).getTime()/1000);
				}else if(money==30){
					endTime = (int)(DateCalculateUtil.addMonth(new Date((long)(time)), 1).getTime()/1000);
				}else if(money==60){
					endTime = (int)(DateCalculateUtil.addMonth(new Date((long)(time)), 1).getTime()/1000);
				}else if(money==118){
					endTime = (int)(DateCalculateUtil.addMonth(new Date((long)(time)), 1).getTime()/1000);
				}
			}
		}
		return endTime;
	}
}
