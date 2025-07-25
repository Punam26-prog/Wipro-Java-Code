package Daysix;

interface MyInterface {
    
    static void staticMethod() {
        System.out.println("This is a static method in the interface.");
    }

   
    default void defaultMethod() {
        System.out.println("This is a default method in the interface.");
    }

    
    void normalVoidMethod();  // A void method with no return type
}

class MyClass implements MyInterface {

    // Implementing the abstract void method
    public void normalVoidMethod() {
        System.out.println("This is the normal void method implemented in the class.");
    }

    // A separate void method in the class
    public void classVoidMethod() {
        System.out.println("This is another void method inside the class.");
    }
}

public class DefaultVoidStatic {
    public static void main(String[] args) {
        // Call static method using interface name
        MyInterface.staticMethod();

        // Create object of implementing class
        MyClass obj = new MyClass();

        // Call default method from interface
        obj.defaultMethod();

        // Call implemented void method
        obj.normalVoidMethod();

        // Call class's own void method
        obj.classVoidMethod();
    }
}
