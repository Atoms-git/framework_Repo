package practice.test;
/**
 * test class for contact module
 * @author Bhuvanesh Ramesh
 */

import org.testng.annotations.Test;

import com.camcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.basetest.BaseClass;

public class SearchContactTest  extends BaseClass{

	@Test
	public void searchContactTest() {
		
		/*
		 * Login to app
		 */
		
		/**
		 * login 
		 * login
		 */
		LoginPage lp = new LoginPage(driver);
				lp.loginToapp("url", "username", "pass");
	}
	
	
}
