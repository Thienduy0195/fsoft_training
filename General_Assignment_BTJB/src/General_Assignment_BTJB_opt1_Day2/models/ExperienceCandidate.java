package General_Assignment_BTJB_opt1_Day2.models;

public class ExperienceCandidate extends Candidate {

	private Integer expInYear = 0;
	private String proSkill;

	public ExperienceCandidate() {
	}

	public ExperienceCandidate(Integer candidateID, String fullName, String birthDate, String phone, String email,
			Integer candidateTypeId, Integer expInYear, String proSkill) {
		super(candidateID, fullName, birthDate, phone, email, candidateTypeId);
		this.expInYear = expInYear;
		this.proSkill = proSkill;
	}

	public Integer getExpInYear() {
		return expInYear;
	}

	public void setExpInYear(Integer expInYear) {
		this.expInYear = expInYear;
	}

	public String getProSkill() {
		return proSkill;
	}

	public void setProSkill(String proSkill) {
		this.proSkill = proSkill;
	}

	@Override
	public String showInfo() {
		return "ExperienceCandidate [candidateID=" + candidateID + ", fullName=" + fullName + ", birthDate=" + birthDate
				+ ", phone=" + phone + ", email=" + email + ", candidateTypeId=" + candidateTypeId + ", certificates="
				+ certificates + "expInYear=" + expInYear + ", proSkill=" + proSkill + "]";
	}

	@Override
	public String getAttributeName() {
		return "CandidateID," + "FullName," + "BirthDate," + "Phone," + "Email," + "CandidateTypeId," + "ExpInYear,"
				+ "ProSkill";
	}

}
