package one.show.util;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;

import one.show.common.GpsUtil;
import one.show.common.IPSeeker;
import one.show.init.BKInit;

import org.springframework.util.StringUtils;

public class CityUtil {
	private static IPSeeker ipsk;
	public void init() throws ServletException {
		ipsk = new IPSeeker();
	}
	/**
	 * 获取省市代码
	 * @param lng
	 * @param lat
	 * @param Ip
	 * @return
	 */
	public static Map<String,Integer> getCityNumDetail(Double lng,Double lat,String Ip){
		Map<String,Integer> resultMap = new HashMap<String,Integer>();
		if(lng !=null&&lat !=null){
			Map<String,Object> map=GpsUtil.getUserGps(lat.doubleValue(),lng.doubleValue());
			String city="";
			if(map!=null){
				Map<String,Object> map1 = (Map<String, Object>) map.get("result");
				if(map1!=null){
					Map<String,Object> address=(Map<String,Object>)map1.get("addressComponent");
					city=(String) address.get("city");
				}
			}
			if(city==null||"".equals(city)){
				resultMap.put("province", 0);
				resultMap.put("city", 0);
			}else{
				if(city.contains("北京")){
					resultMap.put("province", 40);
					resultMap.put("city", 40);
				}else if(city.contains("重庆")){
					resultMap.put("province", 43);
					resultMap.put("city", 43);
				}else if(city.contains("上海")){
					resultMap.put("province", 42);
					resultMap.put("city", 42);
					
				}else if(city.contains("天津")){
					resultMap.put("province", 41);
					resultMap.put("city", 41);
				}else{
					int cityNum=0;
					if(BKInit.cityMap.get(city.split("市")[0])!=null){
						cityNum=(int) BKInit.cityMap.get(city.split("市")[0]);
					}
					
					resultMap.put("province", cityNum/100);
					resultMap.put("city",cityNum);
				}
			}
		}else if(Ip!=null){
			resultMap.put("province", getProvice(Ip));
			resultMap.put("city", getCity(Ip));
		}
			
		
		return resultMap;
	}
	
	public static String getCityName(Double lat,Double lng){
		if(lat!=null && lng !=null){
			Map<String,Object> map=GpsUtil.getUserGps(lat.doubleValue(),lng.doubleValue());
			if(map!=null){
				Map<String,Object> map1 = (Map<String, Object>) map.get("result");
				if(map1!=null){
					Map<String,Object> address=(Map<String,Object>)map1.get("addressComponent");
					if(address!=null){
						String city=(String) address.get("city");
						return city;
					}
				}
			}
		}
		return "未知";
	}
	
	public static String getCityName(String ip){
		if(ip!=null&&!"".equals(ip)){
			if(ipsk==null){
				ipsk = new IPSeeker();
			}
			String net_area = ipsk.getIpgeter().search(ip);
			if (net_area != null) {

				String[] net_area_s = net_area.split(",");
				int net = Integer.valueOf(net_area_s[0]);
				int area = Integer.valueOf(net_area_s[1]);
				return (String) BKInit.cityReverseMap.get(String.valueOf(area));
				
			}
		}
		return "";
	}
	/**
	 * 根据ip取省份
	 * @param ip
	 * @return
	 */
	public static int getProvice(String ip){
		if(ip!=null&&!"".equals(ip)){
			if(ipsk==null){
				ipsk = new IPSeeker();
			}
			String net_area = ipsk.getIpgeter().search(ip);
			if (net_area != null) {

				String[] net_area_s = net_area.split(",");
				int net = Integer.valueOf(net_area_s[0]);
				int area = Integer.valueOf(net_area_s[1]);
				if(area>100){
					return area/100;
				}else{
					return area;
				}
			}
		}
		
		return 0;
	}
	
	/**
	 * 获取城市
	 * @param ip
	 * @return
	 */
	public static int getCity(String ip){
		if(ip!=null&&!"".equals(ip)){
			if(ipsk==null){
				ipsk = new IPSeeker();
			}
			String net_area = ipsk.getIpgeter().search(ip);
			if (net_area != null) {

				String[] net_area_s = net_area.split(",");
				int net = Integer.valueOf(net_area_s[0]);
				int area = Integer.valueOf(net_area_s[1]);
				return area;
				
			}
		}
		return 0;
	}
}
