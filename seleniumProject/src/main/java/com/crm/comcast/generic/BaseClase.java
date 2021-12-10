package com.crm.comcast.generic;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.crm.comcast.ObjectRepositorylib.Home;
import com.crm.comcast.ObjectRepositorylib.Login;

public class BaseClase
{	
	public WebDriver driver;
	public FileUtility fLib = new FileUtility();
	public JavaUtility jLib = new JavaUtility();
	public DataBaseUtility db = new DataBaseUtility();
	public WebDriverUtility wLib = new WebDriverUtility();

	
	@BeforeSuite(groups= {"ST","RT"})
	public void configdb()
	{
		System.out.println("connect to database");
		db.connectDB();
				
	}
	@BeforeClass(groups= {"ST","RT"})
	public void configopenbrowser() throws IOException
	{
		String Browser = fLib.getPropertykey("browser");
		if(Browser.equals("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(Browser.equals("firefox"))
		{
			driver = new FirefoxDriver();
		}
		
	}
	
	@BeforeMethod(groups= {"ST","RT"})
	public void configlogin() throws IOException
	{
		wLib.maximize(driver);
	    String Url = fLib.getPropertykey("url");
	    driver.get(Url);
		String Uname = fLib.getPropertykey("username");
		String Password = fLib.getPropertykey("password");
		Login lpg = new Login(driver);
		lpg.LoginToApp(Uname,Password);
	}
	
	@AfterMethod(groups= {"ST","RT"})
	public void configlogout()
	{
		Home hpg = new Home(driver);
		hpg.Logout(driver);
	}
	
	@AfterClass(groups= {"ST","RT"})
	public void configclosebrowser()
	{
		driver.close();
	}
	
	@AfterSuite(groups= {"ST","RT"})
	public void configclosedb() throws SQLException
	{
		System.out.println("close the db connection");
		db.closeDB();
		
	}
	

}
