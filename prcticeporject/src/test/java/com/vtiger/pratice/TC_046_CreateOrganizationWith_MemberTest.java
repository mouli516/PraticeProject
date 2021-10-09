package com.vtiger.pratice;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.prctice.ReadDataFromExternal;

public class TC_046_CreateOrganizationWith_MemberTest {
	WebDriver driver;
	@Test
	public void TC_046_CreateOrganizationWith_Member() throws Throwable
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
		
		// Step:4 Click on + Button
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		//Step:5 Create Organization with member and mandatory fields
		
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(ReadDataFromExternal.ReadExcelData("Organization", 0, 1)+ReadDataFromExternal.RandomNumber());
		driver.findElement(By.xpath("//img[@title='Select']")).click();
		String MainWindow = driver.getWindowHandle();
		Set<String> Allwindows = driver.getWindowHandles();
		for(String CurrentWindow:Allwindows)
		{
			String WindowTitle = driver.switchTo().window(CurrentWindow).getTitle();
		    if(WindowTitle.equals(""))
		    {
		    	driver.findElement(By.xpath("//a[text()='mouli']")).click();
		    	Alert alertpopup = driver.switchTo().alert();
		    	alertpopup.accept();
		    }
		}
		driver.switchTo().window(MainWindow);
		
		//Step:6 Click On save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	}

}
