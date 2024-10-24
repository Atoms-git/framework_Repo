package PractiveDataDriventesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Newp {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		WebDriver driver= null;
		FileInputStream fis = new FileInputStream("C:\\Users\\Bhuvanesh Ramesh\\Desktop\\SCM_bakery.properties");
		Properties pobj= new Properties();
		pobj.load(fis);
		
		String BROWSER= pobj.getProperty("browser");
		
		if(BROWSER.equals("chrome")) {
			 driver = new ChromeDriver();
		} 
		else if(BROWSER.equals("firefox")) {
			 driver = new FirefoxDriver();
		}
		else {
			System.out.println("na");
		}
		
	}

}
