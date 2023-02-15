package fa.training.dao;

import java.util.List;

import fa.training.entities.LineItem;
import fa.training.entities.Orders;

public interface IOrdersDAO {
	List<Orders> getAllOrdersByCustomerId(Integer customerId);

	Double computeOrderTotal(Integer orderId);

	boolean addOrder(Orders order);

	boolean updateOrderTotal(int orderId);

	boolean addLineItem(LineItem item);

	List<LineItem> getAllItemsByOrderId(Integer orderId);
}
