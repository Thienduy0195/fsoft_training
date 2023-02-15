package fa.training.dao;

import java.util.List;

import fa.training.entities.Customer;

public interface ICustomerDAO {
	List<Customer> getAllCustomer();

	boolean addCustomer(Customer customer);

	boolean deleteCustomer(Integer customerId);

	boolean updateCustomer(Customer customer);
}
