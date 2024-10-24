package PractiveDataDriventesting;

import java.awt.CardLayout;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.RowId;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
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
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class TigerCRM1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		WebDriver driver = null;
		
		FileInputStream fis = new FileInputStream("C:\\Users\\Bhuvanesh Ramesh\\Desktop\\Test case properties\\V tiger\\vtiger.properties");
		Properties pobj = new Properties();
		pobj.load(fis);
		
		String BROWSER =pobj.getProperty("browser");
		String URL=pobj.getProperty("url");
		String USER=pobj.getProperty("username");
		String  PASS =pobj.getProperty("password");
		
		if(BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		else if(BROWSER.equals("firefox")) {
			driver= new FirefoxDriver();
		}
		else  {
			System.out.println("no browser found");
		}
		driver.get(URL);
		
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@name=\"user_name\"]")).sendKeys(USER);
		driver.findElement(By.xpath("//input[@name=\"user_password\"]")).sendKeys(PASS);
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.partialLinkText("Contacts")).click();
		
		driver.findElement(By.xpath("//img[@alt=\"Create Contact...\"]")).click();
		//date input
		
		//to fetch current default system date
		java.util.Date dateobj = new java.util.Date();
		//System.out.println(dateobj.toString());
		
		//to fetch the date format to our req
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
		String actdate =sim.format(dateobj);
		System.out.println(actdate);
		
		Calendar cal =sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH,-30);
		String  start =sim.format(cal.getTime());
		System.out.println(start);
		
		driver.findElement(By.name("support_start_date")).clear();
		driver.findElement(By.name("support_start_date")).sendKeys(start);
				
		Date dateobj1 = new Date();
		System.out.println(dateobj1.toString());
		SimpleDateFormat sim1= new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(sim1.format(dateobj1));
		
		Calendar cal1= sim1.getCalendar();
		cal1.add(Calendar.DAY_OF_MONTH,+30);
		String  r=sim.format(cal.getTime());
		System.out.println(r);
	
		
				
		driver.findElement(By.name("support_end_date")).clear();
		driver.findElement(By.name("support_end_date")).sendKeys(r);
		
		
		
		//String parent =driver.getWindowHandle();
		//System.out.println(parent);
		
		
		//driver.findElement(By.xpath("/html/body/table[4]/tbody/tr/td[2]/div/form/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr[5]/td[2]/img")).click();
		
		//Set<String> child = driver.getWindowHandles();
		//for (String abc : child) {
			//driver.switchTo().window(abc);
		
		//}
	
		FileInputStream fis1 = new FileInputStream("C:\\Users\\Bhuvanesh Ramesh\\Desktop\\Test case properties\\V tiger\\vtiger.xlsx");
		Workbook wb =WorkbookFactory.create(fis1);
		Sheet sh =wb.getSheet("sheet1");
		Row row =sh.getRow(0);
		Cell cel =row.getCell(0);
		String data1 =cel.getStringCellValue();
		
		driver.findElement(By.id("search_txt")).sendKeys(data1);
		
		//driver.findElement(By.xpath("//a[.='abiraami']")).click();
		//driver.findElement(By.xpath("//input[@type=\"button\"]")).click();
	    //Actions act=new Actions(driver);
	   
	
		 
		
		//driver.switchTo().window(parent);
		
	}

}
