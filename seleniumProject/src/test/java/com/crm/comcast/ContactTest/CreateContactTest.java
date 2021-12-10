package com.crm.comcast.ContactTest;

import java.io.IOException;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.comcast.generic.FileUtility;
import com.crm.comcast.generic.JavaUtility;
import com.crm.comcast.generic.ReadDataFromExcel;
import com.crm.comcast.generic.WebDriverUtility;

public class CreateContactTest 
{
	
	
	static
	{
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	@Test
	public void createContact() throws IOException
	{
	
		FileUtility f = new FileUtility();
		WebDriverUtility wLib = new WebDriverUtility();
		JavaUtility jLib = new JavaUtility(); 
		String Browser = f.getPropertykey("browser");
		String Url = f.getPropertykey("url");
		String Username = f.getPropertykey("username");
		String Password = f.getPropertykey("password");
		
		
		/*Random random = new Random();
		int randumnum = random.nextInt(100);*/
		int randumnum = jLib.getRandomNum(100);
		
		ReadDataFromExcel r = new ReadDataFromExcel();
		String Name = r.getExcelData("org",3,0)+"_"+randumnum;
		String Contactname = r.getExcelData("contact",1,0)+"_"+randumnum;
		
		WebDriver driver = null;
		if(Browser.equals("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(Browser.equals("firefox"))
		{
			driver = new FirefoxDriver();
		}
		driver.get(Url);
		wLib.implicitWait(driver,10);
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(Username);
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(Password);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(Name);
		driver.findElement(By.xpath("(//input[@name='button'])[1]")).click();
		String text = driver.findElement(By.className("dvHeaderText")).getText();
		if(text.contains(Name))
		{
			System.out.println(Name +"  Organization is created");
			System.out.println(Name);
		}
		else
		{
			System.out.println(Name +"  Organization is not created");
			
		}
		WebElement element = driver.findElement(By.linkText("Contacts"));
		wLib.explicitWait(driver, element, 10);
		//WebDriverWait wait = new WebDriverWait(driver,10);
		//wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.linkText("Contacts")));
		
		element.click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		driver.findElement(By.name("lastname")).sendKeys(Contactname);
		driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();
		/*Set<String> set = driver.getWindowHandles();
		Iterator<String> itr = set.iterator();
		String parentid = driver.getWindowHandle();
	    while(itr.hasNext())
	    {
	    	driver.switchTo().window(itr.next());
	    	if(driver.getTitle().contains("Accounts&action")) {
	    	break;
	    }
	    }*/
		
		wLib.switchToWindow(driver,"Accounts&action");
	    driver.findElement(By.id("search_txt")).sendKeys(Name);
	    driver.findElement(By.xpath("//input[@name='search']")).click();
	    driver.findElement(By.xpath("//a[.='"+Name+"']")).click();
	    //driver.switchTo().window(parentid);
	    
	    wLib.switchToWindow(driver,"Contacts&action");
	    
	    driver.findElement(By.xpath("//input[@class='crmButton small save']")).click();
	    String title = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	    if(title.contains(Contactname))
	    {
	    	System.out.println("contact created");
	    }
	    else
	    {
	    	System.out.println("contact not created");
	    }
		WebElement e = driver.findElement(By.xpath("//img[@style='padding: 0px;padding-left:5px']"));
		wLib.mouseOver(driver,e);
		/*Actions a = new Actions(driver);
		a.moveToElement(e).perform();*/
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		
		
	}

}
