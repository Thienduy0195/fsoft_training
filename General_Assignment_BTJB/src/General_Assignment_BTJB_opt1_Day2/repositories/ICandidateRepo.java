package General_Assignment_BTJB_opt1_Day2.repositories;

import java.util.List;

import General_Assignment_BTJB_opt1_Day2.models.Candidate;
import General_Assignment_BTJB_opt1_Day2.models.CandidateDTO;

public interface ICandidateRepo {

	List<Candidate> sellectAllCandidate();

	StringBuffer sellectAllCandidateName();

	Integer getLastCandidateId();

	Candidate findCandidateById(Integer id);

	void insertCandidate(CandidateDTO candidate);

	void updateCandidate(Integer id, String attribute, String value);

}
