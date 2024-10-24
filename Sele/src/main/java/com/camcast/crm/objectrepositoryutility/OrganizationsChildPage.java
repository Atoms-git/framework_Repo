package com.camcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsChildPage {

	WebDriver driver;
	public OrganizationsChildPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@name=\"search_text\"]")
	private WebElement orgtxt;
	
	
	public WebElement getOrgtxt() {
		return orgtxt;
	}
	
	@FindBy(xpath = "//input[@type=\"button\"]")
	private WebElement searchbtn;
	
	public WebElement getSearchbtn() {
		return searchbtn;
	}
	
	
	
	
}
