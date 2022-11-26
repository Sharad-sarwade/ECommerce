package com.java.ecommerce.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Scanner;

public class Database {
	static ShoppingMain shppingMainObj;
	static String name;
	static String email;
	static String password;
	 static String  item;
	
	 public Database() {
		 this.name=name;
		 this.email=email;
		 this.password=password;
	}
	public Database(String name, String email, String password) {
		this.name=name;
		 this.email=email;
		 this.password=password;
	}
	public static void registerUser(){
		 
		 	LinkedList<Database> list = new LinkedList<>();
		 Scanner scanner = new Scanner(System.in);
		 	System.out.println("Please Enter your information.");
		 	System.out.println();
		 	System.out.println("Enter your name");
		 		 name =scanner.next(); 
		 	System.out.println("Enter your email  ");
		 		 email = scanner.next();
		 	System.out.println("Enter your Password..");
		 		 password = scanner.next();
		 		 	
				 Database database = new Database(name,email,password);
		 list.add(database);
		 System.out.println("registered successfully..");
	 }
	 public static void logIn() {
	
//		 Scanner scanner = new Scanner(System.in);
//		 	System.out.println("Enter your email");
//		 		String email1= scanner.next();
//		 	System.out.println("Enter your Password..");
//		 		String password1 = scanner.next();
		 	//
		 		//if((email1.equals(email))&&(password1.equals(password))) {
		 		if(true) {	
		 					System.out.println("                                           User :"+name);
		 			System.out.println("You have logged in successfully..");
		 			products();
		 		}
		 		else {
		 			System.out.println("Enetr Correct Credential..");
	 }

	  }
	 public static void products() {
		 	for(;;){
		 try {
//			 System.out.println("\n"+"Enetr product id");
//				Scanner sc1 = new Scanner(System.in);
//					int prdctId=sc1.nextInt();
//					String s=Integer.toString(prdctId);
					//String ss="select * from product where id =";
					//String sss=ss;
			 
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url ="jdbc:mysql://localhost:3306/shoppingcart";
//			String user="root";
//			String password="Sharad$20";
//			
//			Connection conn = DriverManager.getConnection(url, user, password);
			
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/shoppingcart","root","Sharad$20");
			
			
			PreparedStatement ps = conn.prepareStatement("select * from product where id = 1");
			ResultSet rs = ps.executeQuery();
																							//**************
			PreparedStatement ps1 = conn.prepareStatement("SELECT * FROM shoppingcart.product order by productName");
			ResultSet rs1 = ps1.executeQuery();
			
			
			
			System.out.println("no. "+" product name "+" Description "+ " price  "+"Quantity "+" Quantity  ");
				
			while(rs1.next()) {
					int Product_id = rs1.getInt(1);
					String product_name =rs1.getString(4);
					String Description = rs1.getString(2);
					int price =rs1.getInt(3);
					int Quantity = rs1.getInt(5);
					
	
	System.out.println(" "+rs1.getInt(1)+"     "+rs1.getString(4)
	+"       "+rs1.getString(2)+ "     "+rs1.getInt(3)+"      "+rs1.getInt(5)+"       "+rs1.getInt(5));
			
		
			}
//			
			
			System.out.println("1. Select new Product 2.addToCart 3.Back 4. Exit Appliction");
			//System.out.println("Select choice");
			Scanner sc = new Scanner(System.in);
			int ch= sc.nextInt();
			switch(ch) {
			case 1: SelectAnotherProduct(ps);break;
			case 2:addToCart();break;
			
			case 3:shppingMainObj.user(); break;
			case 4:System.out.println("Exit Application Successfully..");System.exit(0);
			default : System.out.println("Enter valid choice..");
			}
			
			//SelectProduct(ps);

				conn.close();
				ps.close();
				rs.close();
		} catch (Exception e) {
			
			e.printStackTrace();
		}}
	 }
	 static void  SelectProduct(PreparedStatement ps) throws SQLException {
			System.out.println("Select product m called");
			ResultSet rs1 = ps.executeQuery();
			if (rs1.next()) {
			    item = (rs1.getString(4));
			  System.out.println("selcted product is :"+item);
			  System.out.println("Product price "+rs1.getInt(3));
			  
			}
		 }
		 
	public static void addToCart() {
		System.out.println("Your product  are added successfully.."+item);
		
	}
	public static void SelectAnotherProduct(PreparedStatement ps) {
			System.out.println("Your Products are");
			addToCart();
	}
	
	 
}