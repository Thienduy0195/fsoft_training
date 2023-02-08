package General_Assignment_BTJB_opt1_Day2.models;

import java.security.cert.Certificate;
import java.util.List;

public abstract class Candidate {
	protected Integer candidateID;
	protected String fullName;
	protected String birthDate;
	protected String phone;
	protected String email;
	protected Integer candidateTypeId;
	public static Integer candidateCount = 0;
	protected List<Certificate> certificates;

	public Candidate() {
	}

	public Integer getCandidateID() {
		return candidateID;
	}

	public Candidate(Integer candidateID, String fullName, String birthDate, String phone, String email,
			Integer candidateTypeId) {
		this.candidateID = candidateID;
		this.fullName = fullName;
		this.birthDate = birthDate;
		this.phone = phone;
		this.email = email;
		this.candidateTypeId = candidateTypeId;
	}

	public void setCandidateID(Integer candidateID) {
		this.candidateID = candidateID;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public static Integer getCandidateCount() {
		return candidateCount;
	}

	public Integer getCandidateTypeId() {
		return candidateTypeId;
	}

	public void setCandidateTypeId(Integer candidateTypeId) {
		this.candidateTypeId = candidateTypeId;
	}

	public static void setCandidateCount(Integer candidateCount) {
		Candidate.candidateCount = candidateCount;
	}

	public abstract String showInfo();

	public abstract String getAttributeName();

}
