package com.camcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpportunitiesPage {

	WebDriver driver;
	public OpportunitiesPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[@alt=\"Create Opportunity...\"]")
	private WebElement oppor;
	
	public WebElement getOppor() {
		return oppor;
	}
	
	
	
}
