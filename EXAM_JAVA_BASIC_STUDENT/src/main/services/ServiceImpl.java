package main.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import main.entities.GoodStudent;
import main.entities.NormalStudent;
import main.entities.Student;
import main.repotisory.IRepository;
import main.repotisory.RepositoryImpl;
import main.utils.exception.InvalidDoBException;
import main.utils.exception.InvalidFullNameException;
import main.utils.exception.InvalidPhoneNumberException;
import main.utils.read_and_write.ReadCSVAndWriteToDatabase;
import main.utils.sort.SortByFullNameDescAndPhoneNumberAsc;
import main.utils.sort.SortGoodStudentGpaDescFullNameDesc;
import main.utils.sort.SortNormalStudentEntryScoreDescTOEICDesc;
import main.utils.validator.Validate;

public class ServiceImpl implements IService {
	int row = 0;
	IRepository repository = new RepositoryImpl();
	static Scanner scanner = new Scanner(System.in);

	/**
	 * @author DuyNT58
	 * @Author_birth_date: 1995-01-01
	 * @TODO insert student which have all valid value into database
	 */
	@Override
	public void addNew() {
		List<Student> students = ReadCSVAndWriteToDatabase.readGoodStudentFile();
		int count = 1;
		for (Student student : students) {
			System.out.println(count + "" + student.showMyInfo());
			count++;
		}
		if (students.isEmpty()) {
			System.out.println("No student in csv File");
		} else {
			students.forEach(item -> {
				row++;
				try {
					if (!Validate.checkFullName(item.getFullName())) {
						throw new InvalidFullNameException("Invalid fullname at row " + row);
					}
					if (!Validate.checkPhoneNumber(item.getPhoneNumber())) {
						throw new InvalidPhoneNumberException("Invalid phone number at row " + row);
					}
					if (!Validate.checkBirthday(item.getDoB())) {
						throw new InvalidDoBException("Invalid date of birth at row " + row);
					} else {
						item.setDoB(Validate.setFormatForDate(item.getDoB()));
					}
					repository.addNew(item);
				} catch (InvalidFullNameException e1) {
					System.out.println(e1.getMessage());
				} catch (InvalidPhoneNumberException e2) {
					System.out.println(e2.getMessage());
				} catch (InvalidDoBException e) {
					System.out.println(e.getMessage());
				} catch (Exception e3) {
					System.out.println("Error at add new in servic");
					e3.printStackTrace();
				}

			});
		}

	}

	/**
	 * @author DuyNT58
	 * @Author_birth_date: 1995-01-01
	 * @TODO show all student from database
	 */
	@Override
	public void showInfoFromDatabase() {
		List<Student> students = repository.sellectAll();
		if (students.isEmpty()) {
			System.out.println("No student in database, please insert student!");
		} else {
			Collections.sort(students, new SortByFullNameDescAndPhoneNumberAsc());
			System.out.println("=====LIST STUDENT=====");
			students.forEach(item -> System.out.println(item.showMyInfo()));
		}
	}

	/**
	 * @author DuyNT58
	 * @Author_birth_date: 1995-01-01
	 * @TODO get pass candidate from the number client enter
	 */
	@Override
	public void selectPassCandidate() {
		List<Student> students = new ArrayList<>();
		List<GoodStudent> goodStudents = new ArrayList<>();
		List<NormalStudent> normalStudents = new ArrayList<>();
		repository.sellectAll().forEach(item -> {
			if (item instanceof GoodStudent) {
				goodStudents.add((GoodStudent) item);
			} else {
				normalStudents.add((NormalStudent) item);
			}
		});
		Collections.sort(goodStudents, new SortGoodStudentGpaDescFullNameDesc());
		Collections.sort(normalStudents, new SortNormalStudentEntryScoreDescTOEICDesc());
		boolean flag = true;
		while (flag) {
			try {
				System.out.println("Please enter the number of candidate for application:");
				Integer number = Integer.parseInt(scanner.nextLine());
				if (number < 0) {
					throw new NumberFormatException("Please enter a positive number!");
				}
				if (number < 11 || number > 15) {
					System.out.println("Number of pass candidate is from 11 to 15!");
					continue;
				}
				if (number <= goodStudents.size()) {
					students.addAll(goodStudents.subList(0, number));
				} else {
					students.addAll(goodStudents);
					if (number - goodStudents.size() < normalStudents.size()) {
						students.addAll(normalStudents.subList(0, number - goodStudents.size()));
					} else {
						students.addAll(normalStudents);
					}
				}
				System.out.println("=====LIST PASS CANDIDATE=====");
				for (Student student : students) {
					System.out.println(student.showMyInfo());
				}
				flag = false;
			} catch (NumberFormatException e) {
				flag = true;
				System.out.println("Please enter a positive number!");
				System.out.println(e.getMessage());
			}
		}

	}

}
