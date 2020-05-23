/**
 * 
 */
package Test0809;

import org.springframework.stereotype.Service;

/**
 * @author 盼望
 * @date 2019年8月9日下午3:00:13
 */
@Service
public class Line {
	
	//几号线
	private String theSubway;
	//运行一趟时间
	private int singleTime;
	//运行时间间隔
	private int intervalTime;
	//是否高峰期
	private boolean peak;
	//需要的车辆数量
	private int total;
	
	private String gao = "高峰期";
	private String xian = "闲时";
	
	/**
	 * @return the gao
	 */
	public String getGao() {
		return gao;
	}
	/**
	 * @return the xian
	 */
	public String getXian() {
		return xian;
	}
	/**
	 * @return the theSubway
	 */
	public String getTheSubway() {
		return theSubway;
	}
	/**
	 * @param theSubway the theSubway to set
	 */
	public void setTheSubway(String theSubway) {
		this.theSubway = theSubway;
	}
	/**
	 * @return the singleTime
	 */
	public int getSingleTime() {
		return singleTime;
	}
	/**
	 * @param singleTime the singleTime to set
	 */
	public void setSingleTime(int singleTime) {
		this.singleTime = singleTime;
	}
	/**
	 * @return the intervalTime
	 */
	public int getIntervalTime() {
		return intervalTime;
	}
	/**
	 * @param intervalTime the intervalTime to set
	 */
	public void setIntervalTime(int intervalTime) {
		this.intervalTime = intervalTime;
	}
	/**
	 * @return the peak
	 */
	public boolean isPeak() {
		return peak;
	}
	/**
	 * @param peak the peak to set
	 */
	public void setPeak(boolean peak) {
		this.peak = peak;
	}
	/**
	 * @return the total
	 */
	public int getTotal() {
		return total;
	}
	/**
	 * @param total the total to set
	 */
	public void setTotal(int total) {
		this.total = total;
	}
	
}
