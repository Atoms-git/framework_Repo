package PractiveDataDriventesting;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class flip {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
			
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@aria-label=\"Search Amazon.in\"]")).sendKeys("puma");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class=\"left-pane-results-container\"]//child::div//child::div[@aria-label=\"puma shoes for man\"]")).click();
		List<WebElement> alldata =driver.findElements(By.xpath("//span[@class=\"a-size-base-plus a-color-base a-text-normal\"]"));
		List<WebElement> price = driver.findElements(By.xpath("//span[@class=\"a-price-whole\"]"));
		
		for(int i=0;i<alldata.size();i++) {
			
			String s=price.get(i).getText().replaceAll(",", "");
			int value=Integer.parseInt(s);
			if(value <=2000) {
			
			System.out.println(alldata.get(i).getText()+" : "+value);
				
			}
			//else
				//System.out.println("less than 2k");
			
		//}
		
		
		
	}
	}
}









//String data =alldata.get(i).getText();
//String data1= price.get(i).getText();
//System.out.println(data);
//System.out.println(data1);
////int pp= Integer.parseInt(data1);
//
//int pp = Integer.parseInt(data1.replaceAll(",", ""));
// if(pp <=2000) {
//System.out.println(data+data1);
