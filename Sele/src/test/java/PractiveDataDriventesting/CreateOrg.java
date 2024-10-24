package PractiveDataDriventesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateOrg {

	public static void main(String[] args) throws IOException {
		// step 1: get the java representation of object of the physical file
                 WebDriver driver = null;
		
				FileInputStream fis = new FileInputStream("C:\\Users\\Bhuvanesh Ramesh\\Desktop\\SCM_bakery.properties");
				Properties pobj = new Properties();
				pobj.load(fis);
				
				String BROWSER =pobj.getProperty("browser");
//				String URL =pobj.getProperty("url");
//				String USERNAME =pobj.getProperty("username");
//				String PASS =pobj.getProperty("password");
//				
				System.out.println(BROWSER);
				String abc = "chrome";
			//	System.out.println(abc.equals(BROWSER));
				System.out.println(BROWSER.getClass());
				System.out.println(abc.getClass());
				//String XYZ = BROWSER;
				if(BROWSER.compareTo(abc) > 0) {
				
					driver = new ChromeDriver();
				}
				else if(BROWSER.equalsIgnoreCase("firefox")) {
					driver = new FirefoxDriver();
				}
				else {
					driver = new FirefoxDriver();
				}
				
				
//				System.out.println(URL);
			//	System.out.println(USERNAME);
			//	System.out.println(PASS);
				
				//WebDriver driver = new ChromeDriver();
//				driver.get(URL);
//				driver .findElement(By.name("txtUsername")).sendKeys(USERNAME);
//				driver.findElement(By.name("txtPassword")).sendKeys(PASS);
//				
//				WebElement dropdown = driver.findElement(By.id("login:type"));
//				Select option = new Select(dropdown);
//				option.selectByValue("admin");
//				driver.findElement(By.className("submit_button")).click();
				
				
				
				//driver.findElement(By.id("")).click();
				//driver.findElement(By.partialLinkText("Organizations")).click();
				
				
	}

}
