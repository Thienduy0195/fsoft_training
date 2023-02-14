package product_management.repository;

import java.util.List;

import product_management.entities.Laptop;

public interface IRepo {

	boolean addNew(Laptop laptop);

	boolean checkDuplicateId(String id);

	List<Laptop> sellectAll();

	boolean updatePrice(Double discount, String brand);

	boolean delete();

}
