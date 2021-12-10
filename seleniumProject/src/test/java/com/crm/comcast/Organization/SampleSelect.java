package com.crm.comcast.Organization;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;


public class SampleSelect
{
	public static void main(String[] args) throws SQLException
	{
		Driver driverref = new Driver();
		DriverManager.deregisterDriver(driverref);
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_db","root","root");
		Statement stat = con.createStatement();
		ResultSet set = stat.executeQuery("select * from student");
		while(set.next()) {
			System.out.println(set.getInt(1)+ "\t"+set.getString(2)+ "\t"+set.getString(3)+ "\t"+set.getString(4));
		}
		con.close();
	}

}
