package PractiveDataDriventesting;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Amazon {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@aria-label=\"Search Amazon.in\"]")).sendKeys("puma");
		Thread.sleep(3000);
		//driver.findElement(By.xpath("//div[@class=\"left-pane-results-container\"]//child::div//child::div[@aria-label=\"puma sliders for men\"]")).click();
		driver.findElement(By.xpath("//div[@class=\"left-pane-results-container\"]//child::div//child::div[@aria-label=\"puma shoes for man\"]")).click();
		//driver.findElements(By.xpath("//div[@class=\"s-desktop-width-max s-desktop-content s-opposite-dir s-wide-grid-style sg-row\"]"));
		//int alldata=65;
		List<WebElement> alldata =driver.findElements(By.xpath("//span[@class=\"a-size-base-plus a-color-base a-text-normal\"]"));
		for(int i=0;i<alldata.size();i++) {
			String data =alldata.get(i).getText();
			System.out.println(data);
		}
			String xp ="//span[@class=\\\"a-price-whole\\\"]";
			String a ="2,000";
			if(xp.contains(a)) {
		 List<WebElement> price = driver.findElements(By.xpath("//span[@class=\"a-price-whole\"]"));
		 for(int i=0;i<price.size();i++)   {
			String data1= price.get(i).getText();
			System.out.println(data1);
		 }
			}
		//System.out.println(data.getAttribute(data));
		
		//driver.findElements(null)
	}

}
