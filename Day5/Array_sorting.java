package DayFive;
import java.util.ArrayList;
import java.util.Collections;

public class Array_sorting {
	public static void main(String[] args) {
		ArrayList<String> employees = new ArrayList<String>();
		employees.add("Punam");
		employees.add("arya");
		employees.add("Sutopa");
		employees.add("Aradhya");
		employees.add("Shruti");
		employees.add("Bindu");
		employees.add("Sonam");
		employees.add("Shivang");
		employees.add("Rupa");
		
		
		System.out.println("ArrayList before sorting is : " + employees);
	 
		Collections.sort(employees);
		
		System.out.println("ArrayList after sorting is : " + employees);
	}
	

}
