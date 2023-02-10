package product_management.repository;

import product_management.entities.Laptop;

public interface IRepo {

	boolean addNew(Laptop laptop);

	boolean checkDuplicateId(String id);

}
