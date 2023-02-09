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

	/**
	 * @author DuyNT58
	 * @Author_birth_date: 1995-01-01
	 * @param candidateId
	 * @TODO add new Certificate for candidate who is in database
	 */
	@Override
	public void saveCertificate(Integer candidateId) {
		Integer id = candidateId;
		boolean check = true;
		Candidate candidate;
		while (check) {
			candidate = candidateRepo.findCandidateById(candidateId);
			if (candidate == null) {
				candidateRepo.sellectAllCandidate().forEach(ItemEvent -> {
					System.out.println(ItemEvent.showInfo());
				});
				System.out.println("Please enter the candidate id that you want add certificate:");
				candidateId = scanner.nextInt();
				if (candidateRepo.findCandidateById(candidateId) == null) {
					System.out.println("No candidate id in database, please enter again!");
					continue;
				}
			} else {
				System.out.println(candidate.showInfo());
				System.out.println("-----ADD CERTIFICATE-----");
				System.out.println("Please enter the certificate name:");
				if (id == -1) {
					scanner.nextLine();
				}
				String name = scanner.nextLine();
				System.out.println("Please enter the certificate rank:");
				String rank = scanner.nextLine();
				System.out.println("Please enter the certificate date:");
				String date = scanner.nextLine();
				certificateRepo.saveCertificate(new Certificated(null, name, rank, date, candidateId));
				System.out.println("Add new certificate for " + candidate.getFullName() + " successfully!!!");
				break;
			}
		}
	}

}
