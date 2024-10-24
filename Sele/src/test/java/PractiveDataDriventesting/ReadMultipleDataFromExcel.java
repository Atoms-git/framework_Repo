package PractiveDataDriventesting;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadMultipleDataFromExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		//step 1: get the excel path location & java object of the physical excel file
				FileInputStream fis = new FileInputStream("C:\\Users\\Bhuvanesh Ramesh\\Desktop\\testscriptdata.xlsx");
						
				//step 2: open the workbook in read mode
				Workbook wb = WorkbookFactory.create(fis);
				
				//step 3: get the control of the "org" sheet
				Sheet sh =  wb.getSheet("Multi");
	
					for (int i = 1; i < 50; i++) {
						Row row = sh.getRow(i);
						Cell data1 = row.getCell(0);
						Cell data=row.getCell(1);
						
						System.out.println(data1 +" : "+data);
					}
				wb.close();
				
	}
	}

