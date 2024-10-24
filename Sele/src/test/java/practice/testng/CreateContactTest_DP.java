package practice.testng;

import org.openqa.selenium.chrome.AddHasCasting;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateContactTest_DP{
	
	@Test(dataProvider = "getData")
	public void createcontacttest(String firstName, String lastName,long PhoneNumber) {
		System.out.println(firstName +","+ lastName+","+ PhoneNumber);
	}

	@DataProvider
	public Object[][] getData() {
		Object[][] objArr = new Object[3][3];
		objArr[0][0]="deepak";
		objArr[0][1]="hr";
		objArr[0][2]=9999999999l;
		
		objArr[1][0]="sam";
		objArr[1][1]="sh";
		objArr[1][2]=8888888888l;
		
		objArr[2][0]="Jhon";
		objArr[2][1]="smith";
		objArr[2][2]=7777777777l;
		
		return objArr;
	}
}
