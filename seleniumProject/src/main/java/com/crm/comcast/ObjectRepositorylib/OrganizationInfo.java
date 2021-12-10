package com.crm.comcast.ObjectRepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfo
{
	public OrganizationInfo(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		
	}
	@FindBy(className="dvHeaderText")
	private WebElement title;
	
	public WebElement getTitle() {
		return title;
	}
	
	@FindBy(xpath="//td[@id='mouseArea_Industry']")
	private WebElement industrytb;

	public WebElement getIndustrytb() {
		return industrytb;
	}
	
	@FindBy(xpath="//td[@id='mouseArea_Type']")
	private WebElement typetb;

	public WebElement getTypetb() {
		return typetb;
	}
	
	
	
	

}
