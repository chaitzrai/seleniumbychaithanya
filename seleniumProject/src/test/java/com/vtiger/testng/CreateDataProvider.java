package com.vtiger.testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateDataProvider 
{
	
	@Test(dataProvider="dataProviderBookTicket")
	public void bookTicket(String src,String dest)
	{
		System.out.println("Boook tickets form"+src+"to"+dest);
	}
	
	@DataProvider
	public Object[][] dataProviderBookTicket()
	{
		Object[][] objArry = new Object[5][2];
		
		objArry[0][0] = "Banglore";
		objArry[0][1] = "Manglore";
		
		objArry[1][0] = "Banglore";
		objArry[1][1] = "Manglore";
		
		objArry[2][0] = "Banglore";
		objArry[2][1] = "Manglore";
		
		objArry[3][0] = "Banglore";
		objArry[3][1] = "Manglore";
		
		objArry[4][0] = "Banglore";
		objArry[4][1] = "Manglore";
		
		return objArry;
		
	}


}
