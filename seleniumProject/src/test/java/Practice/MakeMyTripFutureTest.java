package Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class MakeMyTripFutureTest 
{
	static
	{
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	@Test
	public void bookTicket() throws InterruptedException
	{
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//li[@class='makeFlex hrtlCenter font10 makeRelative lhUser userLoggedOut']")).click();
        driver.findElement(By.xpath("//span[text()='From']")).click(); 
        driver.findElement(By.xpath("//p[text()='Mumbai, India']")).click();
		driver.findElement(By.xpath("//p[text()='Bangalore, India']")).click();
		//driver.findElement(By.xpath("//span[text()='DEPARTURE']")).click();
		Thread.sleep(2000);		
		driver.findElement(By.xpath("//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")).click();
		driver.findElement(By.xpath("//div[@aria-label='Sat Jan 22 2022']")).click();
		
		//JavascriptExecutor executer = (JavascriptExecutor)driver;
		//executer.executeScript("arguments[0].click();", element);
	}
	

}
