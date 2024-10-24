package practice.testng;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Test;

import com.comcast.crm.generic.fileutility.webdriverutil;

public class TestScreen {
	
	@Test
	public void screenshot() throws Throwable {
		WebDriver driver = new ChromeDriver();
		driver.get("https://amazon.in");
		driver.manage().window().maximize();
		
		EventFiringWebDriver edriver = new EventFiringWebDriver(driver);
		File srcFile=  edriver.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile, new File("./screenshot/test1.png"));
		
		
	}

}
