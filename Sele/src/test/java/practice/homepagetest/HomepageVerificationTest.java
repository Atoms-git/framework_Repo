package practice.homepagetest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.crm.generic.fileutility.webdriverutil;

public class HomepageVerificationTest {

	@Test 
	public void homePageTest() {
		
		
		System.out.println("test started" );
		String exppage= "Home Page";
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://49.249.28.218:8888/");
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click(); 
		
		String actTitle =driver.findElement(By.xpath("//a[contains(text(),'Home')]")).getText();
		
		//Hard Assert
		Assert.assertEquals(exppage, actTitle);
	}
	
	
	@Test 
	public void verifyHomePageTest() {
		
		System.out.println("test started" );
		
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://49.249.28.218:8888/");
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click(); 
		boolean status= driver.findElement(By.xpath("//img[@title=\"vtiger-crm-logo.gif\"]")).isEnabled();
		
		//option 1:
		//Assert.assertEquals(true, status);
		
		//option 2:
		//Hard Assert
		Assert.assertTrue(status);
		
		System.out.println("test ended");
		
	}
}
