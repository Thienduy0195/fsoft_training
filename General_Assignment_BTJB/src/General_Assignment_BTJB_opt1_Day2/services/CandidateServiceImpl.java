package General_Assignment_BTJB_opt1_Day2.services;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import General_Assignment_BTJB_opt1_Day2.models.Candidate;
import General_Assignment_BTJB_opt1_Day2.models.CandidateDTO;
import General_Assignment_BTJB_opt1_Day2.repositories.CandidateRepo;
import General_Assignment_BTJB_opt1_Day2.repositories.ICandidateRepo;
import General_Assignment_BTJB_opt1_Day2.utils.comparator.SortCandidateComparator;
import General_Assignment_BTJB_opt1_Day2.utils.exception.BirthDayException;
import General_Assignment_BTJB_opt1_Day2.utils.exception.EmailException;

public class CandidateServiceImpl implements ICandidateService {
	static Scanner inputt = new Scanner(System.in);

	Scanner scanner = new Scanner(System.in);
	CandidateDTO candidateDTO = new CandidateDTO();
	ICandidateRepo candidateRepo = new CandidateRepo();
	ICertificateService certificateService = new CertificateServiceImpl();
	public static final String REGEX_BIRTH_DAY = "^(?:0[1-9]|[12]\\d|3[01])([\\/.-])(?:0[1-9]|1[012])\\1(?:19|20)\\d\\d$";
	public static final String REGEX_EMAIL = "^[A-Za-z0-9+_.-]+@(.+)$"; // check email of person

	public CandidateServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Candidate> getCandidates() {
		List<Candidate> candidates = candidateRepo.sellectAllCandidate();
		Collections.sort(candidates, new SortCandidateComparator());
		if (candidates.isEmpty()) {
			System.out.println("No candidate in databse");
		} else {
			for (Candidate candidate : candidates) {
				System.out.println(candidate.showInfo());
			}
		}
		return candidates;
	}

	@Override
	public StringBuffer getAllCandidateName() {
		return candidateRepo.sellectAllCandidateName();
	}

	@Override
	public void updateCandidate() {
		List<Candidate> candidates = getCandidates();
		System.out.println("Choose the id of the candidate that you want to update:");
		Integer id = inputt.nextInt();
		for (Candidate candidate : candidates) {
			if (candidate.getCandidateID() == id) {
				String[] attributeArrayStrings = candidate.getAttributeName().split(",");
				System.out.println("What value which you want to update?");
				for (int i = 1; i < attributeArrayStrings.length; i++) {
					System.out.println(i + ". " + attributeArrayStrings[i]);
				}
				int no = scanner.nextInt();
				String attribute = attributeArrayStrings[no];
				System.out.println("Please enter new " + attribute);
				scanner.nextLine();
				String value = scanner.nextLine();
				if (value != null) {
					candidateRepo.updateCandidate(id, attribute, value);
				}
				System.out.println("Update " + attribute + " successfully!");
			}
		}
	}

	@Override
	public void addNewCandidate() {
		boolean check = true;
		String choice;
		CandidateServiceImpl candidateServiceImpl = new CandidateServiceImpl();
		while (check) {
			System.out.println("Please enter the candidate type that you want to add new:");
			System.out.println("1.\tExperience candidate\n" + "2.\tFresher candidate\n" + "3.\tIntern candidate\n"
					+ "4.\tReturn to Candidate Management\n" + "5.\tExit\n");
			System.out.println("Input your choice: ");
			choice = scanner.nextLine();
			switch (choice) {
			case "1":
				candidateServiceImpl.addNewExperienceCandidate(Integer.parseInt(choice));
				System.out.println("The number of candidates that you entered: " + Candidate.candidateCount);
				break;
			case "2":
				candidateServiceImpl.addNewFresherCandidate(Integer.parseInt(choice));
				System.out.println("The number of candidates that you entered: " + Candidate.candidateCount);
				break;
			case "3":
				candidateServiceImpl.addNewInternCandidate(Integer.parseInt(choice));
				System.out.println("The number of candidates that you entered: " + Candidate.candidateCount);
				break;
			case "4":
				check = false;
				break;
			case "5":
				System.out.println("You finished the program, thank you! ");
				System.exit(0);
				break;
			default:
				System.err.println("Your choice does not match our options");
			}

		}

	}

	public void addNewExperienceCandidate(Integer candidateTypeId) {
		try {
			candidateDTO.setCandidateTypeId(candidateTypeId);
			System.out.println("Please enter the candidate's name:");
			candidateDTO.setFullName(scanner.nextLine());
			System.out.println("Please enter the candidate's birthdate:");
			String birthDate = scanner.nextLine();
			if (!birthDate.matches(REGEX_BIRTH_DAY)) {
				throw new BirthDayException("Birthdate format is wrong!!!");
			} else {
				candidateDTO.setBirthDate(birthDate);
			}
			System.out.println("Please enter the candidate's phone number:");
			candidateDTO.setPhone(scanner.nextLine());
			System.out.println("Please enter the candidate's email:");
			String email = scanner.nextLine();
			if (!email.matches(REGEX_EMAIL)) {
				throw new EmailException("Email  format is wrong!!!");
			} else {
				candidateDTO.setEmail(email);
			}
			System.out.println("Please enter the candidate's experience year:");
			candidateDTO.setExpInYear(scanner.nextInt());
			scanner.nextLine();
			System.out.println("Please enter the candidate's pro skill:");
			candidateDTO.setProSkill(scanner.nextLine());
			candidateRepo.insertCandidate(candidateDTO);
			Integer id = candidateRepo.getLastCandidateId();
			certificateService.saveCertificate(id);
			Candidate.candidateCount++;
		} catch (Exception e) {
			System.out.println("Loi them moi");
			System.out.println("The system has encountered an unexpected problem, sincerely sorry !!!");
		}
	}

	public void addNewFresherCandidate(Integer candidateTypeId) {
		try {
			candidateDTO.setCandidateTypeId(candidateTypeId);
			System.out.println("Please enter the candidate's name:");
			candidateDTO.setFullName(scanner.nextLine());
			System.out.println("Please enter the candidate's birthdate:");
			String birthDate = scanner.nextLine();
			if (!birthDate.matches(REGEX_BIRTH_DAY)) {
				throw new BirthDayException("Birthdate format is wrong!!!");
			} else {
				candidateDTO.setBirthDate(birthDate);
			}
			System.out.println("Please enter the candidate's phone number:");
			candidateDTO.setPhone(scanner.nextLine());
			System.out.println("Please enter the candidate's email:");
			String email = scanner.nextLine();
			if (!email.matches(REGEX_EMAIL)) {
				throw new EmailException("Email  format is wrong!!!");
			} else {
				candidateDTO.setEmail(email);
			}
			System.out.println("Please enter the graduation date:");
			candidateDTO.setGraduationDate(scanner.nextLine());
			System.out.println("Please enter the graduation rank:");
			candidateDTO.setGraduationRank(scanner.nextLine());
			System.out.println("Please enter the Education:");
			candidateDTO.setEducation(scanner.nextLine());
			if (candidateDTO.getExpInYear() == null) {
				candidateDTO.setExpInYear(0);
			}
			candidateRepo.insertCandidate(candidateDTO);
			Integer id = candidateRepo.getLastCandidateId();
			certificateService.saveCertificate(id);
			Candidate.candidateCount++;
		} catch (Exception e) {
			System.out.println("Loi them moi");
			System.out.println("The system has encountered an unexpected problem, sincerely sorry !!!");
			e.printStackTrace();
		}
	}

	public void addNewInternCandidate(Integer candidateTypeId) {
		try {
			candidateDTO.setCandidateTypeId(candidateTypeId);
			System.out.println("Please enter the candidate's name:");
			candidateDTO.setFullName(scanner.nextLine());
			System.out.println("Please enter the candidate's birthdate:");
			String birthDate = scanner.nextLine();
			if (!birthDate.matches(REGEX_BIRTH_DAY)) {
				throw new BirthDayException("Birthdate format is wrong!!!");
			} else {
				candidateDTO.setBirthDate(birthDate);
			}
			System.out.println("Please enter the candidate's phone number:");
			candidateDTO.setPhone(scanner.nextLine());
			System.out.println("Please enter the candidate's email:");
			String email = scanner.nextLine();
			if (!email.matches(REGEX_EMAIL)) {
				throw new EmailException("Email  format is wrong!!!");
			} else {
				candidateDTO.setEmail(email);
			}
			System.out.println("Please enter the candidate's majors:");
			candidateDTO.setMajors(scanner.nextLine());
			System.out.println("Please enter the semester:");
			candidateDTO.setSemester(scanner.nextLine());
			System.out.println("Please enter the university's name:");
			candidateDTO.setUniversityName(scanner.nextLine());
			if (candidateDTO.getExpInYear() == null) {
				candidateDTO.setExpInYear(0);
			}
			candidateRepo.insertCandidate(candidateDTO);
			Integer id = candidateRepo.getLastCandidateId();
			certificateService.saveCertificate(id);
			Candidate.candidateCount++;
		} catch (Exception e) {
			System.out.println("Loi them moi");
			System.out.println("The system has encountered an unexpected problem, sincerely sorry !!!");
			e.printStackTrace();
		}
	}

	@Override
	public Integer getLastCandidateId() {
		return candidateRepo.getLastCandidateId();
	}

	@Override
	public Candidate finCandidateById(Integer id) {
		return candidateRepo.findCandidateById(id);
	}

}
