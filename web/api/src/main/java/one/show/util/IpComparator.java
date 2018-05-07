package one.show.util;

import java.util.Comparator;
import java.util.concurrent.ConcurrentHashMap;

public class IpComparator implements Comparator<ConcurrentHashMap<String,Object>>{

	@Override
	public int compare(ConcurrentHashMap<String, Object> o1,
			ConcurrentHashMap<String, Object> o2) {
			String province1 = (String) o1.get("province");
			String province2 = (String) o2.get("province");
			
		return province1.compareTo(province2);
	}

}
