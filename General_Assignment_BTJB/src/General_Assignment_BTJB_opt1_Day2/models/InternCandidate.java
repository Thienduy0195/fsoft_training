package General_Assignment_BTJB_opt1_Day2.models;

/**
 * @author DuyNT58
 * Author birth date: 1995-01-01
 */
public class InternCandidate extends Candidate {

	private String majors;
	private String semester;
	private String universityName;

	public InternCandidate() {
	}

	public InternCandidate(Integer candidateID, String fullName, String birthDate, String phone, String email,
			Integer candidateTypeId, String majors, String semester, String universityName) {
		super(candidateID, fullName, birthDate, phone, email, candidateTypeId);
		this.majors = majors;
		this.semester = semester;
		this.universityName = universityName;
	}

	public String getMajors() {
		return majors;
	}

	public void setMajors(String majors) {
		this.majors = majors;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public String getUniversityName() {
		return universityName;
	}

	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}

	@Override
	public String showInfo() {
		return "InternCandidate [candidateID=" + candidateID + ", fullName=" + fullName + ", birthDate=" + birthDate
				+ ", phone=" + phone + ", email=" + email + ", candidateTypeId=" + candidateTypeId + ", certificates="
				+ certificates + "majors=" + majors + ", semester=" + semester + ", universityName=" + universityName
				+ "]";
	}

	@Override
	public String getAttributeName() {
		return "CandidateID," + "FullName," + "BirthDate," + "Phone," + "Email," + "CandidateTypeId," + "Majors,"
				+ "Semester," + "UniversityName";
	}

}
