package PackageNine;

import java.util.List;
import java.util.ArrayList;
import java.util.Collection;

public class Collections_List {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> data=new ArrayList<Integer>();
		data.add(10);
		data.add(20);
		data.add(30);
		data.add(40);
		System.out.println(data.get(3));
		System.out.println(data.indexOf(20));
		
		//data.add("50");
		/*for(int i=0;i<data.size();i++) {
			System.out.print(data.get(i)+" ");
		}*/
		for(Object i:data) {
			
			int data1=(Integer) i;
			System.out.println(data1);
		}
		
	}
}