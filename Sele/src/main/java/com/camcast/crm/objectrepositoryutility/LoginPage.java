package com.camcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.fileutility.webdriverutil;
/**
 * @author Bhuvanesh Ramesh
 * Contains Login Page Elements and business Lib like login
 */
public class LoginPage extends webdriverutil {  //rule 1 :create a separate java file	
							//Rule 2 : Object Creation
	
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "user_name")
	private WebElement usernameEdt;
	
	@FindBy(name = "user_password")
	private WebElement passwordEdt;

	@FindBy(id = "submitButton")
	private WebElement loginBtn;
	
//Rule  4 : object encapsulation
	
	public WebElement getUsernameEdt() {
		return usernameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}

	//Rule 5 :Provide Action
	
/**
 * @author Bhuvanesh Ramesh
 * 	login to application based on password url arguments 
 * @param url
 * @param username
 * @param password
 */
	public void loginToapp(String url ,String username , String password) {
		
		waitForPageToLoad(driver);
		driver.get(url);
		driver.manage().window().maximize();
		usernameEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		loginBtn.click();
	}
	
	@FindBy(xpath = "//input[@name=\"user_name\"]")
	private WebElement username;
	
	@FindBy(xpath = "//input[@name=\"user_password\"]")
	private WebElement password;
	
	@FindBy(xpath = "//input[@id=\"submitButton\"]")
	private WebElement click;
	
	public WebElement getUsername(String data) {
		return username;
	}

	public WebElement getPassword() {
		return password;
	}
	
	public WebElement getClick() {
		return click;
	}
}
