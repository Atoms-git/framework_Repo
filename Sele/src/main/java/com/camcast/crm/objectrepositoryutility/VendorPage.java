package com.camcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.fileutility.webdriverutil;

public class VendorPage {
	
	WebDriver driver;
	public VendorPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
	
	}
	
	//vendor link xpath
	@FindBy(xpath = "//img[@alt=\"Create Vendor...\"]")
	private WebElement  vednorlnk;
	
	public WebElement getVednorlnk() {
		return vednorlnk;
	}
	
	//vendor name textfield
	@FindBys({@FindBy(xpath = "//input[@class=\"detailedViewTextBox\"]"),@FindBy(xpath = "//input[@onblur=\"this.className='detailedViewTextBox'\"]")})
	private WebElement vendortxtfield;
	
	public WebElement getVendortxtfield() {
		return vendortxtfield;
	}
	
	//click on save button
	@FindBy(xpath = "//input[@title=\"Save [Alt+S]\"]")
	private WebElement savebtn;
	
	
	public WebElement getSavebtn() {
		return savebtn;
	}
	
	@FindBy(xpath = "//input[@id=\"phone\"]")
	private WebElement phtxt;
	public WebElement getPhtxt() {
		return phtxt;
	}
	
	
}

