package com.desmondbera.register_login;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Register {
	
	protected static String email;
	protected static String username;
	protected static String password;
	protected static String confirmpassword;
	
//	1. Check if e-mail is valid. Correct email format	
	public static boolean checkEmail() {
		boolean isValid = false;
		while(!isValid) {
			System.out.println("Please enter a valid e-mail: ");
			Scanner e = new Scanner(System.in);
			
			String input = e.nextLine();
			
			String regExp = "^(.+)@(.+)$";
			Pattern pattern = Pattern.compile(regExp);
			Matcher matchyMatchy = pattern.matcher(input);

			boolean result = matchyMatchy.matches();
			if(result) {
//				System.out.println("Valid e-mail");
				email = input;
				isValid = true;
				break;
			} else {
				System.out.println("**Invalid e-mail**");
			}
		}
		return isValid;
	}

	//2. Check if user is valid. Alphanums only.
	public static boolean checkUserName() {
		
		boolean isValid = false;
		
		while(!isValid) {
			System.out.println("Please enter a user name. Use any alpha-numeric types. Min. of 2 numbers in your username.: ");
			Scanner u = new Scanner(System.in);

			String input = u.nextLine();
			
			String regExp = "[A-Za-z0-9_]+";
			Pattern pattern = Pattern.compile(regExp);
			Matcher matchyMatchy = pattern.matcher(input);
			
			boolean result = matchyMatchy.matches();
			
			if(result) {
//				System.out.println("Valid username");
				username = input;
				isValid = true;
				break;
			} else {
				System.out.println("**Invalid username**");
			}
		}
		return isValid;
	}
	
	//3. Check if password is valid. All characters, minimum length;
	public static boolean checkPassword() {
		boolean isValid = false;
		while(!isValid) {
			System.out.println("Please enter a valid password.");
			System.out.println("Password must be: ");
			System.out.println("- between 8 and 40 characters long");
			System.out.println("- contain at least one lower case character");
			System.out.println("- contain at least one upper case character");
			System.out.println("- contains at least one special charcter [@ # $ % ! .]");
			Scanner c = new Scanner(System.in);
			
			String input = c.nextLine();
			
			String regExp = "((?=.*[a-z])(?=.*d)(?=.*[@#$%])(?=.*[A-Z]).{6,16})";
			Pattern pattern = Pattern.compile(regExp);
			Matcher matchyMatchy = pattern.matcher(input);
			
			boolean result = matchyMatchy.matches();
			
			if(result) {
//				System.out.println("Valid password");
				password = input;
				isValid = true;
				break;
			} else {
				System.out.println("**Invalid passowrd**");
			}
		}
		return isValid;
	}
	//4. Check if confirmPassword and password are the same
	public static boolean confirmPassword() {
		boolean isValid = false;
		while(!isValid) {
			System.out.println("Confirm password: ");
			Scanner c = new Scanner(System.in);
			
			String input = c.nextLine();
			confirmpassword = input;
			
			//1. if passwords match return true
			if(confirmpassword.contentEquals(password)) {
//				System.out.println("Passwords match!");
				isValid = true;
				break;
			} else {
				//2. else return false and have the user start over again.
				System.out.println("Passwords do not match. Please try again.");
			}
		}
		return isValid;
	}
	
	public static void writeToFile() {
		try {
			PrintWriter writer = new PrintWriter(username + ".txt", "UTF-8");
			String timeStamp = new SimpleDateFormat("yyyy.MM.dd-HH.mm.ss").format(new java.util.Date());
			writer.write(timeStamp);
			writer.write("\n");
			writer.write(username.toString());
			writer.write("\n");
			writer.write(confirmpassword.toString());
			writer.close();
		} catch(FileNotFoundException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	
	public void startReg() {
		checkEmail();
		checkUserName();
		if(checkPassword()) {
			if(confirmPassword()) {
				writeToFile();
			}
		};
		
	}
	
}
