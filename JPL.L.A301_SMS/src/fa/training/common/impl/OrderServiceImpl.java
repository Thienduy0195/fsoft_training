package fa.training.common.impl;

import java.util.List;
import java.util.Scanner;

import fa.training.common.ICustomerService;
import fa.training.common.IOrderService;
import fa.training.dao.IOrdersDAO;
import fa.training.dao.impl.OrderDAOImpl;
import fa.training.entities.LineItem;
import fa.training.entities.Orders;

public class OrderServiceImpl implements IOrderService {

	public static Scanner scanner = new Scanner(System.in);

	IOrdersDAO ordersDAO = new OrderDAOImpl();
	ICustomerService customerService = new CustomerService();

	public OrderServiceImpl() {
	}

	@Override
	public List<Orders> getAllOrdersByCustomerId() {
		System.out.println("Please enter the customer id to get order");
		Integer customerId = scanner.nextInt();
		List<Orders> orders = ordersDAO.getAllOrdersByCustomerId(customerId);
		if (orders.isEmpty()) {
			System.out.println("This customer never order before!");
		} else {
			for (Orders orders2 : orders) {
				orders2.setTotal(ordersDAO.computeOrderTotal(orders2.getOrderId()));
				System.out.println(orders2.toString());
			}
		}
		return orders;
	}

	@Override
	public Double computeOrderTotal(Integer orderId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addLineItem() {
		System.out.println("Please enter the order id:");
		Integer orderId = scanner.nextInt();
		System.out.println("Please enter the product id:");
		Integer productId = scanner.nextInt();
		System.out.println("Please enter the quantity of product:");
		Integer quantity = scanner.nextInt();
		System.out.println("Please enter the price of product in order:");
		Double price = scanner.nextDouble();
		LineItem lineItem = new LineItem(orderId, productId, quantity, price);
		if (ordersDAO.addLineItem(lineItem)) {
			System.out.println("Add new line item successfully!");
		} else {
			System.out.println("Add new line item failure!");
		}
		return ordersDAO.addLineItem(lineItem);
	}

	@Override
	public List<LineItem> getAllItemsByOrderId() {
		System.out.println("Please enter the customer id to get order");
		Integer orderId = scanner.nextInt();
		List<LineItem> lineItems = ordersDAO.getAllItemsByOrderId(orderId);
		if (lineItems.isEmpty()) {
			System.out.println("No line item for the order id you entered!");
		} else {
			for (LineItem item : lineItems) {
				System.out.println(item.toString());
			}
		}
		return lineItems;
	}

	@Override
	public boolean addOrder() {
		Orders orders = new Orders();
		System.out.println("Please enter the order date:");
		orders.setOrderDate(scanner.nextLine());
		boolean flag = true;
		while (flag) {
			customerService.getAllCustomer();
			System.out.println("Please enter the customer id:");
			Integer idInteger = scanner.nextInt();
			if (!customerService.checkExistCustomerInDatabase(idInteger)) {
				System.out.println("The customer id is not in database!");
				continue;
			} else {
				orders.setCustomerId(idInteger);
				flag = false;
			}
		}
		System.out.println("Please enter the employee id:");
		orders.setEmployeeId(scanner.nextInt());
		System.out.println("Please enter the order total:");
		orders.setTotal(scanner.nextDouble());
		if (ordersDAO.addOrder(orders)) {
			System.out.println("Add new order successfully!");
		} else {
			System.out.println("Add new order failure!");
		}

		return false;
	}

	@Override
	public boolean updateOrderTotal() {
		System.out.println("Enter order id to update total:");
		Integer orderId = scanner.nextInt();
		if (ordersDAO.updateOrderTotal(orderId)) {
			System.out.println("Update total successfully for order with id= " + orderId);
		}
		return ordersDAO.updateOrderTotal(orderId);
	}

}
