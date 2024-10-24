package com.camcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.fileutility.webdriverutil;

public class ProductPage {

	WebDriver driver;
	public ProductPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[@alt=\"Create Product...\"]")
	private WebElement newproductlnk;
	
	public WebElement getNewproductlnk() {
		return newproductlnk;
	}
	
	@FindBy(xpath = "//input[@name=\"productname\"]")
	private WebElement productnametxt;
	
	
	public WebElement getProductnametxt() {
		return productnametxt;
	}
	
	@FindBy(xpath = "//input[@name=\"start_date\"]")
	private WebElement stdate;
	
	public WebElement getStdate() {
		return stdate;
	}
	
	@FindBy(xpath = "//input[@name=\"expiry_date\"]")
	private WebElement eddate;
	
	public WebElement geteddate() {
		return eddate;
	}
	
	
	@FindBy(xpath = "//img[@title=\"Select\"]")
	private WebElement vendoradd;
	
	public WebElement getVendoradd() {
		return vendoradd;
	}
	
	@FindBy(id = "my_file_element")
	private WebElement choosefilebtn;
	
	public WebElement getchoosefilebtn() {
		return choosefilebtn;
	}
	
	@FindBy(xpath = "//input[@class=\"crmbutton small save\"]")
	private WebElement save;
	
	public WebElement getSave() {
		return save;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
