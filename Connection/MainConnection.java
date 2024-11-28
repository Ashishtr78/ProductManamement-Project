package com.infosys.jdbc_prepared_statement_crud.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class MainConnection {
	
	public static Connection getMainConnection()
	{
		
		try {
			// step-1 load/register driver
			Driver driver=new Driver();
			DriverManager.registerDriver(driver);
			String url="jdbc:mysql://localhost:3306/productmanagement";
			String username="root";
			String password="Ashish";
			return DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			
			e.printStackTrace();
			return null;
		}
	
	}

}
