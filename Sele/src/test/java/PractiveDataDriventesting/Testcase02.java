package PractiveDataDriventesting;

import java.io.FileInputStream;

import java.io.IOException;
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

public class Testcase02 {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = null;
		
		FileInputStream fis = new FileInputStream("C:\\Users\\Bhuvanesh Ramesh\\Desktop\\Test case properties\\tc-02.properties");
		Properties pobj = new Properties();
		pobj.load(fis);
		
		String BROWSER =pobj.getProperty("browser");
		
		if(BROWSER.equals("chrome")) {
			 driver = new ChromeDriver();
		}
		else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		}
		else if (BROWSER.equals("edge") ) { 
			driver= new EdgeDriver();
		}
		else  {
			System.out.println("Broswer not avaliable");
		}
		
		
		
		String URL =pobj.getProperty("url");
		String USERNAME=pobj.getProperty("username");
		String PASSWORD=pobj.getProperty("password");
		
		
				
		driver.get(URL);
		driver.manage().window().maximize();
		driver.findElement(By.name("txtUsername")).sendKeys(USERNAME);
		driver.findElement(By.name("txtPassword")).sendKeys(PASSWORD);
		
		WebElement abc = driver.findElement(By.id("login:type"));
		Select select = new Select(abc);
		select.selectByVisibleText("Admin");
		driver.findElement(By.className("submit_button")).click();
		
		//click add products module
		WebElement web=driver.findElement(By.partialLinkText("Add Products"));
		web.click();
		//click product name module
		WebElement web1 =driver.findElement(By.name("txtProductName"));
		web1.click();
		//click product price 
		WebElement web2= driver.findElement(By.name("txtProductPrice"));
		web2.click();
		
		
		//select unit type dropdown
		WebElement drop= driver.findElement(By.id("product:unit"));
		Select select1= new Select(drop);
		select1.selectByVisibleText("PCS");
		
		//select Category dropdown
		WebElement category = driver.findElement(By.id("product:category"));
		Select select2=new Select(category);
		select2.selectByVisibleText("Cakes");
		
		//click stock management
		driver.findElement(By.name("rdbStock")).click();
		
		//enter product description
		WebElement web3 =driver.findElement(By.id("product:description"));
		//Thread.sleep(1000);
		web3.click();
		//web3.sendKeys("hi");
		
		FileInputStream fis1= new FileInputStream("C:\\Users\\Bhuvanesh Ramesh\\Desktop\\Test case properties\\test case in xls\\Testcase .xls");
		Workbook wb = WorkbookFactory.create(fis1);
		Sheet sh = wb.getSheet("System Testing");
		
		
		
		//for fetching product name 
		Row row=sh.getRow(21);
		Cell cel = row.getCell(5);
		String productname=cel.getStringCellValue();
		web1.sendKeys(productname);
		
		//for fetching price
		Row row1= sh.getRow(22);
		Cell cel1= row1.getCell(5);
		String price =cel1.getStringCellValue();
		web2.sendKeys(price);
		
		
		//for entering description
		Row row2= sh.getRow(26);
		Cell cel2= row2.getCell(5);
		String description =cel2.getStringCellValue().toString();
		web3.sendKeys(description);
		
		//click 
		WebElement web4=driver.findElement(By.xpath("//form[@class=\"form\"]//child::input[@class=\"submit_button\"]"));
		web4.click();
		Thread.sleep(5000);
		
		driver.switchTo().alert().accept();
		
		
		
		
		

	}

}
