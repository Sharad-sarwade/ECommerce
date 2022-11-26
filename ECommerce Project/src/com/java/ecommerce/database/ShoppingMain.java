package com.java.ecommerce.database;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class ShoppingMain {
	static SHoppingFrontPg shpMain;
			CustomerData sd = new CustomerData();
//			sd.driverConn();
			
		 static void user(){
			for(;;) 
			{
			System.out.println("1. Sign Up  2. Log In 3.Back  4. Exit Application");
			Database database = new Database();
			Scanner sc = new Scanner(System.in);
			int ch = sc.nextInt();
			switch(ch) {
			case 1: database.registerUser();
						break;
			case 2: database.logIn();
						break;
			case 3: shpMain.mainPage();
						
			case 4: System.out.println("Sign out Successfully..");System.exit(0);	
				
						
			}}
			
			
			}
		}

