package testcasedeepak2;

import java.awt.Desktop.Action;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.camcast.crm.objectrepositoryutility.HomePage;
import com.camcast.crm.objectrepositoryutility.LoginPage;
import com.camcast.crm.objectrepositoryutility.OrganizationInformation;
import com.camcast.crm.objectrepositoryutility.OrganizationPage;
import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.fileutility.javautil;
import com.comcast.crm.generic.fileutility.webdriverutil;

public class TigerCRMOrgCreate extends BaseClass{
	
	
	@Test(groups="smokeTest")
	 public void orgcreate() throws Throwable {
		
		String orgnamefrmexcel = eflib.getDataFromExcel("Sheet1", 1, 0);
		int ranfromjava =jflib.getRandomNumber();

		HomePage hp=new HomePage(driver);
		hp.getOrgLink().click();

		OrganizationPage og=new OrganizationPage(driver);
		og.getCreateNewOrgBtn().click();
		
		OrganizationInformation oginfo = new OrganizationInformation(driver);
		oginfo.getOrgNameEnt().sendKeys(orgnamefrmexcel+ranfromjava);
	
		oginfo.getSave().click();
		//wflib.waitForPageToLoad(driver);
		Thread.sleep(3000);
}		
	
	@Test(groups="regressionTest")
public void TigerCRMOrgCreatewithindustrytype() throws Throwable {
		
		String orgnamefrmexcel = eflib.getDataFromExcel("Sheet1", 1, 0);
		int ranfromjava =jflib.getRandomNumber();
		int ranfrph=jflib.getRandomNumberfrph();
		
		HomePage hp=new HomePage(driver);
		hp.getOrgLink().click();

		OrganizationPage og=new OrganizationPage(driver);
		og.getCreateNewOrgBtn().click();
		
		OrganizationInformation oginfo = new OrganizationInformation(driver);
		oginfo.getOrgNameEnt().sendKeys(orgnamefrmexcel+ranfromjava);
		
		wflib.select(oginfo.getSelect(), eflib.getDataFromExcel1("Sheet1",1 , 1));
		wflib.select(oginfo.getSelecttype(), eflib.getDataFromExcel1("Sheet1", 1, 2));
		oginfo.getSave().click();
		
		Thread.sleep(3000);
		//wflib.waitForPageToLoad(driver);
		
	}

	@Test(groups="regressionTest")
public void TigerCRMOrgCreatewithph() throws Throwable, Throwable {

	String orgnamefrmexcel = eflib.getDataFromExcel("Sheet1", 1, 0);
	int ranfromjava =jflib.getRandomNumber();
	int ranfrph=jflib.getRandomNumberfrph();
	
	HomePage hp=new HomePage(driver);
	hp.getOrgLink().click();

	OrganizationPage og=new OrganizationPage(driver);
	og.getCreateNewOrgBtn().click();
	
	OrganizationInformation oginfo = new OrganizationInformation(driver);
	oginfo.getOrgNameEnt().sendKeys(orgnamefrmexcel+ranfromjava);
	
	String phfrmexcel = eflib.getDataFromExcel1("Sheet1", 1, 3);	
	oginfo.getPhoneNum().sendKeys(phfrmexcel+ranfrph);

	oginfo.getSave().click();
	//wflib.waitForPageToLoad(driver);
	//wflib.waitforElementPresent(driver, hp.getSignimg());
	Thread.sleep(3000);
	
	
}
}



