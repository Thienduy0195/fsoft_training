package main.utils.sort;

import java.util.Comparator;

import main.entities.NormalStudent;

public class SortNormalStudentEntryScoreDescTOEICDesc implements Comparator<NormalStudent> {

	public SortNormalStudentEntryScoreDescTOEICDesc() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int compare(NormalStudent o1, NormalStudent o2) {
		if (o2.getEntryTestScore().compareTo(o1.getEntryTestScore()) == 0) {
			return o2.getEnglishScore().compareTo(o1.getEnglishScore());
		}
		return o2.getEntryTestScore().compareTo(o1.getEntryTestScore());
	}

}
