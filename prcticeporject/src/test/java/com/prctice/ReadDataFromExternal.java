package com.prctice;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExternal {
	
	public static String ReadExcelData(String Sheetname,int row,int cell) throws Throwable
	{
		FileInputStream fis = new FileInputStream("./data.xlsx");
		Workbook wb= WorkbookFactory.create(fis);
		String excelvalue = wb.getSheet(Sheetname).getRow(row).getCell(cell).toString();
		return excelvalue;
	}
	
	public static String ReadPropoertiesData(String key) throws Throwable
	{
		FileInputStream fis = new FileInputStream("./input.properties");
		Properties pro = new Properties();
		pro.load(fis);
		String propvalue = pro.getProperty(key,"incorret key");
		return propvalue;
		
	}
	public static int RandomNumber()
	{
		Random r = new Random();
		int Randomnumber = r.nextInt(1000);
		return Randomnumber;
	}
	
	
		
}
