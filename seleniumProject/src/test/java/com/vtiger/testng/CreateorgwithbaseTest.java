package com.vtiger.testng;

import java.io.IOException;

import org.testng.annotations.Test;

import com.crm.comcast.ObjectRepositorylib.CreatingOrganizations;
import com.crm.comcast.ObjectRepositorylib.Home;
import com.crm.comcast.ObjectRepositorylib.OrganizationInfo;
import com.crm.comcast.ObjectRepositorylib.Organizations;
import com.crm.comcast.generic.BaseClase;
import com.crm.comcast.generic.JavaUtility;
import com.crm.comcast.generic.ReadDataFromExcel;

public class CreateorgwithbaseTest extends BaseClase
{
	static
	{
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	@Test(groups="ST")
	public  void createOrg() throws IOException, InterruptedException
	{
	
		JavaUtility jLib = new JavaUtility();
		
		
		int randomnum = jLib.getRandomNum(100);
		
		ReadDataFromExcel r = new ReadDataFromExcel();
	 String Name = r.getExcelData("org",3,0)+"_"+randomnum;
		
				
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
	}
	
	@Test
	public  void createOrgIndType() throws IOException
	{
	
		JavaUtility jLib = new JavaUtility();
				
		int randomnum = jLib.getRandomNum(100);
		
		ReadDataFromExcel rLib = new ReadDataFromExcel();
		String Name = rLib.getExcelData("org",3,0)+"_"+randomnum;
		String Industry = rLib.getExcelData("org",2,2);
		String Type = rLib.getExcelData("org",2,1);
		
		wLib.implicitWait(driver,10);
				
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
		
		
		
	}



}
