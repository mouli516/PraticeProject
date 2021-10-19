package com.prctice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Qspiders {
	
	
	public static void main(String args[])
	{
		
        ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://www.google.com/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.name("q")).sendKeys("qspiders");
		List<WebElement> NoOfOptions = driver.findElements(By.xpath("//ul/li/div/div/div/span"));
		
		for(int i=0;i<=NoOfOptions.size()-1;i++)
		{
			String AllOptions = NoOfOptions.get(i).getText();
			System.out.println(AllOptions);
		}
		
	}


}
