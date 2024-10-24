package practice.test;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.ConcurrentHashMap.KeySetView;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.comcast.crm.generic.fileutility.ExcelUtility;

import utilFiles.Excelutil;

public class GetProductInfoTest {
	
	@Test (dataProvider = "getData")
	public void getProductInfoTest(String brandName , String productName) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://amazon.in");
		
		//String product="iphone";
		System.out.println(productName);
		driver.findElement(By.xpath("//input[@id=\"twotabsearchtextbox\"]")).sendKeys(brandName,Keys.ENTER);
		// String x="//span[text()='"+brandNam "//span[text()='Apple iPhone 16 (128 GB) - Ultramarine']/../../../../child::div[@class=e+"']/../../../../div[3]/div[1]/div[1]/div[1]/div[1]";
		//String x = "//span[.='"+productName+"']/ancestor::div[@class=\"a-section a-spacing-small a-spacing-top-small\"]//span[@class=\"a-price-whole\"]"; 
		String x = "//span[.='"+productName+"']/ancestor::div[@class=\"a-section a-spacing-small a-spacing-top-small\"]//span[@class=\"a-price-whole\"]";
		String pp= driver.findElement(By.xpath(x)).getText();
		 System.out.println(pp);
		 driver.quit();
	}
	@DataProvider
	public Object[][] getData() throws Throwable {
		
		Excelutil eflib = new Excelutil();
		int rowcount =eflib.getRowCount("Sheet2");
		System.out.println(rowcount); 
		
		Object[][] objArr = new Object[3][2];
		
		
		for(int i=0; i<rowcount;i++) {
		
		objArr[i][0]= eflib.getDataFromExcel("Sheet2", i+1,0);
		objArr[i][1]= eflib.getDataFromExcel("Sheet2", i+1,1 ); 
		
		}
		return objArr;
	}

	
		
		
	}
	
	

