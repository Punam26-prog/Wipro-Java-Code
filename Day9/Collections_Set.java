package PackageNine;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Collections_Set {
	public static void main(String[] args) {
		Set setData = new HashSet<Integer>();
		setData.add(1);
		setData.add("hi");
		setData.add(10);
		setData.add("punam");
		System.out.println(setData);
		Iterator iterator = setData.iterator();
		 while (iterator.hasNext()) {
	            System.out.println(iterator.next());  
	        }
	}
}
