package com.crm.comcast.ContactTest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.comcast.ObjectRepositorylib.CreatingOrganizations;
import com.crm.comcast.ObjectRepositorylib.Home;
import com.crm.comcast.ObjectRepositorylib.Login;
import com.crm.comcast.ObjectRepositorylib.Organizations;
import com.crm.comcast.generic.FileUtility;
import com.crm.comcast.generic.JavaUtility;
import com.crm.comcast.generic.ReadDataFromExcel;
import com.crm.comcast.generic.WebDriverUtility;

public class CreateOrganizationPomTest 
{
	static
	{
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}

@Test
	public  void createOrg() throws IOException, InterruptedException
	{
		FileUtility fLib = new FileUtility();
		WebDriverUtility wLib = new WebDriverUtility();
		JavaUtility jLib = new JavaUtility();
		String Browser = fLib.getPropertykey("browser");
		String Url = fLib.getPropertykey("url");
		String Username = fLib.getPropertykey("username");
		String Password = fLib.getPropertykey("password");
		
		int randomnum = jLib.getRandomNum(100);
		
		ReadDataFromExcel r = new ReadDataFromExcel();
	 String Name = r.getExcelData("org",3,0)+"_"+randomnum;
		
		
		WebDriver driver = null;
		if(Browser.equals("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(Browser.equals("firefox"))
		{
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.get(Url);
		Login l = new Login(driver);
		l.LoginToApp(Username,Password);
		/*l.getUsername().sendKeys(Username);
		l.getPassword().sendKeys(Password);
		l.getLoginbuttn().click();*/
		
		wLib.implicitWait(driver,10);
		
		Home hpg = new Home(driver);
		hpg.HomePage();
		
		Organizations opg = new Organizations(driver);
		opg.getCreateorg().click();
		
		CreatingOrganizations crtorg = new CreatingOrganizations(driver);
		crtorg.createOrg(Name);;
		
		crtorg.getSave().click();
		
		/*OrganizationInfo inf = new OrganizationInfo(driver);*///can be written in creatingorganizaton or separatly
		String txt = crtorg.getTitle().getText();
		if(txt.contains(Name))
		{
			System.out.println("organization created");
		}
		else
		{
			System.out.println("not created");
		}
		hpg.Logout(driver);
	}
}
