package com.java.ecommerce.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.cj.protocol.Resultset;

public class AdminMenu {

	
		static Scanner newScan = new Scanner(System.in);
	public static void admin() {
			System.out.println("Enter Admin details ");
			System.out.println("Enetr Admin's User Id And Password ");
			String adminUserId = newScan.next();
			String adminPass= newScan.next();
		
		if(adminUserId.equals(("Admin"))&&(adminPass.equals("Admin@123"))){
		
			System.out.println("1. check quantity 2.Check user List 3.check the particular user history ");
			int choice = newScan.nextInt();
			switch(choice) {
			case 1:checkQuantity();break;
			case 2:CheckUserlist();break;
			case 3:checkHistory();break;
//			case 4;
			}}
			else {
				System.out.println("Alert!.. Enter Correct Credentials..");
			
			}
	}

	public static void checkHistory() {
		Connection conn;
		try {
			Scanner sc= new Scanner(System.in);
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/shoppingcart","root","Sharad$20");
			System.out.println("Enter user id to see history:");
			int histUId=sc.nextInt();
			String newQuery ="select *from shoppingcart.history where id="+histUId;
			PreparedStatement ps1= conn.prepareStatement(newQuery);
			ResultSet rs = ps1.executeQuery();
			System.out.println("User Purchase History");
			System.out.println("Id"+"   Name  "+"    product name "+" Quantity");
			while(rs.next()) {
				System.out.println(rs.getInt(1)+"    "+rs.getString(2)+"    "+rs.getString(3)+"  "+rs.getInt(4));
			}
		}   catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void CheckUserlist() {
			Connection conn;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/shoppingcart","root","Sharad$20");
			String newQuery ="select regId,firstname,city,mob_no from shoppingcart.registereduser";
			PreparedStatement ps1= conn.prepareStatement(newQuery);
			ResultSet rs = ps1.executeQuery();
			System.out.println("List of Registerd User");
			System.out.println("Id"+"   Name  "+"    City "+" Mobile number");
			while(rs.next()) {
				System.out.println(rs.getInt(1)+"    "+rs.getString(2)+"    "+rs.getString(3)+"  "+rs.getInt(4));
			}
		}   catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void checkQuantity() {
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			String url ="jdbc:mysql://localhost:3306/shoppingcart";			
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/shoppingcart","root","Sharad$20");
			System.out.println("Enter ID of Product to check Quantity");
			int checkId = newScan.nextInt();
			String newQuery ="select productName,Quantity from shoppingcart.product where id ="+checkId;
			PreparedStatement ps1= conn.prepareStatement(newQuery);
			ResultSet rs = ps1.executeQuery();
		
		while(rs.next()) {
			System.out.println("Product Name : "+rs.getString(1));
			System.out.println("Quantity : "+rs.getInt(2));
			
		}
	
			conn.close();
			ps1.close();
			rs.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
		
	}
