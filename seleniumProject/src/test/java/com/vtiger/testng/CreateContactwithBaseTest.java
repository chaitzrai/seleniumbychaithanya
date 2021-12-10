package com.vtiger.testng;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.crm.comcast.ObjectRepositorylib.Contacts;
import com.crm.comcast.ObjectRepositorylib.CreatingContacts;
import com.crm.comcast.ObjectRepositorylib.CreatingOrganizations;
import com.crm.comcast.ObjectRepositorylib.Home;
import com.crm.comcast.ObjectRepositorylib.OrgLookup;
import com.crm.comcast.ObjectRepositorylib.Organizations;
import com.crm.comcast.generic.BaseClase;
import com.crm.comcast.generic.JavaUtility;
import com.crm.comcast.generic.ReadDataFromExcel;

public class CreateContactwithBaseTest extends BaseClase
{
	static
	{
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	
	@Test(groups="ST")
	public void createContact() throws IOException
	{
		
		
		int randomnum = jLib.getRandomNum(100);
		
		ReadDataFromExcel r = new ReadDataFromExcel();
		String conname = r.getExcelData("contact",1,0)+"_"+randomnum;
		
		wLib.maximize(driver);
				
		Home hpg = new Home(driver);
		hpg.getContact().click();
		
		Contacts cpg = new Contacts(driver);
		cpg.getCreatecontact().click();
		
		CreatingContacts crtcontact = new CreatingContacts(driver);
		crtcontact.contactName(conname);
	
	}
	
	@Test
	public void createorgandContact() throws EncryptedDocumentException, IOException
	{
		
		JavaUtility jLib = new JavaUtility();
		int randomnum = jLib.getRandomNum(100);
		
		wLib.implicitWait(driver,20);
		
		ReadDataFromExcel r = new ReadDataFromExcel();
		String Name = r.getExcelData("org",3,0)+"_"+randomnum;
		String conName = r.getExcelData("contact",1,0)+"_"+randomnum;
		
		Home hpg = new Home(driver);
		hpg.HomePage();
		
		Organizations opg = new Organizations(driver);
		opg.createOrg();
		
		CreatingOrganizations copg = new CreatingOrganizations(driver);
		copg.createOrg(Name);
		
		copg.getSave().click();
		
		String title = copg.getTitle().getText();
		
		if(title.contains(Name))
		{
			System.out.println("organization created");
		}
		else
		{
			System.out.println("organization not created");
		}
		
		hpg.getContact().click();
		
		Contacts conpg = new Contacts(driver);
		conpg.getCreatecontact().click();
		
		CreatingContacts crtcon = new CreatingContacts(driver);
		crtcon.contactName(conName);
		
		crtcon.getOrglookup().click();
		
		wLib.switchToWindow(driver, "Accounts&action");
		
		OrgLookup olookup = new OrgLookup(driver);
		olookup.searchOrg(Name);
		
		olookup.getSearchbutton().click();
		//olookup.getorgname(Name);
		/*OrgLookup olookup = new OrgLookup(driver);
        olookup.getorgname(Name);*/
		driver.findElement(By.xpath("//a[.='"+Name+"']")).click();
		wLib.switchToWindow(driver,"Contacts&action");
		
		crtcon.getSavebutton().click();
		
		String txt = crtcon.getTitle().getText();
		if(txt.contains(conName))
		{
			System.out.println("Contacts Created");
		}
		else
		{
			System.out.println("not created");
		}	
		
	}



}
