package com.crm.comcast.Organization;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

import com.crm.comcast.generic.ReadDataFromExcel;
public class samplexml 
{
	static
	{
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
	}
    @Test
	public void xmlex(XmlTest xml)throws IOException
	{
		//FileInputStream fis = new FileInputStream("./data/New.xlsx");
		//Workbook wb = WorkbookFactory.create(fis);
		//String Browser = wb.getSheet("Sheet1").getRow(1).getCell(0).getStringCellValue();
		//String Url = wb.getSheet("Sheet1").getRow(1).getCell(1).getStringCellValue();
		//String Username = wb.getSheet("Sheet1").getRow(1).getCell(2).getStringCellValue();
		//String Password = wb.getSheet("Sheet1").getRow(1).getCell(3).getStringCellValue();
		//String Name = wb.getSheet("Sheet2").getRow(3).getCell(0).getStringCellValue();
		//FileInputStream fis = new FileInputStream("./data/commondata.txt");
		//Properties pobj = new Properties();
		//pobj.load(fis);
		String Browser = xml.getParameter("browser");
		String Url = xml.getParameter("url");
		String Username = xml.getParameter("username");
		String Password = xml.getParameter("password");
		
        Random random = new Random();
        int  randomnum = random.nextInt(100);
       
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
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(Url);
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(Username);
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(Password);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(Name);
        driver.findElement(By.xpath("(//input[@name='button'])[1]")).click();
        String na = driver.findElement(By.className("dvHeaderText")).getText();
        if(na.contains(Name))
        {
        	System.out.println(Name +"  Organization is created");
        }
        else
        {
        	System.out.println("organization is not created");
        }
        WebElement e = driver.findElement(By.xpath("//img[@style='padding: 0px;padding-left:5px']"));
        Actions a = new Actions(driver);
        a.moveToElement(e).perform();
        driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
        driver.close();
	}

}


