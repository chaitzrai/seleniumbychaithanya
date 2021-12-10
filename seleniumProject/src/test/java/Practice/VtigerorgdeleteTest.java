package Practice;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.comcast.generic.FileUtility;

public class VtigerorgdeleteTest
{
	static
	{
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	@Test
	public void delete() throws IOException, Throwable
	{
		FileUtility fLib = new FileUtility();
		String Browser = fLib.getPropertykey("browser");
		String Url = fLib.getPropertykey("url");
		String Username = fLib.getPropertykey("username");
		String Password = fLib.getPropertykey("password");
		
		WebDriver driver=null;
		if(Browser.equals("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(Browser.equals("firefox"))
		{
			driver = new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(Url);
		
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(Username);
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(Password);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Organizations")).click();
		String name;
		List<WebElement> orgname = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[3]/a"));
		for(int i = 1;i<orgname.size();i++)
		{
			String actualname = orgname.get(i).getText();
			name=orgname.get(1).getText();
		if(actualname.equals(name))
		{
		//	Thread.sleep(3000);
			driver.findElement(By.xpath("//a[text()='"+name+"']/../..//td[8]/a[text()='del']")).click();
			Thread.sleep(2000);
			 driver.switchTo().alert().accept();
		}
		driver.quit();
	   // Alert a = driver.switchTo().alert();
	   // a.accept();
		
		
	}
	}
}
