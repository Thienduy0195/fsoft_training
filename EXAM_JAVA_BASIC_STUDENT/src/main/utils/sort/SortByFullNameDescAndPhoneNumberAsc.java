package main.utils.sort;

import java.util.Comparator;

import main.entities.Student;

public class SortByFullNameDescAndPhoneNumberAsc implements Comparator<Student> {

	public SortByFullNameDescAndPhoneNumberAsc() {
	}

	@Override
	public int compare(Student o1, Student o2) {
		if (o2.getFullName().compareTo(o1.getFullName()) == 0) {
			return o1.getPhoneNumber().compareTo(o2.getPhoneNumber());
		}
		return o2.getFullName().compareTo(o1.getFullName());
	}

}
