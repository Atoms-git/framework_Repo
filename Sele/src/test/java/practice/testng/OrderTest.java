package practice.testng;

import org.testng.annotations.Test;

import net.bytebuddy.build.Plugin.Factory.UsingReflection.Priority;

public class OrderTest {
	
	@Test(priority = 2)
	public void createOrderTest() {
		System.out.println("Execute CreateOrderTest--->123");
		
	}
	@Test(dependsOnMethods = "createOrderTest")
	public void billingAnOrderTest() {
		System.out.println("Execute billingOrderTest--->234");
	}
	@Test(priority = 3)
	public void create() {
		System.out.println("bye");
	}

}
