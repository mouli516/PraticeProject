package com.vtiger.Contracts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.prctice.ReadDataFromExternal;
public class TC_02_CreateContactsTest {
	public WebDriver driver;
	@Test
	public void CreateContact() throws Throwable
	{
		String browser = ReadDataFromExternal.ReadPropoertiesData("bowser");
		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
			driver.get(ReadDataFromExternal.ReadPropoertiesData("url"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
			driver.get(ReadDataFromExternal.ReadPropoertiesData("url"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		} else {
			System.out.println("Please enter correct browser name");
		}
		
		//Step:2 Login to application
		driver.findElement(By.name("user_name")).sendKeys(ReadDataFromExternal.ReadPropoertiesData("username"));
		driver.findElement(By.name("user_password")).sendKeys(ReadDataFromExternal.ReadPropoertiesData("password"));
		driver.findElement(By.id("submitButton")).click();
				
		//Step:3 Click on contracts tab
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		//Step:4 Click on + button 
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		
		//Step:5 fill the contract form with first name and last name
		driver.findElement(By.name("lastname")).sendKeys(ReadDataFromExternal.ReadExcelData("Contracts", 0, 1));
		driver.findElement(By.name("firstname")).sendKeys(ReadDataFromExternal.ReadExcelData("Contracts", 1, 1));
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	}

}
