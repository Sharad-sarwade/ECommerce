package com.java.ecommerce.database;

import java.sql.SQLException;
import java.util.Scanner;

public class SHoppingFrontPg {
	static ShoppingMain shoppingmain;
	static Database dbNev;
		public static void main(String[] args) throws SQLException {
			mainPage();
			
}
static void mainPage() throws SQLException {
	System.out.println("WEL-COM SHOPPING APP..");
	System.out.println("1. User 2. Admin 3. Exit Application");
	//ShoppingMain shoppingmain =new ShoppingMain();
	Scanner sc = new Scanner(System.in);
	int ch = sc.nextInt();
	AdminMenu adminMenu = new AdminMenu();
	switch(ch) {
	
	
	case 1: shoppingmain.user();
				break;
	case 2: adminMenu.admin();
				break;
	case 3:System.out.println("App Exited Successfully.."); System.exit(0);
}
}
		public static void nevigation() throws SQLException {
		//	Database dbNev = new Database();
			System.out.println("1.Back to Product List 2.Log Out 3.Goto Main Page 4.Exit");
			Scanner scc= new Scanner(System.in);
			int ch = scc.nextInt();
			switch(ch) {
					case 1:dbNev.products();break;
					case 2:System.out.println("Log out Successfully..");shoppingmain.user();
					break;
					case 3:mainPage();break;
					case 4:System.out.println("App Exited Successfully..");System.exit(0);
			
			}
		}
}
