package main.repositoris;

import java.util.List;

import main.entities.Beneficiary;

public interface IRepo {

	boolean addNew(Beneficiary beneficiary);

	boolean checkDuplicateId(String id);

	List<Beneficiary> selectAll();

	List<Beneficiary> selectToUpdate();

	boolean update(String id, Integer day);

	List<Beneficiary> delete();

}
