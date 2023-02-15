package fa.training.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fa.training.dao.ConnectionJDBC;
import fa.training.dao.ICustomerDAO;
import fa.training.entities.Customer;

public class CustomerDAOImpl implements ICustomerDAO {

	protected final String SELECT_CUSTOMER = "select * from Customer;";

	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;

	@Override
	public List<Customer> getAllCustomer() {
		List<Customer> customers = new ArrayList<>();
		try {
			connection = ConnectionJDBC.getConnection();
			preparedStatement = connection.prepareStatement(SELECT_CUSTOMER);
			resultSet = preparedStatement.executeQuery();
			Customer customer;
			while (resultSet.next()) {
				customer = new Customer(resultSet.getInt(1), resultSet.getString(2));
				customers.add(customer);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return customers;
	}

	@Override
	public boolean addCustomer(Customer customer) {
		boolean rowInsert = false;
		CallableStatement callableStatement = null;
		try {
			connection = ConnectionJDBC.getConnection();
			callableStatement = connection.prepareCall("{call addCustomer(?)}");
			callableStatement.setString(1, customer.getCustomerName());
			callableStatement.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
				callableStatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return rowInsert;
	}

	@Override
	public boolean deleteCustomer(Integer customerId) {
		boolean rowInsert = false;
		CallableStatement callableStatement = null;
		try {
			connection = ConnectionJDBC.getConnection();
			callableStatement = connection.prepareCall("{call DeleteCustomerAndRelationalObject(?)}");
			callableStatement.setInt(1, customerId);
			callableStatement.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
				callableStatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return rowInsert;
	}

	@Override
	public boolean updateCustomer(Customer customer) {
		boolean rowInsert = false;
		CallableStatement callableStatement = null;
		try {
			connection = ConnectionJDBC.getConnection();
			callableStatement = connection.prepareCall("{call updateCustomer(?,?)}");
			callableStatement.setString(1, customer.getCustomerName());
			callableStatement.setInt(2, customer.getCustomerId());
			callableStatement.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
				callableStatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return rowInsert;
	}

}
