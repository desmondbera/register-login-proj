package com.desmondbera.register_login;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Login {

	private static String loginName;
	private static String password;
	
	public static boolean checkUsername() {
		boolean isValid = false;
		while(!isValid) {
			System.out.println("What is your username? ");
			Scanner userInput = new Scanner(System.in);
			String strInput = userInput.next();
			
			File file = new File(strInput + ".txt");
			if(file.exists()) {
				loginName = strInput + ".txt";
				isValid = true;
				break;
			} else {
				System.out.println("No user exists.");
			}
		}
		return isValid;
	}
	
	public boolean checkPassword() throws FileNotFoundException {
		
		boolean isValid = false;
		
		while(!isValid) {
			System.out.println("What is your password? ");
			Scanner userInput = new Scanner(System.in);
			String strPassword = userInput.next();
			
			File txtFile = new File(loginName );
			System.out.println("txt file is: " + txtFile);
			Scanner scan =  new Scanner(txtFile);
			
			int x = 0;
			while(scan.hasNextLine()) {
				String line = scan.next();
				if(x == 2) {
					if(strPassword.contentEquals(line)) {
						isValid = true;
						break;
					} else {
						System.out.println("Password incorrect.");
					}
				}
				x++;
			}
			
		}
		return isValid;
	}
	
	public void startLog() throws FileNotFoundException {
		System.out.println("Logging in...");
		//1. Check username
		if(checkUsername()) {
			//2. check password
			if(checkPassword()) {
				System.out.println("Welcome " + loginName + "!");
			};
		};
		
		
	}
	
}
