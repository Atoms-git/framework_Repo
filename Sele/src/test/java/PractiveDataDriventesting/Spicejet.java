package PractiveDataDriventesting;

import java.time.Duration;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

public class Spicejet {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.spicejet.com/");
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--disable-notifications");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.findElement(By.xpath("//div[.='round trip']")).click();
		driver.findElement(By.xpath("//input[@autocapitalize=\"sentences\" and @autocomplete=\"on\"]")).sendKeys("MAA");
		driver.findElement(By.xpath("(//input[@autocapitalize=\"sentences\" and @autocomplete=\"on\" and @class='css-1cwyjr8 r-homxoj r-ubezar r-10paoce r-13qz1uu'])[2]")).sendKeys("BLR");
		driver.findElement(By.xpath("//div[.='24']")).click();
		driver.findElement(By.xpath("//div[.='31']")).click();
		driver.findElement(By.xpath("//div[.='Passengers']")).click();
		
		int adult = 1;
		for( int i=0; i<adult; i++) {
			
			driver.findElement(By.xpath("//div[@data-testid=\"Adult-testID-plus-one-cta\"]")).click();
		}
		int childerns = 1;
		
		for( int i=0; i<childerns; i++){
			driver.findElement(By.xpath("//div[@data-testid=\"Children-testID-plus-one-cta\"]")).click();
		}
			
		int infant =1;
		
		for( int j=0; j<infant; j++) {
			driver.findElement(By.xpath("//div[@data-testid=\"Infant-testID-plus-one-cta\"]")).click();
		}
		
		driver.findElement(By.xpath("//div[.='Done']")).click();
		driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-1awozwy r-z2wwpe r-1loqt21 r-18u37iz r-1777fci r-1g94qm0 r-d9fdf6 r-1w50u8q r-ah5dr5 r-1otgn73']")).click();
		
		
//		driver.findElement(By.xpath("(//div[@class=\"css-76zvg2 r-homxoj r-ubezar r-1ozqkpa\"])[2]")).click();
//		driver.findElement(By.xpath("//input[@value=\"Select Destination\"]")).sendKeys("MAA");
//		//driver.findElement(By.partialLinkText("27")).click();
//		//driver.findElement(By.xpath("//div[@data-testid=\"undefined-month-September-2024\"]//child::div[@data-testid=\"undefined-calendar-day-26\"]")).click();
//		//WebElement date =driver.findElement(By.xpath("//div[@data-testid=\"undefined-month-September-2024\"]//child::div[@data-testid=\"undefined-calendar-day-26\"]"));
//		//date.submit();
//		//driver.findElement(By.partialLinkText("Return Date")).click();
//		WebElement date =	driver.findElement(By.xpath("//div[text()='29']"));
//		//Thread.sleep(Duration.ofSeconds(5000));
//		date.click();
//		
//		driver.findElement(By.xpath("//div[text()='31'")).click();
}
}
