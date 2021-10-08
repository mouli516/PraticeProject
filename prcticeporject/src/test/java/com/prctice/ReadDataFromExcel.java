package com.prctice;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcel {
	
	public static void Excel() throws Throwable
	{
		FileInputStream fis = new FileInputStream("./data.xlsx");
		Workbook wb= WorkbookFactory.create(fis);
		String excelvalue = wb.getSheet("Sheet1").getRow(0).getCell(0).toString();
		System.out.println(excelvalue);
	}
	
	public static void Propoerties() throws Throwable
	{
		FileInputStream fis = new FileInputStream("./input.properties");
		Properties pro = new Properties();
		pro.load(fis);
		String propvalue = pro.getProperty("name","incorret key");
		System.out.println(propvalue);
		
	}
	public static int RandomNumber()
	{
		Random r = new Random();
		int Randomnumber = r.nextInt(100);
		return Randomnumber;
	}
	
	public static void main(String args[]) throws Throwable
	{
		ReadDataFromExcel.Excel();
		ReadDataFromExcel.Propoerties();
		
	}
		
}
