package fa.training.common;

import java.util.List;

import fa.training.entities.LineItem;
import fa.training.entities.Orders;

public interface IOrderService {
	List<Orders> getAllOrdersByCustomerId();

	Double computeOrderTotal(Integer orderId);

	boolean addOrder();

	boolean updateOrderTotal();

	boolean addLineItem();

	List<LineItem> getAllItemsByOrderId();

}
