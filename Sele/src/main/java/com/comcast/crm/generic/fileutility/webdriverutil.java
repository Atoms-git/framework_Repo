package com.comcast.crm.generic.fileutility;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mysql.jdbc.Driver;

public class webdriverutil {

	
	public void waitForPageToLoad(WebDriver driver) {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	public void maxi(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	public void waitforElementPresent(WebDriver driver , WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 
	 public void switchToNewBrowserTab(WebDriver driver , String partialurl) {
		 
		  Set<String> childwindow = driver.getWindowHandles();
		  for (String child : childwindow) {
			driver.switchTo().window(child);
			String curl = driver.getCurrentUrl();
			if(curl.contains(partialurl)) {
				break;
			}
		}
	 }	
		
	 public void switchToAlert(WebDriver driver) {
	 driver.switchTo().alert().accept();
	 }

	 public void select( WebElement element , String text) {
		 Select select = new Select(element);	
		 select.selectByVisibleText(text);
	 }
	 
	 
	public void mouseOnElement(WebDriver driver ,WebElement element) {
		Actions act= new Actions(driver);
		act.moveToElement(element).perform();
		
	}
	
	public void alert (WebDriver driver) {
		Alert alt = driver.switchTo().alert();
		alt.accept();
	}
	public String parentwindow(WebDriver driver ) {
		return driver.getWindowHandle();
	}
	 
	public void scrollbyamt(WebDriver driver , WebElement element) {
		Actions act= new Actions(driver);
		act.scrollByAmount(5000, 6000).perform();
	}
	 
}
