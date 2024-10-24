package com.camcast.crm.objectrepositoryutility;

import java.time.Duration;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath  = "//a[.='Organizations']")
	private WebElement orgLink;
	
	public WebElement getOrgLink() {
		return orgLink;
	}
	
	@FindAll({@FindBy(xpath = "src=\"themes/softed/images/user.PNG\""),@FindBy(xpath = "style=\"padding: 0px;padding-left:5px\"")})
	private WebElement adminImg;
	
	@FindBy(xpath = "//a[text()='More']")
	private WebElement morebtn;
	
	public WebElement getMorebtn() {
		return morebtn;
	}
	
	@FindBy(partialLinkText = "Vendors")
	private WebElement vendorlink;
	
	
	public WebElement getVendorlink() {
		return vendorlink;
	}

	@FindBy(partialLinkText = "Products")
	private WebElement pro;
	
	public WebElement getPro() {
		return pro;
	}
	
	@FindBy(xpath = "//a[@name=\"Campaigns\"]")
	private WebElement camp;
	
	public WebElement getCamp() {
		return camp;
	}
	@FindBy(partialLinkText = "Opportunities")
	private WebElement oppo;

	public WebElement getOppo() {
		return oppo;
	}
	
	@FindBy(xpath = "//img[@src=\"themes/softed/images/user.PNG\"]")
	private WebElement signimg;

	public WebElement getSignimg() {
		return signimg;
	}
	
	@FindBy(partialLinkText = "Sign Out")
	private WebElement signoutlnk;

	public WebElement getSignoutlnk() {
		return signoutlnk;
	}
	
	@FindBy(partialLinkText = "Contacts")
	private WebElement contactbtn;

	public WebElement getContactbtn() {
		return contactbtn;
	}
	
	public void logout()  {
		//Thread.sleep(600);
		signimg.click();
		signoutlnk.click();
	}
	
	
	
	
	
	
	
}
