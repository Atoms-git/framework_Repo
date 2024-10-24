package utilFiles;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excelutil {

		//fetch data from excel
		public String getDataFromExcel(String sheetName , int rownum ,int celNum ) throws EncryptedDocumentException, IOException {
			
			FileInputStream fis = new FileInputStream("./testscriptdata/VtigerTC.xlsx");
			 Workbook wb = WorkbookFactory.create(fis);
			Sheet sh =wb.getSheet(sheetName);
			Row row =sh.getRow(rownum);
			Cell cel =row.getCell(celNum);
			String data =cel.getStringCellValue();
			wb.close();
			
			return data ;	
		}
		
		public int getRowCount(String sheetName) throws IOException {
			FileInputStream fis  =new FileInputStream("./testscriptdata/VtigerTC.xlsx");
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh =wb.getSheet(sheetName);
			int rowcount = sh.getLastRowNum();
			wb.close();
		
			return rowcount;
			}
}
