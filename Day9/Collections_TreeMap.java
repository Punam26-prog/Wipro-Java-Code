package PackageNine;

import java.util.Map;
import java.util.TreeMap;

public class Collections_TreeMap {
	public static void main(String[] args) {
        Map<Integer, String> mapData = new TreeMap<>();
        mapData.put(1, "Ten");
        mapData.put(2, "Twenty");
        mapData.put(3, "Thirty");
        mapData.put(4, "Forty");

        System.out.println("TreeMap: " + mapData);

        for (Map.Entry<Integer, String> entry : mapData.entrySet()) {
            System.out.println(entry.getKey() + " => " + entry.getValue());
        }
    }
	

}
