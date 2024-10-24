package PractiveDataDriventesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.channels.SelectableChannel;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TigerCRM {

	public static void main(String[] args) throws IOException {
		
		// TODO Auto-generated method stub
		
		WebDriver driver = null;
	
		FileInputStream fis = new FileInputStream("C:\\Users\\Bhuvanesh Ramesh\\Desktop\\Test case properties\\V tiger\\vtiger.properties");
		Properties pobj = new Properties();
		pobj.load(fis);
		
		String BROWSER = pobj.getProperty("browser");
		
		if(BROWSER.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}
		else if(BROWSER.contentEquals("firefox")) {
			driver = new FirefoxDriver();
		}
		else {
			System.out.println("NO browser found");
		}
		
		String URL = pobj.getProperty("url");
		String USER = pobj.getProperty("username");
		String PASS = pobj.getProperty("password");
		
		driver.get(URL);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@name=\"user_name\"]")).sendKeys(USER);
		driver.findElement(By.xpath("//input[@name=\"user_password\"]")).sendKeys(PASS);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.partialLinkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@alt=\"Create Organization...\"]")).click();
		
		 String verify = driver.findElement(By.xpath("//span[@class=\"lvtHeaderText\"]")).getText();
		if(verify.contains("New Organization")) {
			System.out.println("pass");
		}
		else {
			System.out.println("fail");
		}
			
			
		FileInputStream fis1= new FileInputStream("C:\\Users\\Bhuvanesh Ramesh\\Desktop\\Test case properties\\V tiger\\vtiger.xlsx");
		Workbook wb=WorkbookFactory.create(fis1);
		Sheet sh=wb.getSheet("sheet1");
		Row row =sh.getRow(0);
		Cell cel =row.getCell(0);
		String data =cel.getStringCellValue();
		
		
		driver.findElement(By.xpath("//input[@name=\"accountname\"]")).sendKeys(data);
		WebElement drop = driver.findElement(By.xpath("//select[@name=\"industry\"]"));
		Select select = new Select(drop);
		select.selectByVisibleText("Entertainment");
		
		WebElement drop2= driver.findElement(By.xpath("//select[@name=\"accounttype\"]"));
		Select select1 = new Select(drop2);
		select1.selectByVisibleText("Partner");
		
		
		Row row1 =sh.getRow(16);
		Cell cel1 =row1.getCell(7);
		String data1 =cel1.getStringCellValue().toString();
		
		driver.findElement(By.xpath("//input[@id=\"phone\"]")).sendKeys(data1);
		driver.findElement(By.xpath("//input[@class=\"crmbutton small save\"]")).click();
		
		//driver.findElement(By.xpath("//input[@fdprocessedid=\"it8odf\"]")).click();
		
		
		

	}

}
