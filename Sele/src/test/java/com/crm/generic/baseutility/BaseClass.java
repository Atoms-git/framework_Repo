package com.crm.generic.baseutility;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.camcast.crm.objectrepositoryutility.HomePage;
import com.camcast.crm.objectrepositoryutility.LoginPage;

public class BaseClass {
	
	WebDriver driver;
	@BeforeSuite
	public void configBS() {
		System.out.println("====Connect Db , Report Config===");
	}
	@BeforeClass
	public void configBC() {
		System.out.println("Launch the Browser");
	
	}
	@BeforeMethod
	public void configBM() {
		System.out.println("login to application");
	
	}
	@AfterMethod
	public void configAM() {
		HomePage hp=new HomePage(driver);
		System.out.println("logout application");
		//hp.getSignimg().click();
		hp.logout();
		
	}
	@AfterClass
	public void configAC() {
		System.out.println("Close the Browser");
	}
	@AfterSuite
	public void configAS() {
		System.out.println("====Close Db , Report backup===");
	}
}
