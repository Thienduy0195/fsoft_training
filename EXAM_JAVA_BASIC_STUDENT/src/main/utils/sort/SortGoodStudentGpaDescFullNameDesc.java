package main.utils.sort;

import java.util.Comparator;

import main.entities.GoodStudent;

public class SortGoodStudentGpaDescFullNameDesc implements Comparator<GoodStudent> {

	public SortGoodStudentGpaDescFullNameDesc() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int compare(GoodStudent o1, GoodStudent o2) {
		if (o2.getGpa().compareTo(o1.getGpa()) == 0) {
			return o2.getFullName().compareTo(o1.getFullName());
		}
		return o2.getGpa().compareTo(o1.getGpa());
	}

}
