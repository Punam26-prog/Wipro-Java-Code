package PackageNine;

import java.util.ArrayList;
import java.util.Collection;

public class Collections {

	public static void main(String[] args) {
		Collection <Integer>a = new ArrayList<Integer>();
		a.add(10);
		a.add(20);
		a.add(30);
		a.add(40);
		for(Object i : a) {
			int a1= (Integer) i;
			System.out.println(a1);
			
		}	// TODO Auto-generated method stub

	}

}
