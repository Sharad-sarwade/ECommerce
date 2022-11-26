package com.java.ecommerce.database;

import java.util.Scanner;

public class SHoppingFrontPg {

		public static void main(String[] args) {
			mainPage();
			
}
static void mainPage() {
	System.out.println("1. User 2. Admin 3. Exit Application");
	ShoppingMain shoppingmain =new ShoppingMain();
	Scanner sc = new Scanner(System.in);
	int ch = sc.nextInt();
	switch(ch) {
	
	
	case 1: shoppingmain.user();
				break;
	//case 2: shoppingmain.admin();
//				break;
	case 3:System.out.println("Sign out Successfully.."); System.exit(0);System.out.println("Sign out Successfully..");
}
}
}
