package PractiveDataDriventesting;

import java.io.File;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.logging.FileHandler;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Testcase04 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		FileInputStream fis = new FileInputStream("C:\\Users\\Bhuvanesh Ramesh\\Desktop\\Test case properties\\tc-04\\tc-04.properties");
		Properties pobj = new Properties();
		pobj.load(fis);
		
		String BROWSER=pobj.getProperty("browser");
		String URL= pobj.getProperty("url");
		String USERNAME = pobj.getProperty("user");
		String PASSWORD = pobj.getProperty("pass");
		String MNAME = pobj.getProperty("mname");
		String MEMAIL= pobj.getProperty("memail");
		String MPHONE=pobj.getProperty("mphone");
		
		
		WebDriver driver = new ChromeDriver();
		driver.get(URL);
		driver.findElement(By.name("txtUsername")).sendKeys(USERNAME);
		driver.findElement(By.id("login:password")).sendKeys(PASSWORD);
		WebElement drop =driver.findElement(By.id("login:type"));
		Select select = new Select(drop);
		select.selectByVisibleText("Admin");
		driver.findElement(By.className("submit_button")).click();
		
		driver.findElement(By.partialLinkText("Add Manufacturer")).click();
		driver.findElement(By.name("txtManufacturerName")).sendKeys(MNAME);
		driver.findElement(By.name("txtManufacturerEmail")).sendKeys(MEMAIL);
		driver.findElement(By.name("txtManufacturerPhone")).sendKeys(MPHONE);
		WebDriverWait wait  = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		
		
		
		
		
	}

}
