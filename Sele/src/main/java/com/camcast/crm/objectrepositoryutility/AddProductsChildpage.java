package com.camcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.fileutility.webdriverutil;

public class AddProductsChildpage {

	WebDriver driver;
	public AddProductsChildpage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@name=\"search_text\"]")
	private WebElement pptxt;
	
	public WebElement getPptxt() {
		return pptxt;
	}
	
	@FindBy(xpath = "//input[@name=\"search\"]")
	private WebElement ppsearchbtn;
	
	
	public WebElement getPpsearchbtn() {
		return ppsearchbtn;
	}
	
	
	
	
	
	
}
