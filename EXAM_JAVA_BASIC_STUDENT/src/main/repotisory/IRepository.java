package main.repotisory;

import java.util.List;

import main.entities.Student;

public interface IRepository {
	boolean addNew(Student student);

	List<Student> sellectAll();

}
