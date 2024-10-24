package PractiveDataDriventesting;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataBasedOnConditon {
	

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		//String data1 ="";
		//String data2 ="";
		//String data3 ="";
		String expID="tc_07";
		boolean flag = false;
		
		FileInputStream fis = new FileInputStream("C:\\Users\\Bhuvanesh Ramesh\\Desktop\\testscriptdata.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh =wb.getSheet("org");
		int rowcount = sh.getLastRowNum();
		
		for(int i=0;i<=rowcount;i++) {
			//String data="";
			try {
			 String  data =sh.getRow(i).getCell(0).getStringCellValue();
			  if (data.equals(expID)) {
				  
				  flag =true;
				  String data1 =sh.getRow(i).getCell(1).getStringCellValue();
				  String data2 =sh.getRow(i).getCell(2).getStringCellValue();
				  String data3 =sh.getRow(i).getCell(3).getStringCellValue();
				  
				  System.out.println(data1);
				  System.out.println(data2);
				  System.out.println(data3);
			   {
				  System.out.println(expID +"data is not avaliable");
			  }
			  }
			}catch (Exception e) {
				 
			}
			
			
		}

	}

}
