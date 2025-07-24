package DayFive;

// DURING LIVE SESSION

interface WiproSystems{
	void deviceType();
	void compilespeed();
}
class Desktop implements WiproSystems{
	public void deviceType() {
		System.out.println("Wipro provides device:DESKTOP");
	}
	public void compilespeed() {
		System.out.println("Code is compiled faster in Desktop");
}
}
class Laptop implements WiproSystems{
	public void deviceType() {
		System.out.println("Wipro provides device:LAPTOP");
	}
	public void compilespeed() {
		System.out.println("Code is compiled slower in Laptop");
}
	
	}
public class WiproSystem {
	public static void main(String[] args) {
		WiproSystems laptop=new Laptop();
		laptop.deviceType();
		laptop.compilespeed();
		
		WiproSystems desktop=new Desktop();
		desktop.deviceType();
		desktop.compilespeed();
	}
}

