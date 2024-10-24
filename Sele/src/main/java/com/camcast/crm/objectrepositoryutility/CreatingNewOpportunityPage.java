package com.camcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.fileutility.webdriverutil;

public class CreatingNewOpportunityPage {

	WebDriver driver;
	public CreatingNewOpportunityPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@name=\"potentialname\"]")
	private WebElement opptxt;
	
	public WebElement getOpptxt() {
		return opptxt;
	}
	
	@FindBy(xpath = "//img[@alt=\"Select\"]")
	private WebElement oppadd;
	
	
	public WebElement getOppadd() {
		return oppadd;
	}
	
	@FindBy(xpath = "//input[@title=\"Save [Alt+S]\"]")
	private WebElement savvbtn;
	
	public WebElement getSavvbtn() {
		return savvbtn;
	}
	
	
	
	
	
}
