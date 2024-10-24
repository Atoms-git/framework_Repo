package com.camcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInformation {

	WebDriver driver;
	public OrganizationInformation(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@name=\"accountname\"]")
	private WebElement orgNameEnt;
	
	//@FindAll({@FindBy(xpath = "mvxz"),@FindBy(xpath = "bzxcnb")})
	//@FindBys({@FindBy(xpath = "mvxz"),@FindBy(xpath = "bzxcnb")})
	
	@FindBy(xpath = "//select[@name=\"industry\"]")
	private WebElement select;
	
	@FindBy(xpath = "//select[@name=\"accounttype\"]")
	private WebElement selecttype;
	
	@FindBy(xpath = "//input[@id=\"phone\"]")
	private WebElement PhoneNum;
	
	@FindBy(xpath = "//input[@title=\"Save [Alt+S]\"]")
	private WebElement save;
	
	
	public WebElement getOrgNameEnt() {
		return orgNameEnt;
	}

	public WebElement getSelect() {
		return select;
	}

	public WebElement getSelecttype() {
		return selecttype;
	}

	public WebElement getPhoneNum() {
		return PhoneNum;
	}

	public WebElement getSave() {
		return save;
	}
	
	
}
