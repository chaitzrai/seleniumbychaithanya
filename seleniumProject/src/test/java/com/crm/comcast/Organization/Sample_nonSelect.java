package com.crm.comcast.Organization;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class Sample_nonSelect {

	public static void main(String[] args) throws SQLException 
	{
		Connection con = null;
		try
		{
		Driver driverref = new Driver();
		DriverManager.registerDriver(driverref);
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_db","root","root");
		Statement stat = con.createStatement();
		int result = stat.executeUpdate("insert into student values(4,'zam','shetty','zamshetty@gmail.com')");
		if(result==1)
		{
			System.out.println("student is created");
		}
		}
		catch(Exception e)
		{
			System.err.println("student not created");
		}
		finally
		{
			con.close();
			System.out.println("connection closed");
		}
		
		}
	}

