package PractiveDataDriventesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.RowId;
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
import org.openqa.selenium.devtools.v113.network.model.DataReceived;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Testcase07 {

	public static void main(String[] args) throws IOException, InterruptedException {
		
	WebDriver driver =null;
	
	FileInputStream fis = new FileInputStream("C:\\Users\\Bhuvanesh Ramesh\\Desktop\\Test case properties\\tc-07\\tc07.properties");
	Properties pobj= new Properties();
	pobj.load(fis);
	 String BROWSER=pobj.getProperty("browser");
	 
	 
	 
	if(BROWSER.equals("chrome")) {
		driver= new ChromeDriver();
	}
	else if(BROWSER.equals("firefox")) {
		driver=new FirefoxDriver();
		
	}
	else if (BROWSER.equals("edge") ) {
		driver=new EdgeDriver();
	}
	else {
		System.out.println("no browser found");
	}

	String URL=pobj.getProperty("url");
	driver.get(URL);
	driver.manage().window().maximize();
	String USER =pobj.getProperty("username"); 
	String PASS =pobj.getProperty("password");
	
	
	
	driver.findElement(By.name("txtUsername")).sendKeys(USER);
	driver.findElement(By.name("txtPassword")).sendKeys(PASS);
	WebElement drop =driver.findElement(By.name("login_type"));
	Select select = new Select(drop);
	select.selectByVisibleText("Admin");
	
	driver.findElement(By.className("submit_button")).click();
	
	driver.findElement(By.partialLinkText("Manage Category")).click();
	
	
	Actions act = new Actions(driver);
	WebElement add = driver.findElement(By.xpath("//input[@value=\"+ Add Category\"]"));
	act.scrollByAmount(7000, 6000).perform();
	add.click();

	driver.findElement(By.name("txtCategoryName")).click();
	
	FileInputStream fis1= new FileInputStream("C:\\Users\\Bhuvanesh Ramesh\\Desktop\\Test case properties\\test case in xls\\Testcase .xls");
	Workbook wb= WorkbookFactory.create(fis1);
	Sheet sh=wb.getSheet("System Testing");
	
	//fetching category name
	Row row =sh.getRow(86);
	Cell cel=row.getCell(5);
	String category_name =cel.getStringCellValue();
	
	Row row1=sh.getRow(87);
	Cell cel1=row1.getCell(5);
	String category_description =cel1.getStringCellValue();
	
	 
	//inserting category name in the textfield
	driver.findElement(By.name("txtCategoryName")).sendKeys(category_name);
	
	
	driver.findElement(By.name("txtCategoryDetails")).sendKeys(category_description);
	
	driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();
	
	Alert alt = driver.switchTo().alert();
	Thread.sleep(10000);
	//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	
	//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	//wait.until(ExpectedConditions.elementToBeClickable()));
	
	alt.accept();
	
	
	
	
	
	
	
	
	
	
	
	}
}

