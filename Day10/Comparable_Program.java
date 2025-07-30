package DayTen;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Comparable_Program {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Comparator<Integer> c1= new Comparator<Integer>() { 
			public int compare(Integer  i,Integer j) {
				if(i>j) 
					return 1;
				else 
					return -1;			
				
			}
			};
		
  ArrayList<Integer> num= new ArrayList();
      num.add(23);
      num.add(43);
      num.add(56);
      num.add(46);
      num.add(89);
      
     Collections.sort(num,c1);
     System.out.println(num);
	}
}