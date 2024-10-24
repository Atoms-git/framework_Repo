package testcasedeepak;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.camcast.crm.objectrepositoryutility.CreateContactpage;
import com.camcast.crm.objectrepositoryutility.HomePage;
import com.camcast.crm.objectrepositoryutility.OrgChildPageFromContacts;
import com.comcast.crm.basetest.BaseClass;

public class TigerCRMContactCreatewithlastname extends BaseClass {

	@Test(groups="smokeTest")
	
	public void contactcreate() throws EncryptedDocumentException, IOException, Throwable {
		
		String orgnamefrmexcel = eflib.getDataFromExcel("Sheet1", 1, 0);
		int ranfromjava =jflib.getRandomNumber();
		int ranfrph=jflib.getRandomNumberfrph();

		HomePage hp=new HomePage(driver);
		hp.getContactbtn().click();
		wflib.waitForPageToLoad(driver);
		
		CreateContactpage ccp= new CreateContactpage(driver);
		ccp.getCreatecontactbtn().click();
		 String lastname =eflib.getDataFromExcel("Sheet1", 1, 4);
		ccp.getLastname().sendKeys(lastname);
		ccp.getSavebtn().click();
		
		String contactheader =ccp.getHeadermsg().getText();
		boolean status1 =contactheader.contains(lastname);
		//Assert.assertEquals(status1, true);
		Assert.assertTrue(status1);
		System.out.println("hi");
		Reporter.log("hello",true);
		

	}
	
	@Test(groups="regressionTest")
	public void TigerCRMContactCreatewithlastnamedate() throws EncryptedDocumentException, Throwable {
		String orgnamefrmexcel = eflib.getDataFromExcel("Sheet1", 1, 0);
		int ranfromjava =jflib.getRandomNumber();
		int ranfrph=jflib.getRandomNumberfrph();
	

		HomePage hp=new HomePage(driver);
		hp.getContactbtn().click();
		wflib.waitForPageToLoad(driver);
		
		CreateContactpage ccp= new CreateContactpage(driver);
		ccp.getCreatecontactbtn().click();
		
		ccp.getLastname().sendKeys(eflib.getDataFromExcel("Sheet1", 1, 4));
		
		ccp.getAddorgbtn().click();
		
		String URL1= "Accounts&action";
		String ppid =wflib.parentwindow(driver);
		
		wflib.switchToNewBrowserTab(driver, URL1);

		OrgChildPageFromContacts orgchild= new OrgChildPageFromContacts(driver);
		String orgname =eflib.getDataFromExcel("Sheet1", 4, 2);
		orgchild.getSearchbtn().sendKeys(orgname);
		
		wflib.waitForPageToLoad(driver);
		orgchild.getSearchnowbtn().click();
		orgchild.getOrgname().click();
		driver.switchTo().window(ppid);
		
		String stdate =jflib.getSystemDateYYYYMMDD();
		ccp.getStartdate().sendKeys(stdate);
		
		String eddate =jflib.getRequiredDateYYYYMMDD(60);
		ccp.getEnddate().clear();
		ccp.getEnddate().sendKeys(eddate);
		ccp.getSavebtn().click();
		
	}
	
	@Test(groups="regressionTest")
	public void TigerCRMContactCreatewithphone() throws EncryptedDocumentException, IOException, InterruptedException {
		
		String orgnamefrmexcel = eflib.getDataFromExcel("Sheet1", 1, 0);
		int ranfromjava =jflib.getRandomNumber();
		int ranfrph=jflib.getRandomNumberfrph();
		
		HomePage hp=new HomePage(driver);
		hp.getContactbtn().click();
		wflib.waitForPageToLoad(driver);
		
		CreateContactpage ccp= new CreateContactpage(driver);
		ccp.getCreatecontactbtn().click();
		
		ccp.getLastname().sendKeys(eflib.getDataFromExcel("Sheet1", 1, 4));
		
		ccp.getAddorgbtn().click();
		
		String URL1= "Accounts&action";
		String ppid =wflib.parentwindow(driver);
		
		wflib.switchToNewBrowserTab(driver, URL1);

		OrgChildPageFromContacts orgchild= new OrgChildPageFromContacts(driver);
		String orgname =eflib.getDataFromExcel("Sheet1", 4, 2);
		orgchild.getSearchbtn().sendKeys(orgname);
		//Thread.sleep(3000);
		wflib.waitForPageToLoad(driver);
		orgchild.getSearchnowbtn().click();
		orgchild.getOrgname().click();
		driver.switchTo().window(ppid);
		
		String phfrmexcel = eflib.getDataFromExcel1("Sheet1", 1, 3);
		ccp.getPhonenumber().sendKeys(phfrmexcel+ranfrph);
		ccp.getSavebtn().click();
	
		//hp.getSignimg().click();
		//hp.getSignoutlnk().click();
	//	hp.logout();
	}
}
