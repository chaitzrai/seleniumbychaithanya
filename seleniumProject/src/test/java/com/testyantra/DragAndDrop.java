package com.testyantra;

import java.awt.Desktop.Action;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragAndDrop 
{
	/*static
	{
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver1.exe");
	}*/
	
	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("http://demo.automationtesting.in/Static.html");
		WebElement src = driver.findElement(By.xpath("(//img[@id='angular'])[1]"));
		WebElement dest = driver.findElement(By.xpath("//div[@id='droparea']"));
		Actions a = new Actions(driver);
		a.dragAndDrop(src,dest).perform();
		driver.close();
		

	}

}
