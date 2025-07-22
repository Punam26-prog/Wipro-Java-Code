package dayThree;

class Employee{
	private String name;
	private double salary;
	
	public void setName(String n){
		name = n;
		
	}
	public void setSalary(double s) {
		salary = s;
	}
	public void display() {
		System.out.println("Name" + name);
		System.out.println("Slary" + salary);
	}
	
}

public class Encapsulation{
	public static void main(String[] args) {
		 Employee emp = new Employee();
	        emp.setName("Arnesh");
	        emp.setSalary(40000);
	        emp.display();

		
	}
}

