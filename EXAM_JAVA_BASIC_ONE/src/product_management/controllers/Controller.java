package product_management.controllers;

import product_management.services.IService;
import product_management.services.ServiceImpl;

public class Controller {

	public Controller() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		management();
	}

	static void management() {
		IService service = new ServiceImpl();
		service.addNew();
	}

}
