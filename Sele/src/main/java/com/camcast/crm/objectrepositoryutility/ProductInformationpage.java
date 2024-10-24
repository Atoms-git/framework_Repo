package com.camcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductInformationpage {
	
	WebDriver driver;
	public  ProductInformationpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[@class=\"lvtHeaderText\"]")
	private WebElement head;
	
	public WebElement getHead() {
		return head;
	}
	

}
