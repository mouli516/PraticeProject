package com.prctice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LensKart {
	
	public static void main(String args[])
	{
		
ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://www.lenskart.com/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.name("q")).click();
		List<WebElement> NoOfOptions = driver.findElements(By.xpath("//ul[@class='trending_list menu-link']/li"));
		
		for(int i=0;i<=NoOfOptions.size()-1;i++)
		{
			String AllOptions = NoOfOptions.get(i).getText();
			System.out.println(AllOptions);
		}
		
	}
	
	


}
