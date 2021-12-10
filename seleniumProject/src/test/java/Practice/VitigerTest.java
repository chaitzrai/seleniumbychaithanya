package Practice;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.comcast.generic.FileUtility;

public class VitigerTest 
{
	static
	{
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	@Test
	public void vtigerExample() throws IOException
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
		
		driver.manage().window().maximize();
		driver.get(Url);
		
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(Username);
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(Password);
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Organizations")).click();
		
		//select all the check box
		List<WebElement> lst = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[1]/input"));
		for(int i = 1;i<lst.size();i++)
		{
			lst.get(i).click();
		}
		
		//deselect last option
		lst.get(lst.size()-1).click();
		
		//check on 4th or 5th option
		//driver.findElement(By.id("7")).click();
		
		//print all the organization name in console
		List<WebElement> name = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[3]/a"));
		for(int i = 1;i<name.size();i++)
		{
			System.out.println(name.get(i).getText());
		}
		
		
		
		
		
	}

}
