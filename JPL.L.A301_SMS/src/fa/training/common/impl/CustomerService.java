package fa.training.common.impl;

import java.util.List;
import java.util.Scanner;

import fa.training.common.ICustomerService;
import fa.training.dao.ICustomerDAO;
import fa.training.dao.impl.CustomerDAOImpl;
import fa.training.entities.Customer;

public class CustomerService implements ICustomerService {

	Scanner scanner = new Scanner(System.in);

	ICustomerDAO customerRepository = new CustomerDAOImpl();

	public CustomerService() {
	}

	@Override
	public List<Customer> getAllCustomer() {
		List<Customer> customers = customerRepository.getAllCustomer();
		for (Customer customer : customers) {
			System.out.println(customer.toString());
		}
		return customers;
	}

	@Override
	public boolean checkExistCustomerInDatabase(Integer id) {
		for (Customer item : getAllCustomer()) {
			if (item.getCustomerId() == id) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean addCustomer() {
		Customer customer = new Customer();
		System.out.println("Please enter customer name:");
		customer.setCustomerName(scanner.nextLine());
		if (customerRepository.addCustomer(customer)) {
			System.out.println("Add new customer successfully!");
		} else {
			System.out.println("Add new customer failure!");
		}
		;
		return false;
	}

	@Override
	public boolean deleteCustomer() {
		System.out.println("Please enter customer id:");
		Integer idInteger = scanner.nextInt();
		if (customerRepository.deleteCustomer(idInteger)) {
			System.out.println("Delete customer successfully!");
		} else {
			System.out.println("Delete customer failure!");
		}
		return true;
	}

	@Override
	public boolean updateCustomer() {
		System.out.println("Please enter customer id to update:");
		Integer idInteger = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Please enter new customer name:");
		String nameString = scanner.nextLine();
		Customer customer = new Customer(idInteger, nameString);
		if (customerRepository.updateCustomer(customer)) {
			System.out.println("Update new name " + nameString + " for customer with id " + idInteger);
		} else {
			System.out.println("Update customer failure!");
		}
		return customerRepository.updateCustomer(customer);
	}

}
