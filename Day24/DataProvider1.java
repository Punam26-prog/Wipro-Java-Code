package Day_24;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider1 {
	@DataProvider(name = "loginData")
	public Object[][] getData() {
		
			int size = 3;
			Object[][] data = new Object[size][2];
			
			for (int i=0; i < size; i++) {
				data[i][0] = "admin";
				data[i][1] = "admin123";
				
			}
			return data;
			
		}
		@Test(dataProvider = "loginData")
		public void loginTest(String username, String password) {
			System.out.println("Running test with: " + username + " | " + password);
		}
	

}
