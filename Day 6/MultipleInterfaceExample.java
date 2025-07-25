package Daysix;

// // Write a project in java with multiple interfaces with common methods

interface InterfaceA {
    void display();
}

interface InterfaceB {
    void display();
}
interface InterfaceC{
	void dispaly();
}

class CommonClass implements InterfaceA, InterfaceB {

    public void display() {
        System.out.println("Display method from CommonClass implementing both Interface A, Interface B and Interface C");
    }
}

// Main class to test
public class MultipleInterfaceExample {
    public static void main(String[] args) {
        CommonClass obj = new CommonClass();
        obj.display();  
    }
}
