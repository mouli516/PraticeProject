package com.vtiger.GenericLibrary;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



/**
 * 
 * 
 * @author Mouli
 *
 */
public class WebDriverUtility 

{
	public static WebDriver driver;
	
	/**
	 * @author Mouli
	 * Thsi method user for implicitly Wait
	 */
	public void PageLoadTImeOut(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	/**
	 * @author Mouli
	 * this method Used to maximize the window
	 * @param webdriver driver
	 */
	public void MaximizeTheWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	/**
	 * @author Mouli
	 * this method wait until element visible
	 * @param webdriver
	 * @param Element
	 */
	public void WaitForVisibilityOfElement(WebDriver driver,WebElement element)
	{
		WebDriverWait webdriverwait = new WebDriverWait(driver, 20);
		webdriverwait.until(ExpectedConditions.visibilityOf(element));
		
	}
	/**
	 * This method will wait and click the element 
	 * @author Mouli
	 * @param driver
	 * @param element
	 */
	public void waitandclick(WebDriver driver, WebElement element)
	{
		WebDriverWait webdriverwait = new WebDriverWait(driver, 20);
		webdriverwait.until(ExpectedConditions.elementToBeClickable(element));

	}
	
	/**
	 * @author Mouli
	 * This method Used to Select the Dropdown Option 
	 * @param Element
	 * @param Type
	 * @param value
	 */
	public void SelectDropDownOption(WebElement Element,String Type,String value)
	{
		Select Sc = new Select(Element);
		switch(Type)
		{
		   case"index":
			   Sc.selectByIndex(Integer.parseInt(value));
			   break;
		   case"text":
			   Sc.selectByVisibleText(value);
			   break;
		   case"value":
			   Sc.selectByValue(value);
			   break;
		   default:
			   break;
			   
		}
	}
		
	/**
	 * This mtd is going to switch to frame based on Index no of frame
	 * @param driver
	 *  @author Mouli
	 * @param index
	 */
	public void SwitchFrameByindex(WebDriver driver,int index) 
	{
		driver.switchTo().frame(index);
	}

	/**
	 * This Method is used to switch to frame with webelement
	 *  @author Mouli
	 * @param driver
	 * @param element
	 */
	public void SwitchFrameByElement(WebDriver driver,WebElement element) 
	{
		driver.switchTo().frame(element);
	}
	/**
	 * This mtd is going to switch to frame based on nameOrId
	 *  @author Mouli 
	 * @param driver
	 * @param nameOrId
	 */

	public void sSwitchFrameByElement(WebDriver driver,String nameOrId ) 
	{
		driver.switchTo().frame(nameOrId);
	}
	/**
	 * this method is used to move the cursor to elemnet
	 *  @author Mouli
	 * @param driver
	 * @param element
	 */

	public void MoveToElement(WebDriver driver,WebElement element) 
	{
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
	}
	/**
	 * This method is USed to Right click on webelement
	 *  @author Mouli
	 * @param driver
	 * @param element
	 */
	public void RightClick(WebDriver driver,WebElement element) 
	{
		Actions action = new Actions(driver);
		action.contextClick(element);
	}
	
	
	/**
	 * this method is used to Handle the alert popup
	 *  @author Mouli
	 * @param driver
	 * @param Option
	 */
	public void HandleAlertPopUp(WebDriver driver,String Option)
	{
		Alert AlertPopUp = driver.switchTo().alert();
		switch(Option)
		{
		case"accepct":
			AlertPopUp.accept();
			break;
		case"dismiss":
			AlertPopUp.dismiss();
		}
	}
	/**
	 * @author Mouli
	 * This method will Switch the control to the required window
	 * @param driver
	 * @param TargetTitle
	 * @param element
	 */
	public void SwitchtoWindow(String TargetTitle,WebElement element)
	{
		String MainWindow = driver.getWindowHandle();
		Set<String> Allwindows = driver.getWindowHandles();
		for(String currentWindow:Allwindows)
		{
			String Title = driver.switchTo().window(currentWindow).getTitle();
			if (Title.equalsIgnoreCase(TargetTitle)) {
				
				element.click();
			}
			
		}
		driver.switchTo().window(MainWindow);
	}







}


	

			
		
		

	
	
	

