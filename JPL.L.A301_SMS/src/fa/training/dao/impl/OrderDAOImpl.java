package fa.training.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import fa.training.dao.ConnectionJDBC;
import fa.training.dao.IOrdersDAO;
import fa.training.entities.LineItem;
import fa.training.entities.Orders;

public class OrderDAOImpl implements IOrdersDAO {

	Scanner scanner = new Scanner(System.in);

	protected final String SELECT_ORDER_BY_CSM_ID = "select * from Orders where CustomerId=?;";
	protected final String ADD_NEW_ORDER_SQL = "insert into Orders(orderDate,customerId,employeeId,total) values(?, ?, ?, ?);";
	protected final String ADD_NEW_LINE_ITEM_SQL = "insert into LineItem(orderId,productId,quantity,price) values(?, ?, ?, ?);";
	protected final String UPDATE_ORDER_TOTAL_SQL = "update Orders set total = ? where orderId = ?;";
	protected final String SELECT_LINE_ITEM_BY_ORDER_ID = "select * from LineItem where OrderId=?;";
	protected final String COMPUTE_ORDER_TOTAL = "select sum(price) as total_price from LineItem where orderId = ? group by orderId;";

	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;

	public OrderDAOImpl() {
	}

	@Override
	public List<Orders> getAllOrdersByCustomerId(Integer customerId) {
		List<Orders> orders = new ArrayList<>();
		try {
			connection = ConnectionJDBC.getConnection();
			preparedStatement = connection.prepareStatement(SELECT_ORDER_BY_CSM_ID);
			preparedStatement.setInt(1, customerId);
			resultSet = preparedStatement.executeQuery();
			Orders order;
			while (resultSet.next()) {
				order = new Orders(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3),
						resultSet.getInt(4), resultSet.getDouble(5));
				orders.add(order);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
				preparedStatement.close();
				resultSet.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return orders;
	}

	@Override
	public Double computeOrderTotal(Integer orderId) {
		Double totalDouble = 0.0;
		try {
			connection = ConnectionJDBC.getConnection();
			preparedStatement = connection.prepareStatement(COMPUTE_ORDER_TOTAL);
			preparedStatement.setInt(1, orderId);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				totalDouble = resultSet.getDouble(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
				preparedStatement.close();
				resultSet.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return totalDouble;
	}

	@Override
	public boolean addOrder(Orders order) {
		boolean updatedRow = false;
		try {
			connection = ConnectionJDBC.getConnection();
			preparedStatement = connection.prepareStatement(ADD_NEW_ORDER_SQL);
			connection.setAutoCommit(false);
			preparedStatement.setString(1, order.getOrderDate());
			preparedStatement.setInt(2, order.getCustomerId());
			preparedStatement.setInt(3, order.getEmployeeId());
			preparedStatement.setDouble(4, order.getTotal());
			connection.commit();
			updatedRow = preparedStatement.executeUpdate() > 0;
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		} finally {
			try {
				connection.close();
				preparedStatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return updatedRow;
	}

	@Override
	public boolean updateOrderTotal(int orderId) {
		Double orderTotal = computeOrderTotal(orderId);
		boolean updateRow = false;
		try {
			connection = ConnectionJDBC.getConnection();
			preparedStatement = connection.prepareStatement(UPDATE_ORDER_TOTAL_SQL);
			preparedStatement.setDouble(1, orderTotal);
			preparedStatement.setInt(2, orderId);
			updateRow = preparedStatement.executeUpdate() > 0;
		} catch (Exception e) {
			System.out.println("Error at updateCandidate in CandidateRepo");
			e.printStackTrace();
		} finally {
			try {
				connection.close();
				preparedStatement.close();
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return updateRow;
	}

	@Override
	public boolean addLineItem(LineItem item) {
		boolean updatedRow = false;
		try {
			connection = ConnectionJDBC.getConnection();
			preparedStatement = connection.prepareStatement(ADD_NEW_LINE_ITEM_SQL);
			connection.setAutoCommit(false);
			preparedStatement.setInt(1, item.getOrderId());
			preparedStatement.setInt(2, item.getProductId());
			preparedStatement.setInt(3, item.getQuantity());
			preparedStatement.setDouble(4, item.getPrice());
			updatedRow = preparedStatement.executeUpdate() > 0;
			connection.commit();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		} finally {
			try {
				connection.close();
				preparedStatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return updatedRow;
	}

	@Override
	public List<LineItem> getAllItemsByOrderId(Integer orderId) {
		List<LineItem> lineItems = new ArrayList<>();
		try {
			connection = ConnectionJDBC.getConnection();
			preparedStatement = connection.prepareStatement(SELECT_LINE_ITEM_BY_ORDER_ID);
			preparedStatement.setInt(1, orderId);
			resultSet = preparedStatement.executeQuery();
			LineItem lineItem;
			while (resultSet.next()) {
				lineItem = new LineItem(resultSet.getInt(1), resultSet.getInt(2), resultSet.getInt(3),
						resultSet.getDouble(4));
				lineItems.add(lineItem);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
				preparedStatement.close();
				resultSet.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return lineItems;
	}

}
