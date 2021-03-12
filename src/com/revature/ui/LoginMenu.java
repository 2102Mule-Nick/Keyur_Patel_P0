package com.revature.ui;

import java.util.Scanner;

import com.revature.exception.InvalidPassword;
import com.revature.exception.UserNotFound;
import com.revature.pojo.User;
import com.revature.service.AuthService;

public class LoginMenu implements Menu {

	private AuthService authService;

	private Scanner scan;

	public Scanner getScanner() {
		return scan;
	}

	public void setScanner(Scanner scan) {
		this.scan = scan;
	}

	public AuthService getUserService() {
		return authService;
	}

	public void setUserService(AuthService userService) {
		this.authService = userService;
	}

	@Override
	public Menu advance() {
		return null;
	}

	@Override
	public void displayOptions() {
		System.out.println("Please Enter Username");
		String username = scan.nextLine();
		System.out.println("Please Enter Password");
		String password = scan.nextLine();
		System.out.println("Please enter First name:");
		String firstname = scan.nextLine();
		System.out.println("Please enter Last name:");
		String lastname = scan.nextLine();

		User user = new User(username, password, firstname, lastname);

		try {
			authService.authenticateUser(user);
			System.out.println("Login successful");
			// throw new Error();
		} catch (UserNotFound e) {
			System.out.println("Username does not exist.  Please register an account.");
		} catch (InvalidPassword e) {
			System.out.println("Authentication error, check username/password");
		} catch (Exception e) {
			System.out.println("Sorry, something went wrong. Please try again later.");
			e.printStackTrace();
		} finally {
			System.out.println("Login Process Ended");
		}

	}

	@Override
	public Menu previousMenu() {
		// TODO Auto-generated method stub
		return null;
	}

	public LoginMenu() {
		super();
	}

	public LoginMenu(AuthService authService) {
		super();
		this.authService = authService;
	}

}
