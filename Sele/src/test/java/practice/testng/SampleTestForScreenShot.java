package practice.testng;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Test;

import com.comcast.crm.generic.fileutility.FileUtility;

public class SampleTestForScreenShot {

	
	@Test
	public void amazonTest() throws IOException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://amazon.in");
		
		//Step 1 : create an object to EventFiring WebDriver
		EventFiringWebDriver edriver = new EventFiringWebDriver(driver);
		//Step 2 : Use get screenshot as method to get the file type of scrrenshot
	 File srcFile=	edriver.getScreenshotAs(OutputType.FILE);
	 
	 //store screenshot in local drive
	 FileUtils.copyFile(srcFile, new File("./screenshot/test.png"));
	 
	}
}
