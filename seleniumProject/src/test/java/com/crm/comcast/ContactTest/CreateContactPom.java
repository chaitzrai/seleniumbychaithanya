package com.crm.comcast.ContactTest;

import java.io.IOException;

import org.testng.annotations.Test;

import com.crm.comcast.ObjectRepositorylib.Contacts;
import com.crm.comcast.ObjectRepositorylib.CreatingContacts;
import com.crm.comcast.ObjectRepositorylib.Home;
import com.crm.comcast.generic.BaseClase;
import com.crm.comcast.generic.ReadDataFromExcel;

public class CreateContactPom extends BaseClase
{
	static
	{
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	@Test
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

}
