package com.crm.comcast.ContactTest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.comcast.ObjectRepositorylib.CreatingOrganizations;
import com.crm.comcast.ObjectRepositorylib.Home;
import com.crm.comcast.ObjectRepositorylib.Login;
import com.crm.comcast.ObjectRepositorylib.OrganizationInfo;
import com.crm.comcast.ObjectRepositorylib.Organizations;
import com.crm.comcast.generic.FileUtility;
import com.crm.comcast.generic.JavaUtility;
import com.crm.comcast.generic.ReadDataFromExcel;
import com.crm.comcast.generic.WebDriverUtility;

public class CreateOrgwithIndstryType
{
	static
	{
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	@Test
	public  void createOrgIndType() throws IOException
	{
		FileUtility fLib = new FileUtility();
		JavaUtility jLib = new JavaUtility();
		WebDriverUtility wLib = new WebDriverUtility();
		String Browser = fLib.getPropertykey("browser");
		String Url = fLib.getPropertykey("url");
		String Uname = fLib.getPropertykey("username");
		String Password = fLib.getPropertykey("password");
		
		int randomnum = jLib.getRandomNum(100);
		
		ReadDataFromExcel rLib = new ReadDataFromExcel();
		String Name = rLib.getExcelData("org",3,0)+"_"+randomnum;
		String Industry = rLib.getExcelData("org",2,2);
		String Type = rLib.getExcelData("org",2,1);
		
		
		WebDriver driver = null;
		
		if(Browser.equals("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(Browser.equals("FireFox"))
		{
			driver = new FirefoxDriver();
		}
		wLib.maximize(driver);
		driver.get(Url);
		
		wLib.implicitWait(driver,10);
		
		Login lpg = new Login(driver);
		lpg.LoginToApp(Uname, Password);
		
		Home hpg = new Home(driver);
		hpg.HomePage();
		
		Organizations opg = new Organizations(driver);
		opg.createOrg();
		
		CreatingOrganizations copg = new CreatingOrganizations(driver);
		copg.createOrg(Name);
		
		copg.createOrgwithIntype(Name,Industry,Type);
		
		OrganizationInfo oinfo = new OrganizationInfo(driver);
		String title = oinfo.getTitle().getText();
		if(title.contains(Name))
		{
			System.out.println("Organization created");
		}
		else
		{
			System.out.println("Organization not created");
		}
		String actualindustry = oinfo.getIndustrytb().getText();
		String actualtype = oinfo.getTypetb().getText();
		if(actualindustry.equals(Industry))
		{
			System.out.println("Industry is same");
		}
		else
		{
			System.out.println("Industry is not matching");
		}
		if(actualtype.equals(Type))	
		{
			System.out.println("type is matching");
		}
		else
		{
			System.out.println("type is not matching");
		}
		hpg.Logout(driver);
		
		
	}
}