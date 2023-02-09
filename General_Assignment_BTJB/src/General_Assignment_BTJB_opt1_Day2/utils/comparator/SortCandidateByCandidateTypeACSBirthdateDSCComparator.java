package General_Assignment_BTJB_opt1_Day2.utils.comparator;

import java.util.Comparator;

import General_Assignment_BTJB_opt1_Day2.models.Candidate;

/**
 * @author DuyNT58
 * @Author_birth_date: 1995-01-01
 */
public class SortCandidateByCandidateTypeACSBirthdateDSCComparator implements Comparator<Candidate> {

	public SortCandidateByCandidateTypeACSBirthdateDSCComparator() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int compare(Candidate o1, Candidate o2) {
		int candidateTypeCompare = o1.getCandidateTypeId().compareTo(o2.getCandidateTypeId());
		int birthdateCompare = o1.getBirthDate().compareTo(o2.getBirthDate());
		return (candidateTypeCompare == 0) ? birthdateCompare : candidateTypeCompare;
	}

}
