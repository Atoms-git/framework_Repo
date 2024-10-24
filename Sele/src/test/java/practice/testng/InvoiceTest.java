package practice.testng;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
@Listeners(com.comcast.listenerutility.ListImpClass.class)
public class InvoiceTest extends BaseClass{

	
	@Test
	public void createInvoiceTest() {
		System.out.println("execute create invoice test");
		
		String tit = driver.getTitle();
		//Hard Assert
		Assert.assertEquals(tit, "Login");
		System.out.println("step1");
		System.out.println("step2");
		System.out.println("step3");
		System.out.println("step4");
	}
	
	@Test
	public void createInvoicewithContactTest() {
		System.out.println("createInvoicewithContactTest");
		System.out.println("step1");
		System.out.println("step2");
		System.out.println("step3");
		System.out.println("step4");
		
	}
}
