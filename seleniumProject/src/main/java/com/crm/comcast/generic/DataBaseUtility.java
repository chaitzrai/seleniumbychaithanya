package com.crm.comcast.generic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class DataBaseUtility 
{
	static Driver driver;
	static Connection connection;
	static ResultSet result;
	
	/**
	 * This method will perform the mysql database connection
	 */
	
	public void connectDB()
	{
		try
		{
			driver = new Driver();
			DriverManager.registerDriver(driver);
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * This methou will execute the query
	 * @param query
	 * @return
	 */
	public ResultSet executeQuery(String query)
	{
		try
		{
			result = connection.createStatement().executeQuery(query);
			return result;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * This method will close the mysql database
	 * @throws SQLException
	 */
	public void closeDB() throws SQLException
	{
		connection.close();
	}
	
	/*
	 * This method will execute the query and based on query it will verify the data
	 * @param querry
	 * @param columnName
	 * @param expectedData
	 */
	public String executeQueryAndGetData(String query,int columnName,String expectedData) throws SQLException
	{
		boolean flag = false;
		result = connection.createStatement().executeQuery(query);
		while(result.next()) 
		{
			if(result.getString(columnName).contentEquals(expectedData))
			{
				flag = true;
				break;
			}
			
		}
		if(flag)
		{
			System.out.println(expectedData+"Data is verified in the data base table");
			return expectedData;
		}
		else
		{
			System.out.println(expectedData+"Data is not verified in the database");
			return expectedData;
		}
	}
	
	

}
