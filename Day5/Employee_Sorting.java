package DayFive;

import java.util.List;
import java.util.ArrayList;
class Employee{
	String name;
	int id;
	 public Employee(String name,int id) {
		 this.name=name;
		 this.id=id;
	 }
	 public String toString() {
	        return "ID: " + id + ", Name: " + name;
	    }
}

public class Employee_Sorting {
	public static void main(String[] args) {
		List<Employee> employee= new ArrayList<>() ;
			employee.add(new Employee("P",02));
			employee.add(new Employee("U",01));
			employee.add(new Employee("N",03));
			employee.add(new Employee("A",04));
			employee.add(new Employee("M",06));
 
			
			System.out.println("Before Sorting:");
			
	        for (Employee emp : employee) {
	            System.out.println(emp);
	        }			
	        
	        employee.sort((e1,e2) ->e1.name.compareToIgnoreCase(e2.name));
	        
			System.out.println("\nAfter Sorting by Name: ");
			
	        for (Employee emp : employee) {
	            System.out.println(emp);
	        }
	}
}

