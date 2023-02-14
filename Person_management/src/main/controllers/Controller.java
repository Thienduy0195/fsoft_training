package main.controllers;

import java.util.Scanner;

import main.sevices.IService;
import main.sevices.ServiceImpl;

public class Controller {

	public static Scanner scanner = new Scanner(System.in);

	public Controller() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		management();
	}

	static void management() {
		IService service = new ServiceImpl();
		boolean check = true;
		while (check) {
			System.out.println("\n1. Display list from database " + "\n2. Add new from csv file " + "\n3. Update "
					+ "\n4. Show all candidate's name " + "\n5. Delete " + "\n6. Return main menu ");
			switch (scanner.nextLine()) {
			case "1":
				service.sellectAll();
				break;
			case "2":
				service.addNew();
				break;
			case "3":
				service.update();
				break;
//			case "4":
//				candidateServiceImpl.getAllCandidateName();
//				break;
			case "5":
				service.delete();
				break;
			case "6":
				System.out.println("You finished the program, thank you! ");
				System.exit(0);
				break;
			default:
				System.err.println("You have enter a wrong choice, please try again!");
				scanner.nextLine();
			}
		}

	}
}
