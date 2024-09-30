package com.comcast.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	public String getDataFromExcel(String sheetName,int rownum,int cellnum) throws EncryptedDocumentException, IOException
	{
	FileInputStream fis=new FileInputStream("./testdata/MultiRow.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	String data = wb.getSheet(sheetName).getRow(rownum).getCell(cellnum).getStringCellValue();
	wb.close();
	return data;
	}
	
	public int getlastRowNumber(String sheetName) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream("./testdata/MultiRow.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		int lastRowNum = wb.getSheet(sheetName).getLastRowNum();
		return lastRowNum;
	}
	public void setDataIntoExcel(String  sheetName,int rownum,int cellnum,String data) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream("./testdata/MultiRow.xlsx");
		Workbook wb= WorkbookFactory.create(fis);
		Cell cell = wb.getSheet(sheetName).getRow(rownum).createCell(cellnum);
		cell.setCellValue(data);
		FileOutputStream fos=new FileOutputStream("./testdata/MultiRow.xlsx");
		wb.write(fos);
		wb.close();
	}
}
