package General_Assignment_BTJB_opt1_Day2.models;

public class FresherCandidate extends Candidate {

	private String graduationDate;
	private String graduationRank;
	private String education;

	public FresherCandidate() {
	}

	public FresherCandidate(Integer candidateID, String fullName, String birthDate, String phone, String email,
			Integer candidateTypeId, String graduationDate, String graduationRank, String education) {
		super(candidateID, fullName, birthDate, phone, email, candidateTypeId);
		this.graduationDate = graduationDate;
		this.graduationRank = graduationRank;
		this.education = education;
	}

	public String getGraduationDate() {
		return graduationDate;
	}

	public void setGraduationDate(String graduationDate) {
		this.graduationDate = graduationDate;
	}

	public String getGraduationRank() {
		return graduationRank;
	}

	public void setGraduationRank(String graduationRank) {
		this.graduationRank = graduationRank;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	@Override
	public String showInfo() {
		return "FresherCandidate [candidateID=" + candidateID + ", fullName=" + fullName + ", birthDate=" + birthDate
				+ ", phone=" + phone + ", email=" + email + ", candidateTypeId=" + candidateTypeId + ", certificates="
				+ certificates + "graduationDate=" + graduationDate + ", graduationRank=" + graduationRank
				+ ", education=" + education + "]";
	}

	@Override
	public String getAttributeName() {
		return "CandidateID," + "FullName," + "BirthDate," + "Phone," + "Email," + "CandidateTypeId,"
				+ "GraduationDate," + "GraduationRank," + "Education";
	}

}
