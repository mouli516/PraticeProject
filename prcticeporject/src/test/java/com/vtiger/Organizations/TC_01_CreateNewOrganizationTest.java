package com.vtiger.Organizations;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.prctice.ReadDataFromExternal;

public class TC_01_CreateNewOrganizationTest {
	WebDriver driver;

	@Test
	public void CreateNewOrganization() throws Throwable {
		// step:1 navigate to url
		String browser = ReadDataFromExternal.ReadPropoertiesData("bowser");
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
		driver.findElement(By.name("user_password")).sendKeys(ReadDataFromExternal.ReadPropoertiesData("username"));
		driver.findElement(By.id("submitButton")).click();

		// Step:3 Click on Organization Link
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();

		// Step:4 Click on + Button
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();

		// Step:5 Fill the new Organization form with Name,rating and Type
		int number = ReadDataFromExternal.RandomNumber();
		driver.findElement(By.name("accountname")).sendKeys("Qspiders_Hyderabad" + number);
		WebElement AccountTypeDropDown = driver.findElement(By.name("accounttype"));
		WebElement IndustryTypeDropDown = driver.findElement(By.name("industry"));
		WebElement RatingDropDown = driver.findElement(By.name("rating"));

		// Step:6 Select Type of account from Account Drop Down
		Select AccountTypeDD = new Select(AccountTypeDropDown);
		AccountTypeDD.selectByValue("Other");

		// Step:7 Select Type of Industry from Industry drop down
		Select IndustryTypeDD = new Select(IndustryTypeDropDown);
		IndustryTypeDD.selectByValue("Education");

		// Step:8 Select Rating from rating drop down
		Select RatingDD = new Select(RatingDropDown);
		RatingDD.selectByValue("Active");

		// Step:8 Click on Save button
		driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
		Thread.sleep(3000);

		// Step:9 Click on Organization Link
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();

		// Step:10 Search the organization
		driver.findElement(By.name("search_text")).sendKeys("Qspiders_Hyderabad" + number);
		WebElement SearchFieldDropDown = driver.findElement(By.name("search_field"));
		Select SearchFieldDD = new Select(SearchFieldDropDown);
		SearchFieldDD.selectByValue("accountname");
		driver.findElement(By.name("submit")).click();

		// Step:11 Verify whether the Organization is created or not
		WebElement OrganizationName = driver.findElement(By.xpath("//a[@title='Organizations' and text()='Qspiders_Hyderabad']"));
		if (OrganizationName.isDisplayed()) {
			Assert.assertTrue(true);
			System.out.println("Organization created");
		}

	}

}
