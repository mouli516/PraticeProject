package com.vtiger.pratice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.prctice.ReadDataFromExternal;

public class TC_079_DeleteOrganizationFrom_OrganizationList_Test {
	
	
	WebDriver driver;
	@Test
	public void TC_079_DeleteOrganizationFrom_OrganizationList() throws Throwable
	{
		
		
		String browser = ReadDataFromExternal.ReadPropoertiesData("browser");
		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
			driver.get(ReadDataFromExternal.ReadPropoertiesData("url"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
			driver.get(ReadDataFromExternal.ReadPropoertiesData("url"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		else 
		{
			System.out.println("Please enter correct browser name");
		}
		
		// Step:2 Login to application
		driver.findElement(By.name("user_name")).sendKeys(ReadDataFromExternal.ReadPropoertiesData("username"));
		driver.findElement(By.name("user_password")).sendKeys(ReadDataFromExternal.ReadPropoertiesData("password"));
		driver.findElement(By.id("submitButton")).click();
		
		// Step:3 Click on Organization Link
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		
		//Step:4 Select organization from  the list and delete
		driver.findElement(By.xpath("//span[@type='vtlib_metainfo']/preceding-sibling::a[text()='Qspiders_Hyderabad34']")).click();
		driver.findElement(By.xpath("//input[@name='Delete']")).click();
		Alert AlertPopUp = driver.switchTo().alert();
		AlertPopUp.accept();
	}
	


}
