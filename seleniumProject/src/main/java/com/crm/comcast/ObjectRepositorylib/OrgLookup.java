package com.crm.comcast.ObjectRepositorylib;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.generic.WebDriverUtility;

public class OrgLookup extends WebDriverUtility
{
		
    WebDriver driver;
	public OrgLookup(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	
	@FindBy(id="search_txt")
	private WebElement searchorg;

	public WebElement getSearchorg() {
		return searchorg;
	}
	
	public void searchOrg(String name)
	{
		searchorg.sendKeys(name);
	}
	
	@FindBy(xpath="//input[@name='search']")
	private WebElement searchbutton;

	public WebElement getSearchbutton()
	{
		return searchbutton;
	}
	
		
    public void getorgname(String orgName)
    {
    	
    	WebDriverUtility wLib = new WebDriverUtility();
    	wLib.switchToWindow(driver,"Accounts&action");
    	searchorg.sendKeys(orgName);
    	searchbutton.click();
    	/*wLib.implicitWait(driver,10);
    	WebElement na = driver.findElement(By.xpath("//a[.='"+orgName+"']"));
    	na.click();*/
    }
    	
    }
	
	/*@FindBy(xpath="//a[.='"+n+"']")
	private WebElement orgname;*/

