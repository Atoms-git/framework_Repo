package com.comcast.crm.basetest;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.camcast.crm.objectrepositoryutility.HomePage;
import com.camcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.generic.databaseutility.DataBaseUtility;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.fileutility.javautil;
import com.comcast.crm.generic.fileutility.webdriverutil;

public class   {
	
	public WebDriver driver;
	public static WebDriver sdriver=null;
//	public HomePage hp = new HomePage(driver);
	
	public DataBaseUtility dlib = new DataBaseUtility();
	public	FileUtility flib = new  FileUtility();
	public ExcelUtility eflib = new ExcelUtility();
	public javautil jflib = new javautil();
	public webdriverutil wflib = new webdriverutil();
	
	@BeforeSuite(groups= {"smokeTest","regressionTest"})
	public void configBS() throws SQLException {
		System.out.println("====Connect Db , Report Config===");
		dlib.getDbConnection();
		
	}
	
	//@Parameters ("BROWSER")
	@BeforeClass(groups= {"smokeTest","regressionTest"})
	public void configBC() throws IOException {
		System.out.println("Launch the Browser");
		//String BROWSER =browser;
		String BROWSER = flib.getDataFromPropertiesFile("browser");
		
		if(BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		}
		else if(BROWSER.equals("firefox")) {
			driver= new FirefoxDriver();
		}
		else  {
			System.out.println("no browser found");
		}	
		sdriver=driver;
	}
	
	@BeforeMethod(groups= {"smokeTest","regressionTest"})
	public void configBM() throws Throwable {
		System.out.println("login to application");
	LoginPage lp = new LoginPage(driver);
	String URL =flib.getDataFromPropertiesFile("url");
	String USER =flib.getDataFromPropertiesFile("username");
	String PASS =flib.getDataFromPropertiesFile("password");
	lp.loginToapp(URL, USER, PASS);
	}
	
	@AfterMethod(groups= {"smokeTest","regressionTest"})
	public void configAM() {
		System.out.println("logout application");
		HomePage hp = new HomePage(driver);
		//hp.getSignimg();
		//hp.getSignoutlnk();
		hp.logout();
	}
	
	@AfterClass(groups= {"smokeTest","regressionTest"})
	public void configAC() {
		System.out.println("Close the Browser");
		driver.quit();
	}
	
	@AfterSuite(groups= {"smokeTest","regressionTest"})
	public void configAS() throws Throwable {
		System.out.println("====Close Db , Report backup===");
		dlib.closeDbConnection();
	}
}
