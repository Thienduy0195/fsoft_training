package fa.training.main;

import java.util.Scanner;

import fa.training.common.ICustomerService;
import fa.training.common.IOrderService;
import fa.training.common.impl.CustomerService;
import fa.training.common.impl.OrderServiceImpl;

public class SaleManagement {

	public static Scanner scanner = new Scanner(System.in);

	public SaleManagement() {
	}

	public static void main(String[] args) {
		ICustomerService customerService = new CustomerService();
		IOrderService orderService = new OrderServiceImpl();
		while (true) {
			System.out.println("\n1. Display all customer " + "\n2. Add new customer " + "\n3. Delete customer "
					+ "\n4. Update customer " + "\n5. Show all orders by customer id " + "\n6. Add new order "
					+ "\n7. Update order total " + "\n8. Show all line item by order id " + "\n9. Add new line item "
					+ "\n10. Exit program");
			System.out.println("Enter your choice:");
			String choice = scanner.nextLine();
			switch (choice) {
			case "1":
				customerService.getAllCustomer();
				break;
			case "2":
				customerService.addCustomer();
				break;
			case "3":
				customerService.deleteCustomer();
				break;
			case "4":
				customerService.updateCustomer();
				break;
			case "5":
				orderService.getAllOrdersByCustomerId();
				break;
			case "6":
				orderService.addOrder();
				break;
			case "7":
				orderService.updateOrderTotal();
				break;
			case "8":
				orderService.getAllItemsByOrderId();
				break;
			case "9":
				orderService.addLineItem();
				break;
			case "10":
				System.out.println("You finished the program, thank you! ");
				System.exit(0);
				break;
			default:
				System.err.println("You have enter a wrong choice, please try again!");
				choice = scanner.nextLine();
			}
		}

	}

}
