package com.comcast.crm.generic.databaseutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DataBaseUtility {

	Connection con;
	
	public void getConnection(String url, String username, String password) throws SQLException {
		try {
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		con = DriverManager.getConnection(url,username,password);
		}
		catch (Exception e) {
			
		}
	}
	public void getConnection() throws SQLException {
		try {
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root@%","root");
		}
		catch (Exception e) {
			
		}
	}
	public void closeConnection() throws SQLException {
		try {
			con.close();
			
		}
		catch(Exception e) {
			
		}
	}
	public ResultSet executeSelectQuery(String query) throws SQLException {
		ResultSet result=null;
		try {
		Statement stmt=con.createStatement();
	    result = stmt.executeQuery(query);
		}
		catch (Exception e) {
		}
		return result;
	}
	public int executeNonSelectQuery(String query) {
		int result=0;
		try {
		Statement stmt=con.createStatement();
	    result = stmt.executeUpdate(query);
		}
		catch (Exception e) {
		}
		return result;
	}
	
}
