package main.controller;

import java.util.Scanner;

import main.services.IService;
import main.services.ServiceImpl;

public class Controller {

	public static Scanner scanner = new Scanner(System.in);

	/**
	 * @author DuyNT58
	 * @Author_birth_date: 1995-01-01
	 * @param args
	 * @TODO run the program
	 */
	public static void main(String[] args) {
		IService service = new ServiceImpl();
		while (true) {
			System.out.println("======MANAGENMENT SYSTEM=====");
			System.out.println("\n1. Display All Information " + "\n2. Add new " + "\n3. Sellect pass candidate "
					+ "\n4. Exit the program");
			switch (scanner.nextLine()) {
			case "1":
				service.showInfoFromDatabase();
				break;
			case "2":
				service.addNew();
				break;
			case "3":
				service.selectPassCandidate();
				break;
			case "4":
				System.out.println("===PROGRAM HAS FINISHED !!!==");
				System.exit(0);
				break;
			default:
				System.err.println("You have enter a wrong choice, please try again!");
			}
		}
	}

}
