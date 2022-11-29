package com.java.ecommerce.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MakeConn extends AdminMenu {

	
	public static Connection  connClass(){
		Connection conn = null;
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			String url ="jdbc:mysql://localhost:3306/shoppingcart";			
		    conn = DriverManager.getConnection(url,adminFixUId,adminFixPass);
		    
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
		
	} 
	}
