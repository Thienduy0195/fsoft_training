package General_Assignment_BTJB_opt1_Day2.services;

import java.util.Scanner;

import General_Assignment_BTJB_opt1_Day2.models.Candidate;
import General_Assignment_BTJB_opt1_Day2.models.Certificated;
import General_Assignment_BTJB_opt1_Day2.repositories.CandidateRepo;
import General_Assignment_BTJB_opt1_Day2.repositories.CertificateRepo;
import General_Assignment_BTJB_opt1_Day2.repositories.ICandidateRepo;
import General_Assignment_BTJB_opt1_Day2.repositories.ICertificateRepo;

public class CertificateServiceImpl implements ICertificateService {

	ICertificateRepo certificateRepo = new CertificateRepo();
	ICandidateRepo candidateRepo = new CandidateRepo();
	static Scanner scanner = new Scanner(System.in);

	@Override
	public void saveCertificate(Integer candidateId) {
		boolean check = true;
		while (check) {
			if (candidateId == null) {
				System.out.println("Please enter the candidate id that you want add certificate:");
				candidateId = scanner.nextInt();
				Candidate candidate = candidateRepo.findCandidateById(candidateId);
				if (candidate != null) {
					System.out.println(candidate.showInfo());
					check = false;
				} else {
					System.out.println("No candidate id in database, please enter again!");
					check = true;
				}
			} else {
				check = false;
			}
		}
		System.out.println("-----ADD CERTIFICATE-----");
		System.out.println("Please enter the certificate name:");
		String name = scanner.nextLine();
		System.out.println("Please enter the certificate rank:");
		String rank = scanner.nextLine();
		System.out.println("Please enter the certificate date:");
		String date = scanner.nextLine();
		certificateRepo.saveCertificate(new Certificated(null, name, rank, date, candidateId));
		System.out.println("Add new certificate successfully!!!");

	}

}
