package com.vtiger.pratice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.prctice.ReadDataFromExternal;

public class TC_053_CreateOrganization_RatingDD_VerifyTest {
	
	
	WebDriver driver;
	@Test
	public void TC_053_CreateOrganization_RatingDD_Verify() throws Throwable
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
		
		//Step:5 verifying Industry dropdown
		WebElement RatingDropDown = driver.findElement(By.name("rating"));
		RatingDropDown.click();
		Select select = new Select(RatingDropDown);
		
		if(RatingDropDown.isEnabled())
		{
			Assert.assertTrue(true);
			Reporter.log("Rating Dropdown is Enabled",true);
		}
		List<WebElement> RatingDDoptions = select.getOptions();
		for(int i=0;i<=RatingDDoptions.size()-1;i++)
		{
			System.out.println(RatingDDoptions.get(i).getText());
		}
	}
	

}
