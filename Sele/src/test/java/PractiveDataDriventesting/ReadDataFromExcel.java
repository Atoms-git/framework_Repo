package PractiveDataDriventesting;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException  {
		// TODO Auto-generated method stub
		
		//step 1: get the excel path location & java object of the physical excel file
		FileInputStream fis = new FileInputStream("C:\\Users\\Bhuvanesh Ramesh\\Desktop\\testscriptdata.xlsx");
				
		//step 2: open the workbook in read mode
		Workbook wb = WorkbookFactory.create(fis);
		
		//step 3: get the control of the "org" sheet
		Sheet sh =  wb.getSheet("org");

		//step 4: get the control of the "1st" sheet
			Row	 row =sh.getRow(1);
		
		//step 5 : get the control of the "2st" row & read the string data
			Cell cel=row.getCell(3);
			String data = cel.getStringCellValue();
			System.out.println(data);
		
		//step 6 : close the workbook
			wb.close();
	}

}
