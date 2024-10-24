package PractiveDataDriventesting;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadMultipleDataFromExcel2 {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("C:\\Users\\Bhuvanesh Ramesh\\Desktop\\testscriptdata.xlsx");
		Workbook wb =WorkbookFactory.create(fis);
			Sheet sh=wb.getSheet("Multi");
			
			int rc=sh.getLastRowNum();
			
			for(int i=1; i<=rc; i++) {
			Row rw=sh.getRow(i);
			Cell cel1=rw.getCell(0);
			Cell cel=rw.getCell(1);
			//String data=cel.getStringCellValue();
			System.out.println(cel1 +" : "+ cel);

	}
	}
}