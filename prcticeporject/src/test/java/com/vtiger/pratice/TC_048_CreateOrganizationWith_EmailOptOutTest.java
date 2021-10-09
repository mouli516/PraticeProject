
package com.vtiger.pratice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.prctice.ReadDataFromExternal;

public class TC_048_CreateOrganizationWith_EmailOptOutTest {
	
	
	WebDriver driver;
	@Test
	public void TC_048_CreateOrganizationWith_EmailOptOut() throws Throwable
	{
		// step:1 navigate to url
		String browser = ReadDataFromExternal.ReadPropoertiesData("browser");
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

		// Step:2 Login to application
		driver.findElement(By.name("user_name")).sendKeys(ReadDataFromExternal.ReadPropoertiesData("username"));
		driver.findElement(By.name("user_password")).sendKeys(ReadDataFromExternal.ReadPropoertiesData("password"));
		driver.findElement(By.id("submitButton")).click();

		// Step:3 Click on Organization Link
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();

		// Step:4 Click on + Button
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();

		// Step:5 Select organization name and Email out Out Check box
		int number = ReadDataFromExternal.RandomNumber();
		driver.findElement(By.name("accountname")).sendKeys("Qspiders_Hyderabad" + number);
		WebElement EmailCheckBox = driver.findElement(By.xpath("//input[@name='emailoptout']"));
		EmailCheckBox.click();
		if (EmailCheckBox.isSelected()) {
			System.out.println("Email check box is selected");
		}

		// Step:8 Click on Save button
		driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
	}

}
