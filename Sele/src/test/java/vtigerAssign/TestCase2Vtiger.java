package vtigerAssign;

import java.io.IOException;

import java.security.PrivateKey;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;

import com.camcast.crm.objectrepositoryutility.AddProductsChildpage;
import com.camcast.crm.objectrepositoryutility.CampaignInformationPage;
import com.camcast.crm.objectrepositoryutility.CampaignsPage;
import com.camcast.crm.objectrepositoryutility.CreatingNewOpportunityPage;
import com.camcast.crm.objectrepositoryutility.HomePage;
import com.camcast.crm.objectrepositoryutility.LoginPage;
import com.camcast.crm.objectrepositoryutility.OpportunitiesPage;
import com.camcast.crm.objectrepositoryutility.OpportunityInformationPage;
import com.camcast.crm.objectrepositoryutility.OrganizationsChildPage;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.fileutility.javautil;
import com.comcast.crm.generic.fileutility.webdriverutil;

import utilFiles.Excelutil;


public class TestCase2Vtiger {

	public static void main(String[] args) throws IOException {
			
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
			 LoginPage lp = new LoginPage(driver);
			 lp.loginToapp(USER, Pass);
			 
			//click the more btn and camp link
			 HomePage hp = new HomePage(driver);
			 hp.getMorebtn().click();
			 hp.getCamp().click();
			 
			 CampaignsPage camppage= new CampaignsPage(driver);
			 camppage.getCampadd().click();
			 String cpname = eflib.getDataFromExcel("sheet1", 4, 2);
			 int ranfrcamp = jflib.getRandomNumberfrcamp();
			 camppage.getCampname().sendKeys(cpname+ranfrcamp);
			 
			 camppage.getPpadd().click();
			 
			 String ppwin = wflib.parentwindow(driver);

			 String partialurl = eflib.getDataFromExcel("sheet1", 4, 3);
			 wflib.switchToNewBrowserTab(driver, partialurl);
			 
			 String ppname =eflib.getDataFromExcel("sheet1", 1, 5);
			 int ranfrpp = jflib.getRandomNumber();
			 
			 AddProductsChildpage vchild= new AddProductsChildpage(driver);
			 vchild.getPptxt().sendKeys(ppname);
			 vchild.getPpsearchbtn().click();
			 
			 driver.findElement(By.xpath("//a[text()='"+ppname+"']")).click();
			 driver.switchTo().window(ppwin);
			 camppage.getSavebtn().click();
			 //verify the campaign is created or not
			 CampaignInformationPage campinfo = new CampaignInformationPage(driver);
		     String cinfo	= campinfo.getHead().getText();
		     if(cinfo.contains(cpname)) {
		    	 System.out.println("Campaign is created Sucessfully");
		     }
		     else {
		    	 System.out.println("Campaign is not created");
		     }
			 //click Opportunities 
		     hp.getOppo().click();
		     OpportunitiesPage oppor = new OpportunitiesPage(driver);
		     oppor.getOppor().click();
		   
		     String oppexcel =eflib.getDataFromExcel("sheet1", 4, 7);
		     CreatingNewOpportunityPage newopp = new CreatingNewOpportunityPage(driver);
		     newopp.getOpptxt().sendKeys(oppexcel);
		     String ppid =wflib.parentwindow(driver);
		     
		     newopp.getOppadd().click();
		     String partialurl1 = eflib.getDataFromExcel("sheet1", 4, 6);
		   	 wflib.switchToNewBrowserTab(driver, partialurl1);
		   	 
		   	 OrganizationsChildPage orgchild = new OrganizationsChildPage(driver);
		     orgchild.getOrgtxt().sendKeys(oppexcel);
		   	 orgchild.getSearchbtn().click();
		   
		   	 driver.findElement(By.partialLinkText(oppexcel)).click();
		   	 driver.switchTo().window(ppid);
		    newopp.getSavvbtn().click();
		    
		    OpportunityInformationPage oppinfo = new OpportunityInformationPage(driver);
		    String opphead  = oppinfo.getHead().getText();
		    if(opphead.contains(oppexcel)) {
		    	System.out.println("Opportunity is created sucessfully");
		    }
		    else {
		    	System.out.println("Opportunity is not created");
		    }
		    
		    hp.getSignimg().click();
		    hp.getSignoutlnk().click();
		    driver.quit();
	} 

}
