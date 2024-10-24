package practice.pom.repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.camcast.crm.objectrepositoryutility.LoginPage;

public class demo {
public static void main(String[] args) throws InterruptedException {
	WebDriver driver=new ChromeDriver();
	driver.get("http://106.51.90.215:8888/");
	LoginPage lp = new LoginPage(driver);
	lp.getUsernameEdt().sendKeys("admin");
	
	Thread.sleep(3000);
	driver.navigate().refresh();
	Thread.sleep(3000);
	lp.getUsernameEdt().sendKeys("admin");
}
}
