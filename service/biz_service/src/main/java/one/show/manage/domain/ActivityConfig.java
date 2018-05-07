package one.show.manage.domain;

import java.io.Serializable;


/**
 * 活动配置模型
 * @author hank
 *
 */
public class ActivityConfig implements Serializable{

	public static final int ACTIVITY_兑换中心 	= 1;
	
	/**序列化id*/
	private static final long serialVersionUID = 1L;
	/**主键*/
	private int id;
	/**开启活动*/
	private int openActivity;
	/**活动名称*/
	private String name;
	/**描述*/
	private String description;
	/**是否激活*/
	private int isActivating;
	/**活动配置*/
	private String activityConfig;
	/**活动图标*/
	private int iconIndex;
	/**排序 数小靠前*/
	private int orderIndex;
	/**开启时间*/
	private int openStartTime;
	/**结束时间*/
	private int openEndTime;
	/**当天开启时间*/
	private String startTime;
	/**当天结束时间*/
	private String endTime;
	/**限制等级*/
	private int limitGread;
	/**创建时间*/
	private int createTime;
	/**更新时间*/
	private int updateTime;

	public int getId(){
		return this.id;
	}
	public void setId(int id){
		this.id=id;
	}
	public int getOpenActivity(){
		return this.openActivity;
	}
	public void setOpenActivity(int openActivity){
		this.openActivity=openActivity;
	}
	public String getName(){
		return this.name;
	}
	public void setName(String name){
		this.name=name;
	}
	public String getDescription(){
		return this.description;
	}
	public void setDescription(String description){
		this.description=description;
	}
	public int getIsActivating(){
		return this.isActivating;
	}
	public void setIsActivating(int isActivating){
		this.isActivating=isActivating;
	}
	public String getActivityConfig(){
		return this.activityConfig;
	}
	public void setActivityConfig(String activityConfig){
		this.activityConfig=activityConfig;
	}
	public int getIconIndex(){
		return this.iconIndex;
	}
	public void setIconIndex(int iconIndex){
		this.iconIndex=iconIndex;
	}
	public int getOrderIndex(){
		return this.orderIndex;
	}
	public void setOrderIndex(int orderIndex){
		this.orderIndex=orderIndex;
	}
	public int getOpenStartTime(){
		return this.openStartTime;
	}
	public void setOpenStartTime(int openStartTime){
		this.openStartTime=openStartTime;
	}
	public int getOpenEndTime(){
		return this.openEndTime;
	}
	public void setOpenEndTime(int openEndTime){
		this.openEndTime=openEndTime;
	}
	public String getStartTime(){
		return this.startTime;
	}
	public void setStartTime(String startTime){
		this.startTime=startTime;
	}
	public String getEndTime(){
		return this.endTime;
	}
	public void setEndTime(String endTime){
		this.endTime=endTime;
	}
	public int getLimitGread(){
		return this.limitGread;
	}
	public void setLimitGread(int limitGread){
		this.limitGread=limitGread;
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
}