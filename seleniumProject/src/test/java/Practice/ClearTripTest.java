package Practice;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ClearTripTest 
{
	static
	{
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	@Test
	public void clearTrip() throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.cleartrip.com/");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("(//input[@placeholder='Any worldwide city or airport'])[1]")).sendKeys("IXE");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//p[text()='Mangalore, IN - Bajpe (IXE)']")).click();
		driver.findElement(By.xpath("(//input[@placeholder='Any worldwide city or airport'])[2]")).click();
		driver.findElement(By.xpath("//p[text()='Bangalore, IN - Kempegowda International Airport (BLR)']")).click();
		//ghgfsfgdkjh,jhfgcgfgkhj;/
		//hjkgkhklkhmnvhb
		Date dateObj = new Date();
		String date = dateObj.toString();
		System.out.println(date);
		String[] today = date.split(" ");
		String day = today[0];
		String month = today[1];
		String dy = today[2];
		String year = today[5];
		String xpathdate = day+" "+month+" "+dy+" "+year;  // Wed Nov 10 2021
		
		driver.findElement(By.xpath("//div[@class='flex flex-middle p-relative homeCalender']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@aria-label='"+xpathdate+"']")).click();
		driver.close();
	}


}
