package PractiveDataDriventesting;

import java.awt.Desktop.Action;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.camcast.crm.objectrepositoryutility.HomePage;
import com.camcast.crm.objectrepositoryutility.LoginPage;
import com.camcast.crm.objectrepositoryutility.OrganizationInformation;
import com.camcast.crm.objectrepositoryutility.OrganizationPage;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.fileutility.javautil;
import com.comcast.crm.generic.fileutility.webdriverutil;

public class TigerCRMDeleteOrg{

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		WebDriver driver = null;
		
		FileUtility flib = new  FileUtility();
		ExcelUtility eflib = new ExcelUtility();
		javautil jflib = new javautil();
		webdriverutil wflib=new webdriverutil(); 
		
	
		
		int ranfrph=jflib.getRandomNumberfrph();
		
		// As per file utility to acess from properties file
		String BROWSER =flib.getDataFromPropertiesFile("browser");
		String URL=flib.getDataFromPropertiesFile("url");
		String USER=flib.getDataFromPropertiesFile("username");
		String  PASS =flib.getDataFromPropertiesFile("password");
		
		String orgnamefrmexcel = eflib.getDataFromExcel("Sheet1", 4, 2)+jflib.getRandomNumber();
		if(BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		}
		else if(BROWSER.equals("firefox")) {
			driver= new FirefoxDriver();
		}
		else  {
			System.out.println("no browser found");
		}
		driver.get(URL);
		//LoginPage lp=PageFactory.initElements(driver, LoginPage.class);
		wflib.waitForPageToLoad(driver);
		wflib.maxi(driver);
		
		LoginPage lp = new LoginPage(driver);
		
		lp.loginToapp("admin", "admin");
		
		HomePage hp=new HomePage(driver);
		hp.getOrgLink().click();
		
		
		OrganizationPage og=new OrganizationPage(driver);
		og.getCreateNewOrgBtn().click();
		
		OrganizationInformation oginfo = new OrganizationInformation(driver);
		oginfo.getOrgNameEnt().sendKeys(orgnamefrmexcel);
		
		//driver.navigate().refresh();

		//oginfo.getOrgNameEnt().sendKeys(orgnamefrmexcel+ranfromjava);
		
		wflib.select(oginfo.getSelect(), eflib.getDataFromExcel1("Sheet1", 4 , 3));
		
		wflib.select(oginfo.getSelecttype(), eflib.getDataFromExcel1("Sheet1", 4, 5));
		
		String phfrmexcel = eflib.getDataFromExcel1("Sheet1", 4, 4);
		
		//fetch the phone number data and add random num
		oginfo.getPhoneNum().sendKeys(phfrmexcel+ranfrph);
		//save the org details
		oginfo.getSave().click();
         
		Thread.sleep(3000);
	
		hp.getOrgLink().click();
		//go back to org page and search org 
		
	
		//in dynamic webtable select & delete org
		
		og.getSearchfor().sendKeys(orgnamefrmexcel);
		wflib.select(og.getSearchdrop(), "Organization Name");
		og.getSearchbtn().click();

		//driver.findElement(By.xpath("//a[text()='"+orgnamefrmexcel+"']/../../TD[8]/a[text()='del']")).click();
		
		driver.findElement(By.xpath("//a[text()='"+orgnamefrmexcel+"']/../../td[8]/a[text()='del']")).click();
		
		wflib.alert(driver);
		hp.getSignoutlnk();
		//hp.logout(driver);
		//driver.close();
	
		
	}
}
