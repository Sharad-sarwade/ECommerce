package com.java.ecommerce.database;

import java.awt.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Scanner;

public class Database {
	//static Connection conn;
	static ShoppingMain shppingMainObj;
	static int uId;
	static String name;
	static String city;
	static int mobileNum;
	static String password;
	static String  item;
	Scanner sc1;
	static productDetail pd;
	static LinkedList<productDetail> list = new LinkedList<>();
//	 public Database() {
//		 this.name=name;
//		 this.ci=email;
//		 this.password=password;
//	}
//	public Database(String name, String email, String password) {
//		 this.name=name;
//		 this.email=email;
//		 this.password=password;
//	}
	public static void registerUser(){
		
		 
		 	LinkedList<Database> list = new LinkedList<>();
		 	Scanner scanner = new Scanner(System.in);
		 	System.out.println("Please Enter your information.");
			System.out.println("Enter your id");
	 		uId =scanner.nextInt();
		  	System.out.println("Enter your name");
		 	name =scanner.next(); 
		 	System.out.println("Enter your city  ");
		 	city = scanner.next();
		 	System.out.println("Enter your Mobile number..");
		 	mobileNum = scanner.nextInt();
		 	System.out.println("Enter your Password..");
		 	password = scanner.next();
		 	
			try {			 
				Class.forName("com.mysql.cj.jdbc.Driver");
				String url ="jdbc:mysql://localhost:3306/shoppingcart";
//				String user="root";
//				String password="Sharad$20";
//				
//				Connection conn = DriverManager.getConnection(url, user, password);
				
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/shoppingcart","root","Sharad$20");
				
			String newQuery ="insert into shoppingcart.registereduser(regId,firstname,city,mob_no,password) values(?,?,?,?,?)";
			PreparedStatement ps1= conn.prepareStatement(newQuery);
			ps1.setInt(1,uId);
			ps1.setString(2, name);
			ps1.setString(3, city);
			ps1.setInt(4, mobileNum);
			ps1.setString(5, password);
			ps1.executeUpdate();
			ps1.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		    System.out.println("registered successfully..\nYou can log in now..");
		    ShoppingMain.user();
	 }
	 public static void logIn() {
	
		   Scanner scanner = new Scanner(System.in);
		   System.out.println("Enter your User id");
		    uId = scanner.nextInt();
		 
		   System.out.println("Enter your Password");
		   String password1 = scanner.next();
			try {			 
				Class.forName("com.mysql.cj.jdbc.Driver");
				String url ="jdbc:mysql://localhost:3306/shoppingcart";
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/shoppingcart","root","Sharad$20");
				String newQuery ="select * from shoppingcart.registereduser where regId ="+uId;
				PreparedStatement ps1= conn.prepareStatement(newQuery);
				ResultSet rs1 = ps1.executeQuery();
			while(rs1.next()) {
				
				int regId = rs1.getInt(1);
				String regPass = rs1.getString(5);
				 name = rs1.getString(2);
			 	if((uId==regId)&&(password1.equals(regPass))) {
			 		//if(true) {	
			 					System.out.println("                                           User :"+name);
			 			System.out.println("You have logged in successfully..");
			 			products();
			 		}
			 		else {
			 			System.out.println("Enetr Correct Credential..");
			 		}
			}
		 	conn.close();
		 	ps1.close();
		 	rs1.close();
		 }catch(Exception e) {
			 e.printStackTrace();}
	  }
	 public static void products() {
		for(;;)
		 try {

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
			
			
			
			System.out.println("no.   "+" product name   "+" Description   "+  " price  "+"   Quantity  ");
				
			while(rs1.next()) {
					int Product_id = rs1.getInt(1);
					String product_name =rs1.getString(4);
					String Description = rs1.getString(2);
					int price =rs1.getInt(3);
					int Quantity = rs1.getInt(5);
					
	
	System.out.println(" "+rs1.getInt(1)+"     "+rs1.getString(4)
	+"       "+rs1.getString(2)+ "     "+rs1.getInt(3)+"      "+rs1.getInt(5));
			
		
			}
		
			
			System.out.println("1. Select Product 2.View Cart 3.Back 4. Exit Appliction");
			//System.out.println("Select choice");
			Scanner sc = new Scanner(System.in);
			int ch= sc.nextInt();
			switch(ch) {
			case 1: SelectAnotherProduct(conn);break;
			case 2:viewCart();break;
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
		}
	 }
	 static void  SelectAnotherProduct(Connection conn) throws SQLException {
		 		System.out.println("\n"+"Enetr product id");
		 		Scanner sc1 = new Scanner(System.in);
				int prdctId=sc1.nextInt();
				String que = "select * from product where id = "+prdctId;
				PreparedStatement ps = conn.prepareStatement(que);
				ResultSet rs1 = ps.executeQuery();
				
			//System.out.println("Select product m called");
			//ResultSet rs1 = ps.executeQuery();
				if (rs1.next()) {
					  item = (rs1.getString(4));
					  System.out.println("selcted product is :"+item);
					  System.out.println("Product price "+rs1.getInt(3));
					 System.out.println("1. Add to Cart 2.Back 3.Exit"); 
					 int ch=sc1.nextInt();
					 switch(ch) {
					 case 1:addToCart(rs1);break;
					 case 2:products();break;
					 case 3:viewCart();break;
					 case 4:System.exit(0);
					 default:System.out.println("Please Select Correct choice");
					 
					 }
				}
		 }
		 
	public static void addToCart(ResultSet rs1) throws SQLException {
		System.out.println("Your product  are added successfully.."+item);
		
		int id = rs1.getInt(1);
		String pdName = rs1.getString(4);
		String pdDis = rs1.getString(2);
		int prc = rs1.getInt(3);
		int qty = rs1.getInt(5);
		
		pd = new productDetail(id,pdName,pdDis,prc,qty);
		list.add(pd);
		viewCart();//buy
		buyProdct(rs1);
				
	}
	
	public static void viewCart() {
		for(Object o: list)
		System.out.println(o);
			
	}
	public static void buyProdct(ResultSet rs1) throws SQLException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Select quantitys");
		int Qty =sc.nextInt();
		int id = rs1.getInt(1);
		String pdName = rs1.getString(4);
		String pdDis = rs1.getString(2);
		int prc = rs1.getInt(3);
		int qty = rs1.getInt(5);
		int totalPrc = Qty * prc;
		System.out.println("Bill Generated");
		System.out.println("---------------------------------------"+"\n");
		System.out.println("Product name:"+pdName);
		System.out.println("Product Discription:"+pdDis);
		System.out.println("Product Price:"+prc+" Rupees");
		System.out.println("Quantity:"+Qty);
		System.out.println("Total Bill Paid:"+totalPrc+" Rupees");
		System.out.println("---------------------------------------"+"\n");
		System.out.println("Congrats!  Your Product Purchesed Successfully...");
		int remainingQty=qty-Qty;
//		System.out.println(remainingQty+"\n"+id);

		try {			 
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url ="jdbc:mysql://localhost:3306/shoppingcart";
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/shoppingcart","root","Sharad$20");
			
			String newQuery ="update shoppingcart.product set Quantity= "+remainingQty+" where id ="+id;
			PreparedStatement ps1= conn.prepareStatement(newQuery);
			ps1.executeUpdate();
			
			String ss="insert into shoppingcart.history(id,name,purchasedProduct,purchsQty) values(?,?,?,?)";
			
			//String newQuery1 ="insert into shoppingcart.history values id= " +id +" name=" +name +" purchasedProduct="+pdName+" purchsQty="+Qty+" where id ="+uId;
			PreparedStatement histPs= conn.prepareStatement(ss);
			histPs.setInt(1,id);
			histPs.setString(2, name);
			histPs.setString(3, pdName);
			histPs.setInt(4, Qty);
			
			histPs.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		SHoppingFrontPg.nevigation();
	}
	
	 
}