package com.vtiger.Contracts;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TC_03_CreateContractWithOrganizationTest {
	@Test
	public void CreateContractWithOrganization()
	{
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		//step:1 navigate to url
		driver.get("http://localhost:8888");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Step:2 Login to application
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("12345");
		driver.findElement(By.id("submitButton")).click();
				
		//Step:3 Click on contracts tab
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		//Step:4 Click on + button 
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		
		//Step:5 fill the contract form with first name and last name
		driver.findElement(By.name("lastname")).sendKeys("nadipena");
		driver.findElement(By.name("firstname")).sendKeys("Mouli");
		
		//Step:6 Select Organization from existing
		driver.findElement(By.xpath("//td[text()='Organization Name 			']/following-sibling::td/descendant::img")).click();
		String MainWindow = driver.getWindowHandle();
		Set<String> AllWindows = driver.getWindowHandles();
		for(String currentWindow:AllWindows)
		{
			String ActualTitle = driver.switchTo().window(currentWindow).getTitle();
			if("".equals(ActualTitle))
			{
				driver.findElement(By.xpath("//a[text()='Qspiders_Hyderabad']")).click();
			}
		}
		driver.switchTo().window(MainWindow);
		
		//Step:7 click on save button
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	}

}
