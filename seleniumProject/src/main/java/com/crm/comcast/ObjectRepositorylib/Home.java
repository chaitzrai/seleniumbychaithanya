package com.crm.comcast.ObjectRepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.generic.WebDriverUtility;

public class Home 
{
	public Home(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(linkText="Organizations")
	private WebElement organization;
	
	@FindBy(xpath="//img[@style='padding: 0px;padding-left:5px']")
	private WebElement logout;

	
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement signout;
	
	@FindBy(linkText="Contacts")
	private WebElement contact;
	
	
	public WebElement getContact() {
		return contact;
	}


	public WebElement getSignout() {
		return signout;
	}



	public WebElement getLogout() {
		return logout;
	}



	public void HomePage()
	{
		organization.click();
	}
	
	public void Logout(WebDriver driver) 
	{
		WebDriverUtility wLib = new WebDriverUtility();
		wLib.mouseOver(driver, logout);
		signout.click();			
		
	}


}
