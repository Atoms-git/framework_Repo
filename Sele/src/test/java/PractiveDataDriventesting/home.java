package PractiveDataDriventesting;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.fileutility.excelhome;
import com.comcast.crm.generic.fileutility.fileutilhome;
import com.comcast.crm.generic.fileutility.javautil;
import com.comcast.crm.generic.fileutility.webdriverutil;

public class home {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		
		fileutilhome flis = new fileutilhome();
		excelhome eflis = new excelhome();
		javautil jflis = new javautil();
		webdriverutil wflis= new webdriverutil();
	
		
		String BROWSER =flis.getDataFromPropertiesFile("browser");
		 String URL = flis.getDataFromPropertiesFile("url");
		String USER =flis.getDataFromPropertiesFile("username");
		String PASS =flis.getDataFromPropertiesFile("password");
		
		driver.manage().window().maximize();
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USER);
		driver.findElement(By.name("user_password")).sendKeys(PASS);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.partialLinkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@alt=\"Create Organization...\"]")).click();
		
		String data1 =eflis.getDataFromExcel("Sheet1", 0, 1);
		System.out.println(data1);
		String data2 = eflis.getDataFromExcel1("Sheet1", 1, 1);
		System.out.println(data2);
		String data3=  eflis.getDataFromExcel2("Sheet1", 4, 0);
		
		 wflis.waitForPageToLoad(driver);
		 driver.findElement(By.xpath("//input[@name=\"accountname\"]")).sendKeys(data1+jflis.getRandomNumber());
		 
		WebElement industry = driver.findElement(By.xpath("//select[@name=\"industry\"]"));
		 Select select = new Select(industry);
		 select.selectByIndex(12);
		 
		 
		 Random ran1 = new Random();
			int abc1 =ran1.nextInt(1000);
		// Row row1 =sh.getRow(1);
		 //Cell cel1 = row1.getCell(1);
		 //String phonedata= cel1.getStringCellValue().toString();
		 
		// driver.findElement(By.xpath("//input[@id=\"phone\"]")).sendKeys(phonedata+abc1);	 
		 driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
		 Thread.sleep(3000);
		 driver.findElement(By.xpath("//a[@href=\"index.php?module=Contacts&action=index\"]")).click();
		 driver.findElement(By.xpath("//img[@title=\"Create Contact...\"]")).click();
		
		 driver.findElement(By.xpath("//input[@name=\"support_start_date\"]")).clear();
		 String startdate=jflis.getSystemDateYYYYMMDD();
		 String enddate = jflis.getRequiredDateYYYYMMDD(30);
		 
		 driver.findElement(By.xpath("//input[@name=\"support_start_date\"]")).sendKeys(startdate);
		 driver.findElement(By.xpath("//input[@name=\"support_end_date\"]")).clear();
		 driver.findElement(By.xpath("//input[@name=\"support_end_date\"]")).sendKeys(enddate);
		 
		 driver .findElement(By.xpath("//input[@name=\"lastname\"]")).sendKeys(data3);
		 driver.findElement(By.xpath("//img[@language=\"javascript\"]")).click();
		 
		 String parent = driver.getWindowHandle();
		 
		  Set<String> childwindow = driver.getWindowHandles();
				  for (String child : childwindow) {
					driver.switchTo().window(child);
	}
		
//		driver.findElement(By.xpath("//input[@name=\"search_text\"]")).sendKeys(orgdata+abc);
		driver.findElement(By.xpath("//input[@name=\"search\"]")).submit();
		//Thread.sleep(1000);
		
		//driver.findElement(By.partialLinkText(orgdata+abc)).click();
		driver.switchTo().window(parent);
		driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
	
	} 
}

	
