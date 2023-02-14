package main.sevices;

import java.util.List;

import main.entities.Beneficiary;

public interface IService {
	void addNew();

	List<Beneficiary> sellectAll();

	void update();

	void delete();

}
