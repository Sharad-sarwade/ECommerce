package com.java.ecommerce.database;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class ShoppingMain {
	static SHoppingFrontPg shpMain;
			
		 static void user() throws SQLException{
			for(;;) {
			System.out.println("1.Log In  2.Sign Up 3.Back  4. Exit Application");
			Database database = new Database();
			Scanner sc = new Scanner(System.in);
			int ch = sc.nextInt();
			try {
				switch(ch) {
				case 1: database.logIn();
						break;
				case 2: database.registerUser();
						break;
				case 3: shpMain.mainPage();
						break;	
				case 4: System.out.println("Sign out Successfully..");System.exit(0);	
				}
			} catch (Exception e) {
				
				e.printStackTrace();
			}
						
			}}
			
			
			
		}

