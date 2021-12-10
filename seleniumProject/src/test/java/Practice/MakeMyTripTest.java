package Practice;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MakeMyTripTest
{
	static
	{
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	public static void main(String[] args)
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.makemytrip.com/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//li[@class='makeFlex hrtlCenter font10 makeRelative lhUser userLoggedOut']")).click();
        driver.findElement(By.xpath("//span[text()='From']")).click(); 
        driver.findElement(By.xpath("//p[text()='Mumbai, India']")).click();
		driver.findElement(By.xpath("//p[text()='Bangalore, India']")).click();
		
		Date dateObj = new Date();
		String date = dateObj.toString();
		System.out.println(date);
		String[] today = date.split(" ");
		String day = today[0];
		String month = today[1];
		String dy =today[2];
		String year = today[5];
		String xpathDate = day+" "+month+" "+dy+" "+year;
		System.out.println(xpathDate);
		
		driver.findElement(By.xpath("//div[@aria-label='"+xpathDate+"']")).click();
	}
	
	
	
}
