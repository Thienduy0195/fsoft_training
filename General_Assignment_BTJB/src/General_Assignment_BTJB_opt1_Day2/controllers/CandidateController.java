package General_Assignment_BTJB_opt1_Day2.controllers;

import java.util.Scanner;

import General_Assignment_BTJB_opt1_Day2.services.CandidateServiceImpl;
import General_Assignment_BTJB_opt1_Day2.services.CertificateServiceImpl;
import General_Assignment_BTJB_opt1_Day2.services.ICertificateService;

/**
 * @author DuyNT58
 * @Author_birth_date: 1995-01-01
 */
public class CandidateController {
	public static Scanner scanner = new Scanner(System.in);

	public CandidateController() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		candidateManagement();
	}

	public static void candidateManagement() {
		CandidateServiceImpl candidateServiceImpl = new CandidateServiceImpl();
		ICertificateService certificateService = new CertificateServiceImpl();
		boolean check = true;
		while (check) {
			System.out.println("\n1. Display list candidates " + "\n2. Add new candidate " + "\n3. Edit candidate "
					+ "\n4. Show all candidate's name " + "\n5. Add new certificate " + "\n6. Return main menu ");
			switch (scanner.nextLine()) {
			case "1":
				candidateServiceImpl.getCandidates();
				break;
			case "2":
				candidateServiceImpl.addNewCandidate();
				break;
			case "3":
				candidateServiceImpl.updateCandidate();
				break;
			case "4":
				candidateServiceImpl.getAllCandidateName();
				break;
			case "5":
				certificateService.saveCertificate(-1);
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
