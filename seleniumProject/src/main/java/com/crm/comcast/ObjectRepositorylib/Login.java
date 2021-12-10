package com.crm.comcast.ObjectRepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login 
{
	public Login(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(xpath="//input[@name='user_name']")
	private WebElement username; 
	
    @FindBy(xpath="//input[@name='user_password']")
    private WebElement password;
    
    @FindBy(id="submitButton")
    private WebElement loginbuttn;

	public WebElement getUsername() {
		return username;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLoginbuttn() {
		return loginbuttn;
	}
        
    public void LoginToApp(String Uname,String pwd)
    {
    	username.sendKeys(Uname);
    	password.sendKeys(pwd);
    	loginbuttn.click();
    }
  
    
    

}
