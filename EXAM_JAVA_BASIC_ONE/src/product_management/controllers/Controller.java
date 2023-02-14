package product_management.controllers;

import java.util.Scanner;

import product_management.services.IService;
import product_management.services.ServiceImpl;

public class Controller {

	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		laptopManagement();
	}

	public static void laptopManagement() {
		IService service = new ServiceImpl();
		boolean check = true;
		while (check) {
			System.out.println("\n1. Display list " + "\n2. Add new " + "\n3. Update " + "\n4. Delete "
					+ "\n5. Add new certificate " + "\n6. Return main menu ");
			switch (scanner.nextLine()) {
			case "1":
				service.showInformation(null);
				break;
			case "2":
				service.addNew();
				break;
			case "3":
				service.updatePrice();
				break;
			case "4":
				service.delete();
				break;
//			case "5":
//				certificateService.saveCertificate(-1);
//				break;
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
