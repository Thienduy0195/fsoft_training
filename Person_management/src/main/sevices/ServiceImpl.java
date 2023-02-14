package main.sevices;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import main.entities.Beneficiary;
import main.repositoris.IRepo;
import main.repositoris.RepoImpl;
import main.utils.exception.DuplicateIdException;
import main.utils.exception.IdInvalidException;
import main.utils.exception.PhoneInvalidException;
import main.utils.read_and_write.ReadCSVAndWriteToDatabase;
import main.utils.sort.SortByBenefitDateDescBenefitAsc;

public class ServiceImpl implements IService {

	public static final String REGEX_ID = "^LT+[0-9]{6}$";
	public static final String REGEX_PHONE_NUMBER = "^0+[0-9]{9,10}$";

	IRepo repo = new RepoImpl();
	static Scanner scanner = new Scanner(System.in);

	public ServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addNew() {
		List<Beneficiary> beneficiaries = ReadCSVAndWriteToDatabase.readFile();
		int row = 0;
		for (Beneficiary beneficiary : beneficiaries) {
			boolean flag = true;
			try {
				row++;
				if (!beneficiary.getPhone().matches(REGEX_PHONE_NUMBER)) {
					flag = false;
					throw new PhoneInvalidException("Row " + row + ": Phone is invalid!!");
				}
				if (repo.checkDuplicateId(beneficiary.getId())) {
					flag = false;
					throw new DuplicateIdException(
							"Row " + row + ": Beneficiary " + beneficiary.getId() + " has duplicate!");
				}
				if (checkBirthdate(beneficiary.getBirthdate())) {
					flag = false;
					System.out.println("Row " + row + ": Birthdate must be before current day!");
				}
				if (flag) {
					repo.addNew(beneficiary);
				}
			} catch (IdInvalidException IIE) {
				System.out.println(IIE.getMessage());
			} catch (DuplicateIdException DIE) {
				System.out.println(DIE.getMessage());
			} catch (PhoneInvalidException IIDE) {
				System.out.println(IIDE.getMessage());
			} catch (Exception e) {
				System.out.println("Program have unexpected error occurred!");
			}
			System.out.println(beneficiary.showInfo());
		}

	}

	boolean checkBirthdate(String date) {
		try {
			Date date1 = new Date();
			Date date2 = new SimpleDateFormat("dd/MM/yyyy").parse(date);
			return date1.before(date2);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Beneficiary> sellectAll() {
		List<Beneficiary> beneficiaries = new ArrayList<>();
		beneficiaries = repo.selectAll();
		if (!beneficiaries.isEmpty()) {
			for (Beneficiary beneficiary : beneficiaries) {
				System.out.println(beneficiary.showInfo());
			}
		} else {
			System.out.println("Sorry, no beneficiary in database!");
		}

		return beneficiaries;
	}

	@Override
	public void update() {
		List<Beneficiary> beneficiaries = repo.selectToUpdate();
//		System.out.println(beneficiaries.isEmpty());
		for (Beneficiary beneficiary : beneficiaries) {
			System.out.println(beneficiary.showInfo());
		}
		System.out.println("Please enter the id to update");
		String idString = scanner.nextLine();
		System.out.println("Please enter the addition day you want to update");
		Integer dayInteger = scanner.nextInt();
		repo.update(idString, dayInteger);
		beneficiaries = repo.selectToUpdate();
		Collections.sort(beneficiaries, new SortByBenefitDateDescBenefitAsc());
		for (Beneficiary beneficiary : beneficiaries) {
			System.out.println(beneficiary.showInfo());
		}
	}

	@Override
	public void delete() {
		List<Beneficiary> beneficiaries = repo.delete();
		for (Beneficiary beneficiary : beneficiaries) {
			System.out.println(beneficiary.showInfo());
		}

	}

}
