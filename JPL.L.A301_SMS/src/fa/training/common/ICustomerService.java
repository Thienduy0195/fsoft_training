package fa.training.common;

import java.util.List;

import fa.training.entities.Customer;

public interface ICustomerService {
	List<Customer> getAllCustomer();

	boolean addCustomer();

	boolean updateCustomer();

	boolean deleteCustomer();

	boolean checkExistCustomerInDatabase(Integer id);
}
