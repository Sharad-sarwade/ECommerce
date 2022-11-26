package com.java.ecommerce.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class CustomerData {
		public static void main(String[] args) {
			
		
	
		  try {
			  
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url ="jdbc:mysql://localhost:3306/";
			String user="root";
			String password="Sharad$20";
			
			Connection conn = DriverManager.getConnection(url, user, password);
			
//			for(int i=1;i<=5;i++) {
//				Scanner sc = new Scanner(System.in);
//			String sql = "insert into shoppingcart.product (id,description,price,productName,Quantity)"+ "values(?,?,?,?,?)";
//				System.out.println("Enter product description name");
//				String productdesc = sc.next();
//				System.out.println("Enter price");
//				int price = sc.nextInt();
//				System.out.println("Enter Product name ");
//				String name = sc.next();
//				System.out.println("Enter Product Quantity");
//				int quantity =sc.nextInt();
//			PreparedStatement ps = conn.prepareStatement(sql);
//			ps.setInt(1, i);
//			ps.setString(2, productdesc);
//			ps.setInt(3, price);
//			ps.setString(4, name);
//			ps.setInt(5, quantity);
			
			
			PreparedStatement ps=conn.prepareStatement("select * from shoppingcart.product where id=1");
			
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				System.out.println("Product id = "+rs.getInt(1));
				System.out.println("Description = "+rs.getString(2));
				System.out.println("price ="+rs.getInt(3));
				System.out.println("product name = "+rs.getString(4));
				System.out.println("Quantity = "+rs.getInt(5));
				
				conn.close();
				ps.close();
				rs.close();
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	 
}}
