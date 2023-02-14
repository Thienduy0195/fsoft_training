package product_management.services;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import product_management.entities.Laptop;
import product_management.repository.IRepo;
import product_management.repository.RepoImpl;
import product_management.utils.exception.DuplicateIdException;
import product_management.utils.exception.IdInvalidException;
import product_management.utils.exception.InvalidImportDateException;
import product_management.utils.read_and_write.ReadCSVAndWriteToDatabase;
import product_management.utils.sort.SortByBrandAscPriceDesc;
import product_management.utils.validates.Validate;

public class ServiceImpl implements IService {

	IRepo repo = new RepoImpl();
	static Scanner scanner = new Scanner(System.in);

	/**
	 * @author DuyNT58
	 * @Author_birth_date: 1995-01-01
	 * @TODO read line from csv file and insert in to db
	 */
	@Override
	public void addNew() {
		List<Laptop> laptops = ReadCSVAndWriteToDatabase.readFile();
		int row = 0;
		for (Laptop laptop : laptops) {
			boolean flag = true;
			try {
				row++;
				if (Validate.checkValidIId(laptop.getLaptopId())) {
					flag = false;
					throw new IdInvalidException("Laptop id at row " + row + " is in correct!!");
				}
				if (repo.checkDuplicateId(laptop.getLaptopId())) {
					flag = false;
					throw new DuplicateIdException("Laptop " + laptop.getLaptopId() + " has duplicate!");
				}
				if (Validate.checkImportDate(laptop.getImportDate())) {
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

	/**
	 * @author DuyNT58
	 * @Author_birth_date: 1995-01-01
	 * @param laptops
	 * @TODO show laptop information which get from db
	 */
	@Override
	public void showInformation(List<Laptop> laptops) {
		laptops = repo.sellectAll();
		for (Laptop laptop : laptops) {
			System.out.println(laptop.showInfo());
		}

	}

	/**
	 * @author DuyNT58
	 * @Author_birth_date: 1995-01-01
	 * @TODO update price of lap top base on the discount board
	 */
	@Override
	public void updatePrice() {
		boolean check = true;
		while (check) {
			System.out.println("Please enter the brand:");
			String brand = scanner.nextLine();
			if (Validate.discountBoard.keySet().contains(brand.toUpperCase())) {
				if (!repo.updatePrice(Validate.discountBoard.get(brand.toUpperCase()), brand)) {
					System.out.println("Your input brand does not have any data in database!");
				} else {
					System.out.println("Update price with discount " + Validate.discountBoard.get(brand.toUpperCase())
							+ " for brand " + brand.toUpperCase() + " successfully!");
					List<Laptop> laptops = repo.sellectAll();
					Collections.sort(laptops, new SortByBrandAscPriceDesc());
					for (Laptop laptop : laptops) {
//						if (laptop.getBrand().toUpperCase().equals(brand.toUpperCase())) {
//							System.out.println(laptop.showInfo());
//						}
						System.out.println(laptop.showInfo());
					}
				}
				check = false;
			} else {
				System.out.println("Brand is invalid!");
			}
		}
	}

	@Override
	public void delete() {
		repo.delete();
		List<Laptop> laptops = repo.sellectAll();
		for (Laptop laptop : laptops) {
			System.out.println(laptop.showInfo());
		}

	}

}
