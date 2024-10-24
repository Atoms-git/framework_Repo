package vtigerAssign;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import com.camcast.crm.objectrepositoryutility.AddVendorChildpage;
import com.camcast.crm.objectrepositoryutility.HomePage;
import com.camcast.crm.objectrepositoryutility.LoginPage;
import com.camcast.crm.objectrepositoryutility.ProductInformationpage;
import com.camcast.crm.objectrepositoryutility.ProductPage;
import com.camcast.crm.objectrepositoryutility.VendorInformationPage;
import com.camcast.crm.objectrepositoryutility.VendorPage;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.fileutility.javautil;
import com.comcast.crm.generic.fileutility.webdriverutil;
import com.mysql.cj.exceptions.StreamingNotifiable;

import utilFiles.Excelutil;


public class TestCase1Vtiger {
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		WebDriver driver = null;
		FileUtility flib = new FileUtility();
		Excelutil eflib = new Excelutil();
		javautil jflib = new javautil();
		webdriverutil wflib = new webdriverutil();
		
		
		 String BROWSER =flib.getDataFromPropertiesFile("browser");
		 String URL = flib.getDataFromPropertiesFile("url");
		 String USER = flib.getDataFromPropertiesFile("username");
		 String Pass = flib.getDataFromPropertiesFile("password");
		 
		 if(BROWSER.equals("chrome")) {
			  driver = new ChromeDriver();
		 }
		 if(BROWSER.equals("edge")) {
			  driver = new EdgeDriver();
		 }
		 if(BROWSER.equals("firefox")) {
			  driver = new FirefoxDriver();
		 }
		 
		 driver.get(URL);
		 wflib.maxi(driver);
	
		 wflib.waitForPageToLoad(driver);
		 
		 int ran =jflib.getRandomNumber();
		 
		 //login to the page
		// LoginPageTc01 lp = new LoginPageTc01(driver);
		 LoginPage lp =new LoginPage(driver);
		 lp.loginToapp(USER, Pass);
		 //click the more btn 
	
		 HomePage hp = new HomePage(driver);
		 hp.getMorebtn().click();
		//click the vendor button
		hp.getVendorlink().click();
		
		VendorPage vp = new VendorPage(driver);
		vp.getVednorlnk().click();
		
		//fetch data from excel and insert vendor name and random number
		String vendname =eflib.getDataFromExcel("sheet1", 1,   2);
		int  ranfrvendor = jflib.getRandomNumber();
		vp.getVendortxtfield().sendKeys(vendname+ranfrvendor);
		//Thread.sleep(3000);
		
		//fetch data from excel and insert vendor phone number with random number and save
		String vendorph = eflib.getDataFromExcel("sheet1", 1, 4);
		int ranfrph =jflib.getRandomNumberfrph();
		vp.getPhtxt().sendKeys(vendorph+ranfrph);
		vp.getSavebtn().click();
		
		VendorInformationPage vinfopage = new VendorInformationPage(driver);
		String vinfop = vinfopage.getVendhead().getText();
		if(vinfop.contains(vendname)) {
			System.out.println("Vendor Created Sucessfully");
		}
		else {
			System.out.println("Vendor not Created Sucessfully");
		}
		hp.getPro().click();
		
		ProductPage pp = new ProductPage(driver);
		pp.getNewproductlnk().click();
		
		//fetch data from excel and insert product name with random number
		String ppname =eflib.getDataFromExcel("sheet1", 1, 5);
		int ranfrpp = jflib.getRandomNumber();
		pp.getProductnametxt().sendKeys(ppname);
		
		String ppid =wflib.parentwindow(driver);
		//System.out.println(ppid);
		
		pp.getVendoradd().click();
		 String partialurl = eflib.getDataFromExcel("sheet1", 1, 6);
		wflib.switchToNewBrowserTab(driver, partialurl);
		
		String com = (vendname+ranfrvendor);
		AddVendorChildpage av = new AddVendorChildpage(driver);
		av.getVendortxtfield().sendKeys(vendname+ranfrvendor);
		av.getSearchbtn().click();
		
		driver.findElement(By.xpath("//a[text()='"+com+"']")).click();
		
		//switching back to parent window
		driver.switchTo().window(ppid);
		//support start date
		String startdate =jflib.getSystemDateYYYYMMDD();
		pp.getStdate().sendKeys(startdate);
		
		//support end date
		String enddate =jflib.getRequiredDateYYYYMMDD(30);
		pp.geteddate().sendKeys(enddate);
		
		//want to check the path 
		//pp.getchoosefilebtn().sendKeys(C:\Users\Bhuvanesh Ramesh\Downloads\productimg.jpeg);
		
		String path =eflib.getDataFromExcel("sheet1", 1, 8);
		pp.getchoosefilebtn().sendKeys(path);
		
		pp.getSave().click();
		
		ProductInformationpage ppinfo = new ProductInformationpage(driver);
		String pinfo =ppinfo.getHead().getText();
		if(pinfo.contains(ppname)) {
			System.out.println("product is created sucessfully");
		}
		else {
			System.out.println("product is not created");
		}
		
		hp.getSignimg().click();
		hp.getSignoutlnk().click();
		driver.quit();
	}

}
