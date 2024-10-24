package practice.testng;

import org.testng.annotations.Test;

public class ContactTest {

	
	@Test
	public void createContactTest() {
		System.out.println("execute createContactTest with --->HDFC");
	}
	
	@Test(dependsOnMethods = "createContactTest")
	public void modifycontactTest() {
		System.out.println("execute modifycontactTest---->HDFC=>ICICI");
	}
	@Test(dependsOnMethods = "modifycontactTest")
	public void deletecontactTest() {
		System.out.println("execute deletecontactTest--->ICICI");
	}
}
