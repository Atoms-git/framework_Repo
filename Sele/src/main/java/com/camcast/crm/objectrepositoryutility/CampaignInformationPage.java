package com.camcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.fileutility.webdriverutil;

public class CampaignInformationPage {
	
	WebDriver driver;
	public CampaignInformationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);	
	}
	
	@FindBy(xpath = "//span[@class=\"dvHeaderText\"]")
	private WebElement head;
	
	public WebElement getHead() {
		return head;
	}
	
	

}
