package com.camcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.fileutility.webdriverutil;

public class CampaignsPage {

	WebDriver driver;
	public CampaignsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[@alt=\"Create Campaign...\"]")
	private WebElement campadd;
	
	public WebElement getCampadd() {
		return campadd;
	}
	
	@FindBy(xpath = "//input[@name=\"campaignname\"]")
	private WebElement campname;
	

	public WebElement getCampname() {
		return campname;
	}
	
	@FindBy(xpath = "//img[@language=\"javascript\"]")
	private WebElement ppadd;
	
	public WebElement getPpadd() {
		return ppadd;
	}
	
	@FindBy(xpath = "//input[@title=\"Save [Alt+S]\"]")
	private WebElement savebtn;
	
	public WebElement getSavebtn() {
		return savebtn;
	}
	
	
	
	
}
