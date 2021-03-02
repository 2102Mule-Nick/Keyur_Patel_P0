package com.revature.ui;

import java.util.Scanner;

public class WelcomeMenu implements Menu {

	private Scanner scan;
	
	private Menu loginMenu;
	
	private Menu registrationMenu;
	
	private Menu nextMenu;
	
	@Override
	public Menu advance() {
		return nextMenu;
	}

	@Override
	public void displayOptions() {
		System.out.println("Welcome to Keyur's Social Media.");
		System.out.println("Would you like to login or register?");
		String answer = scan.nextLine();
		
		if ("login".equals(answer)) {
			nextMenu = loginMenu;
		} else if ("register".equals(answer)) {
			nextMenu = registrationMenu;
		} else {
			System.out.println("Please select from given choices. login or register");
			//redirect user to same welcome menu
			nextMenu = this;
		}
	}

	@Override
	public Menu previousMenu() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Scanner getScanner() {
		return this.scan;
	}

	@Override
	public void setScanner(Scanner scan) {
		this.scan = scan;
	}

	public WelcomeMenu() {
		super();
		// TODO Auto-generated constructor stub
	}

	public WelcomeMenu(Menu loginMenu, Menu registrationMenu) {
		super();
		this.loginMenu = loginMenu;
		this.registrationMenu = registrationMenu;
	}

}
