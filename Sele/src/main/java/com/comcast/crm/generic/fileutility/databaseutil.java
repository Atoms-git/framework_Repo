package com.comcast.crm.generic.fileutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class databaseutil {
Connection con;
	public void getDbConnection(String url ,String username , String password ) throws SQLException {
		try {
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		Connection con  = DriverManager.getConnection(url , username , password);
		}catch (Exception e) {
		}
		
	}
	public void closeDbConnection() throws SQLException {
		con.close();
	}
	
	
	public void executeConSelectQuery(String query) throws SQLException {
		Statement stat =con.createStatement();
		ResultSet result =stat.executeQuery(query);
	}
}
