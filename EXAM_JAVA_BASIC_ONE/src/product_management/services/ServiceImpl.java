package product_management.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import product_management.entities.Laptop;
import product_management.repository.IRepo;
import product_management.repository.RepoImpl;
import product_management.utils.exception.DuplicateIdException;
import product_management.utils.exception.IdInvalidException;
import product_management.utils.exception.InvalidImportDateException;
import product_management.utils.read_and_write.ReadCSVAndWriteToDatabase;

public class ServiceImpl implements IService {

	public static final String REGEX_ID = "^LT+[0-9]{6}$"; // check email of person

	IRepo repo = new RepoImpl();
	static Scanner scanner = new Scanner(System.in);

	public ServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addNew() {
		List<Laptop> laptops = ReadCSVAndWriteToDatabase.readFile();
		int row = 0;
		for (Laptop laptop : laptops) {
			boolean flag = true;
			try {
				row++;
				if (!laptop.getLaptopId().matches(REGEX_ID)) {
					flag = false;
					throw new IdInvalidException("Laptop id at row " + row + " is in correct!!");
				}
				if (repo.checkDuplicateId(laptop.getLaptopId())) {
					flag = false;
					throw new DuplicateIdException("Laptop " + laptop.getLaptopId() + " has duplicate!");
				}
				if (checkImportDate(laptop.getImportDate())) {
					flag = false;
					throw new InvalidImportDateException("Import date of row " + row + " are greater than today!");
				}
				if (flag) {
					repo.addNew(laptop);
				}
			} catch (IdInvalidException IIE) {
				System.out.println(IIE.getMessage());
			} catch (DuplicateIdException DIE) {
				System.out.println(DIE.getMessage());
			} catch (InvalidImportDateException IIDE) {
				System.out.println(IIDE.getMessage());
			} catch (Exception e) {
				System.out.println("Program have unexpected error occurred!");
			}
		}

	}

	boolean checkImportDate(String date) {
		try {
			Date date1 = new Date();
			Date date2 = new SimpleDateFormat("dd/MM/yyyy").parse(date);
			return date1.before(date2);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return false;
	}

}
