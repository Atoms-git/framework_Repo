package PractiveDataDriventesting;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.openqa.selenium.remote.service.DriverCommandExecutor;

public class InsertDataIntoExcel {

	public static void main(String[] args) {
		
		Driver d = new Driver();
		DriverManager.registerDriver(d);
		Connection con =	DriverManager.getConnection("path");
		Statement st =con.createStatement();
		String qu="Select * from employee";
		ResultSet res  =st.executeQuery(qu);
		while(res.next()) {
			System.out.println(res.getInt(1)+ "/t" + res.getString(2)+ "/t"+ res.getInt(3));
		}
	}

}
