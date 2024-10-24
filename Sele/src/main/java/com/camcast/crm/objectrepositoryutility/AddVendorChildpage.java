package com.camcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddVendorChildpage {
	
	WebDriver driver;
	public  AddVendorChildpage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@name=\"search_text\"]")
	private WebElement vendortxtfield;
	
	
	public WebElement getVendortxtfield() {
		return vendortxtfield;
	}
	
	@FindBy(xpath = "//input[@class=\"crmbutton small create\"]")
	private WebElement searchbtn;
	
	
	public WebElement getSearchbtn() {
		return searchbtn;
	}
	
	
	
	
	
	
	
	

}
