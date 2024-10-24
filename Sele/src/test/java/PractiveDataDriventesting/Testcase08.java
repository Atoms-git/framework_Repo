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
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Testcase08 {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver= null;
		FileInputStream fis = new FileInputStream("C:\\Users\\Bhuvanesh Ramesh\\Desktop\\Test case properties\\tc-08\\tc08.properties");
		Properties pobj = new Properties();
		pobj.load(fis);
		
		
		String BROWSER = pobj.getProperty("browser");
		
		if(BROWSER.equals("chrome")) {
			 driver = new ChromeDriver();
		}
		else if(BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		}
		
		else if (BROWSER.equals("edge")) {
			driver= new EdgeDriver();
		}
		else {
			System.out.println("NO BROWSER FOUND");
		}
		
		String URL = pobj.getProperty("url");
		String USER=pobj.getProperty("username");
		String PASS = pobj.getProperty("password");
		
		
		driver.get(URL);
		
		driver.findElement(By.name("txtUsername")).sendKeys(USER);
		driver.findElement(By.name("txtPassword")).sendKeys(PASS);
		
		WebElement drop =driver.findElement(By.name("login_type"));
		Select select = new Select(drop);
		select.selectByVisibleText("Admin");
		
		driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();
		driver.findElement(By.partialLinkText("Manage Area")).click();
		
		driver.findElement(By.xpath("//input[@value=\"+ Add Area\"]")).click();
		
		
		FileInputStream fis1 = new FileInputStream("C:\\Users\\Bhuvanesh Ramesh\\Desktop\\Test case properties\\test case in xls\\Testcase .xls");
		Workbook wb=WorkbookFactory.create(fis1);
		Sheet sh =wb.getSheet("System Testing");
		Row row =sh.getRow(97);
		Cell cel= row.getCell(5);
		String area_data=cel.getStringCellValue();
		
		
		driver.findElement(By.name("txtAreaName")).sendKeys(area_data);
		
		Row row1=sh.getRow(98);
		Cell cel1 =row1.getCell(5);
		String areacode_data =cel1.getStringCellValue();
		
		driver.findElement(By.name("txtAreaCode")).sendKeys(areacode_data);
		
		driver.findElement(By.xpath("//input[@value=\"Add Area\"]")).click();
		
		Alert alt1= driver.switchTo().alert();
		Thread.sleep(Duration.ofSeconds(1000));
		alt1.accept();
		
		driver.close();
		
		

	}

}
