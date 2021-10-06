package com.prctice;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MMT {
	
	public static void main(String args[])
	{
		
		Date dateRef = new Date();
		String CurrentDate = dateRef.toString();
		String[] Array = CurrentDate.split(" ");
		
		
	
		
		
		
		
		
		
		
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://www.makemytrip.com/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		Actions ac = new Actions(driver);
		ac.moveByOffset(10, 10).click().perform();
		driver.findElement(By.id("fromCity")).sendKeys("bom");
		driver.findElement(By.xpath("//div[text()='BOM']")).click();
		driver.findElement(By.xpath("//input[@class='react-autosuggest__input react-autosuggest__input--open']")).sendKeys("ban");
		driver.findElement(By.xpath("//div[text()='BLR']")).click();
		driver.findElement(By.xpath("//span[text()='DEPARTURE']")).click();
		driver.findElement(By.xpath("//div[@aria-label=\"Tue Oct 05 2021\"]")).click();
		
	}
	

}
