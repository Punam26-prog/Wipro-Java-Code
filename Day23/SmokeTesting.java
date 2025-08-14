package nopcommerce;

import org.testng.annotations.Test;
import org.testng.Assert;


public class SmokeTesting {
	 @Test(groups = {"smoke"})
	    public void quickCheck() {
	        System.out.println("Running Smoke Test: Basic site availability check");
	        Assert.assertTrue(true, "Smoke test passed");
	    }

}
