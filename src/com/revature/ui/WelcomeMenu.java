package com.revature.ui;

import java.util.Scanner;

public class WelcomeMenu implements Menu {

	private Scanner scan;

	private Menu loginMenu;

	private Menu registrationMenu;

	private Menu nextMenu;
	
	private Menu updateMenu;
	
	private Menu deleteMenu;

	@Override
	public Menu advance() {
		return nextMenu;
	}

	@Override
	public void displayOptions() {
		System.out.println("Welcome to KP's Social Media.");
		System.out.println("What would you like to do?");
		System.out.println("1. register");
		System.out.println("2. login");
		System.out.println("3. updateAccount");
		System.out.println("4. deleteAccount");
		String answer = scan.nextLine();

		if ("1".equals(answer) || "register".equals(answer)) {
			nextMenu = registrationMenu;
		} else if ("2".equals(answer)|| "login".equals(answer)) {
			nextMenu = loginMenu;
		} else if ("3".equals(answer)|| "updateAccount".equals(answer)) {
			nextMenu = updateMenu;
		} else if ("4".equals(answer)|| "deleteAccount".equals(answer)) {
			nextMenu = deleteMenu;
		} else {
			System.out.println("invalid input");
			// redirect user to same welcome menu
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

	public WelcomeMenu(Menu loginMenu, Menu registractionMenu, Menu updateMenu, Menu deleteMenu) {
		super();
		this.loginMenu = loginMenu;
		this.registrationMenu = registractionMenu;
		this.updateMenu = updateMenu;
		this.deleteMenu = deleteMenu;
	}

}
