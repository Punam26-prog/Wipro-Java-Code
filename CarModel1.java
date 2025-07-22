package dayThree;

public class CarModel1 {
	private String model;
	private int year;
	
	public void setModel(String model, int year) {
		this.model = model;
		this.year = year;
	}
	
	public String getModel() {
		return model;
	}
	
	public int getYear() {
		return year;
	}



	public static void main(String[] args) {
		CarModel1 c1 = new CarModel1();
		//CarModel c1 = new CarModel();
		CarModel1 c = new CarModel1();
		c.setModel("Audi", 2000);
		System.out.println("Modal Name:" + c.getModel());
		System.out.println("Modal Year:" + c.getYear());
	}
	
}
