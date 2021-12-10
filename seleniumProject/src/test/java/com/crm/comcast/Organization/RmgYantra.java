package com.crm.comcast.Organization;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.cj.jdbc.Driver;


public class RmgYantra
{
	static
	{
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}

	public static void main(String[] args) throws SQLException 
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://localhost:8084/");
	    driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
	    driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
	    driver.findElement(By.xpath("//button[@type='submit']")).click();
	    driver.findElement(By.xpath("//a[.='Projects']")).click();
	    driver.findElement(By.xpath("//span[text()='Create Project']")).click();
	    driver.findElement(By.name("projectName")).sendKeys("SeleniumPrg");
	    driver.findElement(By.name("createdBy")).sendKeys("Chaithanya");
	    WebElement var = driver.findElement(By.xpath("(//select[@class='form-control'])[2]"));
	    Select s = new Select(var);
	    s.selectByIndex(1);
	    driver.findElement(By.xpath("//input[@type='submit']")).click();
	    
	    Connection con = null;
	    try
	    {
	    	Driver driverref = new Driver();
	    	DriverManager.registerDriver(driverref);
	    	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
	    	Statement stat = con.createStatement();
	    	ResultSet set = stat.executeQuery("select * from project");
			while(set.next()) {
				String name = set.getString(4);
				if(name.equals("SeleniumPrg"))
				{
					System.out.println("Project successfully created");
				}
			}
			
	    }
	    catch (Exception e) 
	    {
			System.out.println("project not created");
		}
	    finally 
	    {
			con.close();
		}
	    

	}

}
