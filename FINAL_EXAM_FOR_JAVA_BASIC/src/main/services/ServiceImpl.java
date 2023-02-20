package main.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import main.entities.ForeignPhone;
import main.entities.HomePhone;
import main.entities.OldPhone;
import main.entities.Phone;
import main.repotisory.IRepository;
import main.repotisory.RepositoryImpl;
import main.utils.exception.DuplicateIdException;
import main.utils.exception.PhoneException;
import main.utils.read_and_write.ReadCSVAndWriteToDatabase;
import main.utils.validator.Validate;

/**
 * @author DuyNT58
 * @Author_birth_date: 1995-01-01
 */
public class ServiceImpl implements IService {

	static IRepository repository = new RepositoryImpl();
	static Scanner scanner = new Scanner(System.in);
	static List<Phone> phones;
	Phone phoneSearch;
	int num = 0;

	@Override
	public void addNew() {
		List<Phone> phones = ReadCSVAndWriteToDatabase.readFile();
		phones.forEach(item -> System.out.println(item.showInfo()));
		if (phones.isEmpty()) {
			System.out.println("Not found phone in text file");
		} else {
			int row = 0;
			for (Phone phone : phones) {
				try {
					row++;
					if (!Validate.checkValidId(phone.getId())) {
						throw new PhoneException("ROW " + row + ": ID " + phone.getId() + " is invalid!");
					}
					if (Validate.checkDuplicatedId(phone.getId())) {
						throw new DuplicateIdException("ROW " + row + ": ID " + phone.getId() + " is duplicated!");
					}
					if (!Validate.checkRangeAndStatus(phone)) {
						throw new PhoneException(
								"ROW " + row + ": Range / Status of ID " + phone.getId() + " is invalid!");
					}
					repository.addNew(phone);
				} catch (PhoneException e1) {
					System.out.println(e1.getMessage());
				} catch (DuplicateIdException e2) {
					System.out.println(e2.getMessage());
				} catch (Exception e3) {
					System.out.println("Program have an unexpected error occurred!!");
				}
			}
			System.out.println("Add data from text file into database successfully!!");
		}
	}

	/**
	 * @author DuyNT58
	 * @Author_birth_date: 1995-01-01
	 * @param id
	 * @TODO delete after customer buy phone
	 */
	@Override
	public void delete(String id) {
		if (repository.delete(id)) {
			System.out.println("Thank you for buying this phone!");
		} else {
			System.out.println("Phone is not available!");
		}
	}

	/**
	 * @author DuyNT58
	 * @Author_birth_date: 1995-01-01
	 * @TODO search phone base on the price client input
	 */
	@Override
	public void searchOnPr() {
		System.out.println("===== SEARCH PHONE =====");
		boolean flag = true;
		while (flag) {
			phones = new ArrayList<>();
			try {
				System.out.println("Please enter the min price:");
				Double min = Double.parseDouble(scanner.nextLine());
				System.out.println("Please enter the max price:");
				Double max = Double.parseDouble(scanner.nextLine());
				phones = repository.search(min, max);
				flag = false;
				if (phones.isEmpty()) {
					System.out.println("No phone is found base on the price that you put in!");
				} else {

					Collections.sort(phones, new Comparator<Phone>() {
						@Override
						public int compare(Phone o1, Phone o2) {
							if (o1.getPrice().compareTo(o2.getPrice()) == 0) {
								return o2.getStorage().compareTo(o1.getStorage());
							}
							return o1.getPrice().compareTo(o2.getPrice());
						}
					});

					phones.forEach(phone -> {
						num++;
						System.out.println(num + ". " + phone.showInfo());
					});

					System.out.println("Please choose the phone which you want to buy: (Enter from 1 to "
							+ phones.size() + " to get phone, Enter 0 to EXIT)");
					Integer choiceInteger = Integer.parseInt(scanner.nextLine());
					if (choiceInteger == 0) {
						num = 0;
						break;
					} else {
						phoneSearch = phones.get(choiceInteger - 1);
						if (phoneSearch instanceof HomePhone) {
							delete(phoneSearch.getId());
							System.out.println(phones.get(choiceInteger - 1).showInfo());
						} else {
							System.out.println(
									"The auth phone have 7 days warranty only, do you want to buy the 1 year wanrranty in addition? (Y/N):");
							while (true) {
								switch (scanner.nextLine().toUpperCase()) {
								case "Y": {
									phoneSearch.setPrice(updatePriceWarrantty(phoneSearch));
									delete(phoneSearch.getId());
									System.out.println(phoneSearch.showInfo());
									break;
								}
								case "N": {
									delete(phoneSearch.getId());
									System.out.println(phoneSearch.showInfo());
									break;
								}
								default:
									System.err.println("Please choose 'Y' or 'N' !");
								}
							}
						}
					}

				}
			} catch (NumberFormatException e) {
				flag = true;
				System.err.println("Please enter an positive number!");
			} catch (IndexOutOfBoundsException e1) {
				flag = true;
				System.err.println("The phone with your choice is not in search list, please search again!");
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public Double updatePriceWarrantty(Phone phone) {
		if (phone instanceof ForeignPhone) {
			ForeignPhone foreignPhone = (ForeignPhone) phone;
			foreignPhone.setPriceWarranty(foreignPhone.getPrice() * Validate.priceWarrantyMap.get("Foreign"));
			return foreignPhone.getPrice() + foreignPhone.getPriceWarranty();
		} else if (phone instanceof OldPhone) {
			OldPhone oldPhone = (OldPhone) phone;
			oldPhone.setPriceWarranty(oldPhone.getPriceWarranty() * Validate.priceWarrantyMap.get("OldPhone"));
			return oldPhone.getPrice() + oldPhone.getPriceWarranty();
		}
		return 0.0;
	}
}
