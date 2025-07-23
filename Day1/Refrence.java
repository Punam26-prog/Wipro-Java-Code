package newPackage;

     class Person {
    	 String name;
 	    Person(String name) { this.name = name; }
 	    public String toString() { return name; }
     }

     public class Refrence {
	
	public static void changeName(Person p) {
        p.name = "Changed";
	}
	public static void main(String args []) {
		int x = 10;
        int y = x;
        y = 20;
        System.out.println("x = " + x); 
        Person p1 = new Person("ayz");
        Person p2 = p1;
        p2.name = "abc";
        
        System.out.println("p1 = " + p1); 
        changeName(p1);
        System.out.println("p1 after changeName = " + p1);

	}

}
