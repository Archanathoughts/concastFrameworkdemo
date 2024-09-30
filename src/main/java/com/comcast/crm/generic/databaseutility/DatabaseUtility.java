package com.comcast.crm.generic.databaseutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DatabaseUtility {
	Connection connect;
	public void getdbConnection(String url,String username,String password) throws SQLException
	{
		try {
				Driver driver=new Driver();
				DriverManager.registerDriver(driver);
				connect = DriverManager.getConnection(url,username,password);
			}catch(Exception e) {
		
		    }
		}
	
	public void closedbConnection()
	{
		try {
			connect.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ResultSet executeNonSelectQuery(String query)
	{
		ResultSet set=null;
		try
		{
			Statement statement = connect.createStatement();
			set = statement.executeQuery(query);
			
		}catch(Exception e)
		{
			
		}
		return set;
	}
	public int executeSelectQuery(String query)
	{
		int set=0;
		try
		{
			Statement statement = connect.createStatement();
			set = statement.executeUpdate(query);
			
		}catch(Exception e)
		{
			
		}
		return set;
	}
	
	
}
