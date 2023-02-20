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
	 * @TODO RUN THE PROGRAM
	 */
	public static void main(String[] args) {
		IService service = new ServiceImpl();
		while (true) {
			System.out.println("======MANAGENMENT SYSTEM=====");
			System.out.println("\n1. Add phone into database" + "\n2. Search phone " + "\n3. Exit the program");
			switch (scanner.nextLine()) {
			case "1":
				service.addNew();
				break;
			case "2":
				service.searchOnPr();
				break;
			case "3":
				System.out.println("===PROGRAM HAS FINISHED !!!==");
				System.exit(0);
				break;
			default:
				System.err.println("You have enter a wrong choice, please try again!");
			}
		}
	}

}
