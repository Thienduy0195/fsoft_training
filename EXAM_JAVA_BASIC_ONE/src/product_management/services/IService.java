package product_management.services;

import java.util.List;

import product_management.entities.Laptop;

public interface IService {
	void addNew();

	void showInformation(List<Laptop> laptops);

	void updatePrice();

	void delete();
}
