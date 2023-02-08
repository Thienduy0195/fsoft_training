package General_Assignment_BTJB_opt1_Day2.services;

import java.util.List;

import General_Assignment_BTJB_opt1_Day2.models.Candidate;

public interface ICandidateService {

	List<Candidate> getCandidates();

	StringBuffer getAllCandidateName();

	public void addNewCandidate();

	void updateCandidate();

	Integer getLastCandidateId();

	Candidate finCandidateById(Integer id);

}
