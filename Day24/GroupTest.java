package Day_24;
//create a class called smoke testing i created test inside that and put it in a group called smoke -

import org.testng.annotations.Test;

public class GroupTest {
	@Test(groups = {"smoke", "sanity"})
	public void Test1() {
		System.out.println("This is smoke + sanity");
	}
	
	@Test(groups = {"smoke"})
	public void Test2() {
		System.out.println("This is smoke");
	}
	
	@Test(groups = {"smoke", "regression"})
	public void Test3() {
		System.out.println("This is smoke + regression ");
	}
	
	@Test(groups = {"sanity"})
	public void Test4() {
		System.out.println("This is sanity");
	}
	
	@Test(groups = {"regression"})
	public void Test5() {
		System.out.println("This is regression");
	}
	
	@Test(groups = {"regression", "sanity"})
	public void Test6() {
		System.out.println("This is regression + sanity");
	}


}
