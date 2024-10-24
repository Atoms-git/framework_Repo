package PractiveDataDriventesting;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class RDB {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		String data="";
		String expID="tc_101";
		String data1="";
		String data2="";
		String data3="";
		boolean flag=false;
		
		FileInputStream fis = new FileInputStream("C:\\Users\\Bhuvanesh Ramesh\\Desktop\\testscriptdata.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh =wb.getSheet("org");
		int rowcount = sh.getLastRowNum();
		
		for(int i=0; i<=rowcount;i++) {
			try {
			 data =sh.getRow(i).getCell(0).getStringCellValue();
			 if(data.equals(expID)) {
				 flag=true;
				 data1 =sh.getRow(i).getCell(1).getStringCellValue();
				 data2 =sh.getRow(i).getCell(2).getStringCellValue();
				 data3 =sh.getRow(i).getCell(3).getStringCellValue();
			}
		}catch (Exception e) {
				
			}	
	}
		if (flag==true) {
			System.out.println(data1 +" "+data2+" "+data3);
		}
		else {
			System.out.println(expID+ " Data is not available");
		}

}}
