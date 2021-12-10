package com.crm.comcast.generic;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * 
 * @author chaithanya
 *
 */

public class WebDriverUtility 
{
	/**
	 * This method wait for specified duration for page loading
	 * @param driver
	 * @param duration 
	 */

	public Timeouts implicitWait(WebDriver driver,int duration)
	{
				
	    Timeouts wait = driver.manage().timeouts().implicitlyWait(duration,TimeUnit.SECONDS);
	    return 	wait;
	}
	
	/**
	 * This method wait foe element to be visible
	 * @param driver
	 * @param duration
	 * @param element
	 */
	public WebElement explicitWait(WebDriver driver,WebElement element,int duration)
	{
		WebDriverWait wait = new WebDriverWait(driver,duration);
	    WebElement rtr = wait.until(ExpectedConditions.visibilityOf(element));
	    return rtr;
		
	}
	
	/**
	 * This method is used to switch from one window to another
	 * @param driver
	 * @param partialtext
	 */
	public void switchToWindow(WebDriver driver,String partialtext)
	{
		
		Set<String> window = driver.getWindowHandles();
		Iterator<String> it = window.iterator();
		while(it.hasNext())
		{
			driver.switchTo().window(it.next());
			if(driver.getTitle().contains(partialtext))
			{
				break;
			}
		}
	}
	/**
	 * This method is used to move mouse pointer from one location to other
	 * @param driver
	 * @param location of the element where courser need to be moved
	 */

	public void mouseOver(WebDriver driver,WebElement element)
	{
		Actions a = new Actions(driver);
		a.moveToElement(element).perform();
	}
	
	/**
	 * This method is used to right click on the element 
	 * @param driver
	 * @param element
	 */
	public void rightClick(WebDriver driver,WebElement element)
	{
		Actions a = new Actions(driver);
		a.contextClick(element).perform();
	}
	
	/**
	 * This method is used to double click on the element
	 * @param driver
	 * @param element
	 */
	public void doubleClick(WebDriver driver,WebElement element)
	{
		Actions a = new Actions(driver);
		a.doubleClick(element).perform();
	}
	
	/**
	 * This method helps to handle the dropdown using index
	 * @param element
	 * @param index
	 */
	public void selectIndex(WebElement element,int index)
	{
		Select s = new Select(element);
		s.selectByIndex(index);
		
	}
	
	/**
	 * This method is used to handle the dropdowm using visible text
	 * @param element
	 * @param visible text
	 */
	public void selectVisibleText(WebElement element,String text)
	{
		Select s = new Select(element);
		s.selectByVisibleText(text);
	}
	
	/**
	 * This method is used to handle the dropdown by using value
	 * @param element
	 * @param value
	 */
	public void selectValue(WebElement element,String Value)
	{
		Select s= new Select(element);
		s.selectByValue(Value);
	}
	
	/**
	 * this method will maximize the window
	 */
	public void maximize(WebDriver driver)
	{
		 driver.manage().window().maximize();
		
	}
}