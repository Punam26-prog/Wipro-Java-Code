package PackageNine;

import java.util.Iterator;
import java.util.LinkedList;

public class Collections_LinkdeList {
	  public static void main(String[] args) {
	        LinkedList<Integer> listData = new LinkedList<>();
	        listData.add(55);
	        listData.add(15);
	        listData.add(25);
	        listData.add(35);
	        
	        System.out.println("LinkedList: " + listData);
	        
	        Iterator<Integer> iterator = listData.iterator();
	        System.out.println("Iterating through LinkedList:");
	        while (iterator.hasNext()) {
	            System.out.println(iterator.next());
	        }
	    }
}
