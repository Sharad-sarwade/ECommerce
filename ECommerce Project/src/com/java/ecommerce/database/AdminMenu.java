package com.java.ecommerce.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.cj.protocol.Resultset;

public class AdminMenu {
	static String adminFixUId="root";
	static String adminFixPass="Sharad$20";
	
		static Scanner newScan = new Scanner(System.in);
	public static void back() throws SQLException {
		System.out.println("1. BACk");
		int choice = newScan.nextInt();
		switch(choice) {
		    case 1: adminsNev();break;
		    default:adminsNev();break;
		}
		
	}
	public static void admin() throws SQLException {
			System.out.println("Enter Admin details ");
			System.out.println("Enetr Admin's User Id And Password ");
			String adminUserId = newScan.next();
			String adminPass= newScan.next();
			
			if(adminUserId.equals((adminFixUId))&&(adminPass.equals(adminFixPass))){
			adminsNev();
			}else {
				System.out.println("Alert!.. Enter Correct Credentials..");
			}
	}
	public static void adminsNev() throws SQLException {
		
			System.out.println("1. check quantity 2.Check user List 3.check user history 4. logout");
			int choice = newScan.nextInt();
			switch(choice) {
			case 1:checkQuantity();break;
			case 2:CheckUserlist();break;
			case 3:checkHistory();break;
			case 4:System.out.println("Admin Log out Successfully..\n");SHoppingFrontPg.mainPage();break;
			case 5:System.exit(0);System.out.println("App successfully Exited..");
			}}


	public static void checkHistory() throws SQLException {
		
			Scanner sc= new Scanner(System.in);
			System.out.println("Enter user id to see history:");
			int histUId=sc.nextInt();
			String newQuery ="select *from shoppingcart.history where id="+histUId;
			PreparedStatement ps1= MakeConn.connClass().prepareStatement(newQuery);
			ResultSet rs = ps1.executeQuery();
			System.out.println("User Purchase History");
			System.out.println("Id"+"   Name  "+"    product name "+" Quantity");
			while(rs.next()) {
				System.out.println(rs.getInt(1)+"    "+rs.getString(2)+"    "+rs.getString(3)+"  "+rs.getInt(4));
			}
		
		back();
	}

	public static void CheckUserlist() throws SQLException {
		
			String newQuery ="select regId,firstname,city,mob_no from shoppingcart.registereduser";
			PreparedStatement ps1= MakeConn.connClass().prepareStatement(newQuery);
			ResultSet rs = ps1.executeQuery();
			System.out.println("List of Registerd User");
			System.out.println("Id"+"   Name  "+"    City "+" Mobile number");
			while(rs.next()) {
				System.out.println(rs.getInt(1)+"    "+rs.getString(2)+"    "+rs.getString(3)+"  "+rs.getInt(4));
			}
		
		back();
	}

	public static void checkQuantity() throws SQLException {
		
			System.out.println("Enter ID of Product to check Quantity");
			int checkId = newScan.nextInt();
			String newQuery ="select productName,Quantity from shoppingcart.product where id ="+checkId;
			PreparedStatement ps1= MakeConn.connClass().prepareStatement(newQuery);
			ResultSet rs = ps1.executeQuery();
		
		while(rs.next()) {
			System.out.println("Product Name : "+rs.getString(1));
			System.out.println("Quantity : "+rs.getInt(2));
			
		}
			ps1.close();
			rs.close();
		back();
	}
	 	
		
	}
