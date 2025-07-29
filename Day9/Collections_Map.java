package PackageNine;

import java.util.HashMap;
import java.util.Map;

public class Collections_Map {
	public static void main(String[] args) {
		Map<String,Integer> mapData = new HashMap<String, Integer>();
		mapData.put("A", 1);
		mapData.put("B", 2);
		mapData.put("C", 3);
		mapData.put("D", 4);
		System.out.println(mapData.keySet());
		System.out.println(mapData.values());
		for(String key : mapData.keySet()) {
			System.out.println(key + " :" + mapData.get(key));
		}	
	}

}
