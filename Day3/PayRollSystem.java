package dayThree;

public class PayRollSystem {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employees e1 = new FullTimeEmployee("Punam", 101, 50000);
        Employees e2 = new PartTimeEmployee("Arya", 102, 80, 300);

        e1.display();
        System.out.println("Salary: ₹" + e1.calculateSalary());

        System.out.println();

        e2.display();
        System.out.println("Salary: ₹" + e2.calculateSalary());
    }

}
