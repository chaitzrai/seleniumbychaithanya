package com.crm.comcast.ObjectRepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingContacts
{
	public CreatingContacts(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name="lastname")
	private WebElement contactname;

	public WebElement getContactname() {
		return contactname;
	}
	
	public void contactName(String name)
	{
		contactname.sendKeys(name);
	}
    
	@FindBy(xpath="//input[@name='account_name']/following-sibling::img")
	private WebElement orglookup;

	public WebElement getOrglookup() {
		return orglookup;
	}
	
	@FindBy(xpath="//input[@class='crmButton small save']")
	private WebElement savebutton;
	
	
	
	public WebElement getSavebutton() {
		return savebutton;
	}

	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement title;

	public WebElement getTitle() {
		return title;
	}
	
	
	

}
