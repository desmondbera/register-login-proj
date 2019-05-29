package com.desmondbera.register_login;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class App {

	public static void main(String[] args) throws FileNotFoundException {
		System.out.println("Initializing appp..");
		
		System.out.println("Login or Register kind sir?");
		Scanner userInput = new Scanner(System.in);
		String line = userInput.nextLine().toLowerCase();
		
		if(line.equals("login")) {
			Login startLogin = new Login();
			startLogin.startLog();
			
		} else if(line.equals("register")) {
			Register startRegistration = new Register();
			startRegistration.startReg();
		} else {
			System.out.println("Not valid. You can only login OR register.");
		}
 		
//		System.out.println("Our line is: " + line);
		
	}

}
