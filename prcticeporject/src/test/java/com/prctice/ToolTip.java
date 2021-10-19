package com.prctice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ToolTip {
	@Test
	public void tool() throws Throwable
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.lenskart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 WebElement target = driver.findElement(By.xpath("//a[text()='Store Locator']"));
		Actions ac = new Actions(driver);
		ac.moveToElement(target).build().perform();
		
		
	}

}
