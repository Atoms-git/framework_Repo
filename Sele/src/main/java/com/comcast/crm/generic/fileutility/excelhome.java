package com.comcast.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class excelhome {

	
		public String getDataFromExcel(String sheetname, int rownum, int cellnum ) throws Throwable {
			
			FileInputStream fis1 = new FileInputStream("./testscriptdata/vtigertestdata.xlsx");
			 Workbook wb =WorkbookFactory.create(fis1);
			 Sheet sh =wb.getSheet("Sheet1");
			 Row row =sh.getRow(1);
			 Cell cel =row.getCell(0);
			 String orgdata =cel.getStringCellValue();
			 return orgdata;
		}
			 
		 public String getDataFromExcel1(String sheetname, int rownum,int cellnum )throws Throwable {
			 FileInputStream fis1 = new FileInputStream("./testscriptdata/vtigertestdata.xlsx");
			 Workbook wb =WorkbookFactory.create(fis1);
			 Sheet sh1 =wb.getSheet("Sheet1");
			 Row row1 =sh1.getRow(1);
			 Cell cel1 = row1.getCell(1);
			 String phonedata= cel1.getStringCellValue().toString();
			wb.close();
			return phonedata;
			}
		 
		 public String getDataFromExcel2(String sheetname, int rownum,int cellnum )throws Throwable {
			 FileInputStream fis1 = new FileInputStream("./testscriptdata/vtigertestdata.xlsx");
			 Workbook wb =WorkbookFactory.create(fis1);
			 Sheet sh2 =wb.getSheet("Sheet1");
			Row row2 = sh2.getRow(4);
			 Cell cel2 =row2.getCell(0);
			 String lastnamedata =cel2.getStringCellValue();
			 return lastnamedata;
			 
		 }
			
			
			
		}
	
		

		
