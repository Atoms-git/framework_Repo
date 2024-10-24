package com.camcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.fileutility.webdriverutil;

public class CreateContactpage {

	
	WebDriver driver;
	public CreateContactpage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[@title=\"Create Contact...\"]")
	private WebElement createcontactbtn;
	
	public WebElement getCreatecontactbtn() {
		return createcontactbtn;
	}
	
	@FindBy(xpath = "//input[@name=\"lastname\"]")
	private WebElement lastname;
	
	
	public WebElement getLastname() {
		return lastname;
	}
	
	@FindBy(xpath = "//img[@title=\"Select\"]")
	private WebElement addorgbtn;
	
	public WebElement getAddorgbtn() {
		return addorgbtn;
	}
	
	@FindBy(xpath = "//input[@name=\"support_start_date\"]")
	private WebElement startdate;
	
	public WebElement getStartdate() {
		return startdate;
	}
	
	@FindBy(xpath = "//input[@name=\"support_end_date\"]")
	private WebElement enddate;
	
	public WebElement getEnddate() {
		return enddate;
	}
	
	@FindBy(xpath = "//input[@title=\"Save [Alt+S]\"]")
	private WebElement savebtn;
	
	public WebElement getSavebtn() {
		return savebtn;
	}
	
	@FindBy(xpath = "//input[@id=\"mobile\"]")
	private WebElement phonenumber;
	
	public WebElement getPhonenumber() {
		return phonenumber;
	}
	
	@FindBy(className  ="dvHeaderText")
	private WebElement headermsg;
	
	
	public WebElement getHeadermsg() {
		return headermsg;
	}
	
	@FindBy(xpath = "//span[@id=\"dtlview_Last Name\"]")
	private WebElement last;
	
	public WebElement getLast() {
		return last;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
