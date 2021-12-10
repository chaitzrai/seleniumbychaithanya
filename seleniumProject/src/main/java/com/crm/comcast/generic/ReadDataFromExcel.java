package com.crm.comcast.generic;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcel 
{
	public String getExcelData(String sheetName,int row,int cell) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream("C:\\Users\\dell-pc\\eclipse-workspace\\seleniumProject\\data\\New.xlsx");
		String data = WorkbookFactory.create(fis).getSheet(sheetName).getRow(row).getCell(cell).getStringCellValue();
		return data;
	}

}
