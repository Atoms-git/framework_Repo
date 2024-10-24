package com.camcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * @author Bhuvanesh Ramesh
 */
public class OrganizationPage {

	WebDriver driver;
	public OrganizationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//input[@name=\"search_text\"]")
	private WebElement searchfor;
	
	@FindBy(name = "search_field")
	private WebElement searchdrop;
	
	
	@FindBy(xpath = "//img[@alt=\"Create Organization...\"]")
	private WebElement createNewOrgBtn;
	
	
	@FindBy(xpath = "//input[@name=\"submit\"]")
	private WebElement searchbtn;
	

	public WebElement getSearchbtn() {
		return searchbtn;
	}

	public WebElement getSearchfor() {
		return searchfor;
	}

	public WebElement getSearchdrop() {
		return searchdrop;
	}

	public WebElement getCreateNewOrgBtn() {
		return createNewOrgBtn;
	}
	
}
