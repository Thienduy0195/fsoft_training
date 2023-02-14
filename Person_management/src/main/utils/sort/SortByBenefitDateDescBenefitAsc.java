package main.utils.sort;

import java.util.Comparator;

import main.entities.Beneficiary;

public class SortByBenefitDateDescBenefitAsc implements Comparator<Beneficiary> {

	public SortByBenefitDateDescBenefitAsc() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int compare(Beneficiary o1, Beneficiary o2) {
		if (o1.getBenefitDate().compareTo(o2.getBenefitDate()) > 0) {
			return o1.getBenefit().compareTo(o2.getBenefit());
		}
		return o1.getBenefitDate().compareTo(o2.getBenefitDate());

	}

}
