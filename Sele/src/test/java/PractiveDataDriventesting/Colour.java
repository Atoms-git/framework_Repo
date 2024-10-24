package PractiveDataDriventesting;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Colour {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone 15pro max");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class=\"left-pane-results-container\"]//child::div//child::div[@aria-label=\"iphone 15pro max\"]")).click();
		List<WebElement> allcolour = driver.findElements(By.xpath("//span[.='Apple iPhone 15 Pro Max (256 GB) - Black Titanium']//ancestor::div[@class=\"sg-col-inner\"]//child::div[@class=\"a-section a-spacing-none a-spacing-top-mini s-color-swatch-container-list-view\"]"));
		for (WebElement colour : allcolour) {
			System.out.println(colour.getText());
		}
		//driver.findElement(By.partialLinkText("Apple iPhone 15 Pro Max (256 GB) - Black Titanium")).click();
		 
		//Set<String> child = driver.getWindowHandles();
		 //for (String abc : child) {
			// driver.switchTo().window(abc);
		//}
		 //List<WebElement> allcolour = driver.findElements(By.xpath("//ul[@class=\"a-unordered-list a-nostyle a-button-list a-declarative a-button-toggle-group a-horizontal a-spacing-top-micro swatches swatchesSquare imageSwatches\"]//li"));
//		  WebElement colour = driver.findElement(By.xpath("//span[@class=\"selection\"]"));
//		System.out.println(colour.getText());
//		 
	//}

}
}
