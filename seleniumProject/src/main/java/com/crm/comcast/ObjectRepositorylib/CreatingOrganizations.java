package com.crm.comcast.ObjectRepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingOrganizations 
{
	public CreatingOrganizations(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name="accountname")
	private WebElement orgName;
	
	public WebElement getOrgName()
	{
		return orgName;
	}
	
	@FindBy(xpath="(//input[@name='button'])[1]")
	private WebElement save;
	
	public WebElement getSave()
	{
		return save;
	}

	
	@FindBy(className="dvHeaderText")
	private WebElement title;
	
	public WebElement getTitle()
	{
		return title;
	}
	
	@FindBy(name="industry")
	private WebElement industry;
	

	public WebElement getIndustry() {
		return industry;
	}
	
	@FindBy(name = "accounttype")
	private WebElement type;
	

	public WebElement getType() {
		return type;
	}

	public void createOrg(String name)
	{
		orgName.sendKeys(name);
	
	}
	
	public void createOrgwithIntype(String name,String Industry,String Type)
	{
		orgName.sendKeys(name);
		industry.sendKeys(Industry);
		type.sendKeys(Type);
		save.click();
		
	}

}
