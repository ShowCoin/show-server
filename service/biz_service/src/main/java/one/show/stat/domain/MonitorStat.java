/**
 * 
 */
package one.show.stat.domain;

import java.util.Date;

import one.show.common.TimeUtil;

/**
 * @author Haliaeetus leucocephalus 2018年3月12日 下午8:43:17
 * 
 */
public class MonitorStat {

	private long id;
	private String name;
	private long totalTime = 0l;
	private double avgTime = 0.0 ;
	private int succeedNum = 0;
	private int failNum = 0;
	private int totalNum = 0;
	private int type = 1;
	private int time = 0;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getTotalTime() {
		return totalTime;
	}
	public void setTotalTime(long totalTime) {
		this.totalTime = totalTime;
	}
	public double getAvgTime() {
		return avgTime;
	}
	public void setAvgTime(double avgTime) {
		this.avgTime = avgTime;
	}
	public int getSucceedNum() {
		return succeedNum;
	}
	public void setSucceedNum(int succeedNum) {
		this.succeedNum = succeedNum;
	}
	public int getFailNum() {
		return failNum;
	}
	public void setFailNum(int failNum) {
		this.failNum = failNum;
	}
	public int getTotalNum() {
		return totalNum;
	}
	public void setTotalNum(int totalNum) {
		this.totalNum = totalNum;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	

	

}
