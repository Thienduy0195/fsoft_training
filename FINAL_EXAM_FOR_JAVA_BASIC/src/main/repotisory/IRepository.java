package main.repotisory;

import java.util.List;

import main.entities.Phone;

/**
 * @author DuyNT58
 * @Author_birth_date: 1995-01-01
 */
public interface IRepository {
	boolean addNew(Phone laptop);

	boolean checkDuplicateId(String id);

	boolean delete(String id);

	List<Phone> search(Double min, Double max);
}
