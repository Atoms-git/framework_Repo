package com.comcast.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	//fetch data from excel
	public String getDataFromExcel(String sheetName , int rownum ,int celNum ) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis = new FileInputStream("./testscriptdata/vtiger.xls");
		 Workbook wb = WorkbookFactory.create(fis);
		Sheet sh =wb.getSheet("sheet1");
		Row row =sh.getRow(rownum);
		Cell cel =row.getCell(celNum);
		String data =cel.getStringCellValue();
		wb.close();
		
		return data ;	
	}
	//get last row count
	public int getRowCount(String sheetName) throws IOException {
		FileInputStream fis  =new FileInputStream("./testscriptdata/vtiger.xls");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh =wb.getSheet("sheet1");
		int rowcount = sh.getLastRowNum();
		wb.close();
	
		return rowcount;
		}
	
	//write data into excel
	public void setDataIntoExcel(String sheetname , int rownum , int cellnum , String name) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./testscriptdata/vtiger.xls");
		Workbook wb =WorkbookFactory.create(fis);
		Sheet sh =wb.getSheet("sheet1");
		Row row =sh.getRow(0);
		Cell cel=row.createCell(2);
		cel.setCellValue(name);
		
		
		FileOutputStream fos = new FileOutputStream("./testscriptdata/vtiger.xls");
		wb.write(fos);
		wb.close();
	}
	public String getDataFromExcel1(String sheetName , int rownum ,int celNum ) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis = new FileInputStream("./testscriptdata/vtiger.xls");
		 Workbook wb = WorkbookFactory.create(fis);
		Sheet sh =wb.getSheet("sheet1");
		Row row =sh.getRow(rownum);
		Cell cel =row.getCell(celNum);
		String data1 =cel.getStringCellValue();
		wb.close();	
		
		return data1 ;	
	
	}
	
	public String getDataFromExcel2(String sheetName , int rownum ,int celNum ) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis = new FileInputStream("./testscriptdata/vtiger.xls");
		 Workbook wb = WorkbookFactory.create(fis);
		Sheet sh =wb.getSheet("sheet1");
		Row row =sh.getRow(rownum);
		Cell cel =row.getCell(celNum);
		String data2 =cel.getStringCellValue();
		wb.close();	
		
		return data2 ;	
	
	}
	
	
	
	
	}
	
	
	
	

