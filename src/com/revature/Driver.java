package com.revature;

import java.util.Scanner;

import com.revature.dao.UserDao;
import com.revature.dao.UserDaoKryo;
import com.revature.service.AuthService;
import com.revature.service.AuthServiceImpl;
import com.revature.ui.LoginMenu;
import com.revature.ui.Menu;
import com.revature.ui.RegistrationMenu;
import com.revature.ui.WelcomeMenu;

public class Driver {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		UserDao userDao = new UserDaoKryo();

		AuthService authService = new AuthServiceImpl(userDao);

		Menu register = new RegistrationMenu();

		Menu login = new LoginMenu(authService);

		Menu welcomeMenu = new WelcomeMenu(login, register);

		((RegistrationMenu) register).setWelcomeMenu(welcomeMenu);

		((RegistrationMenu) register).setAuthService(authService);

		login.setScanner(scan);

		register.setScanner(scan);

		welcomeMenu.setScanner(scan);

		Menu nextMenu = welcomeMenu;

		do {
			nextMenu.displayOptions();

			nextMenu = nextMenu.advance();

		} while (nextMenu != null);

	}

}
