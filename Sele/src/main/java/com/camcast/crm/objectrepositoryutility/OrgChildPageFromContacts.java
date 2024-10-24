package com.camcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.fileutility.webdriverutil;

public class OrgChildPageFromContacts {

	WebDriver driver;
	public OrgChildPageFromContacts(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@name=\"search_text\"]")
	private WebElement searchbtn;
	
	public WebElement getSearchbtn() {
		return searchbtn;
	}
	
	@FindBy(xpath = "//input[@name=\"search\"]")
	private WebElement searchnowbtn;
	
	public WebElement getSearchnowbtn() {
		return searchnowbtn;
	}
	@FindBy(xpath = "//a[text()='RaviShankar']")
	private WebElement orgname;
	
	public WebElement getOrgname() {
		return orgname;
	}
	
	
	
}
