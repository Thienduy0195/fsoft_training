package General_Assignment_BTJB_opt1_Day2.models;

public class CandidateDTO {

	public CandidateDTO() {
		// TODO Auto-generated constructor stub
	}

	private Integer candidateID;
	private String fullName;
	private String birthDate;
	private String phone;
	private String email;
	private Integer candidateTypeId;
	private static Integer candidateCount = 0;
	private Integer ExpInYear;
	private String ProSkill;
	private String graduationDate;
	private String graduationRank;
	private String Education;
	private String majors;
	private String Semester;
	private String universityName;

	public CandidateDTO(Integer candidateID, String fullName, String birthDate, String phone, String email,
			Integer candidateTypeId, Integer expInYear, String proSkill, String graduationDate, String graduationRank,
			String education, String majors, String semester, String universityName) {
		super();
		this.candidateID = candidateID;
		this.fullName = fullName;
		this.birthDate = birthDate;
		this.phone = phone;
		this.email = email;
		this.candidateTypeId = candidateTypeId;
		ExpInYear = expInYear;
		ProSkill = proSkill;
		this.graduationDate = graduationDate;
		this.graduationRank = graduationRank;
		Education = education;
		this.majors = majors;
		Semester = semester;
		this.universityName = universityName;
	}

	public Integer getCandidateID() {
		return candidateID;
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

	public Integer getCandidateTypeId() {
		return candidateTypeId;
	}

	public void setCandidateTypeId(Integer candidateTypeId) {
		this.candidateTypeId = candidateTypeId;
	}

	public static Integer getCandidateCount() {
		return candidateCount;
	}

	public static void setCandidateCount(Integer candidateCount) {
		CandidateDTO.candidateCount = candidateCount;
	}

	public Integer getExpInYear() {
		return ExpInYear;
	}

	public void setExpInYear(Integer expInYear) {
		ExpInYear = expInYear;
	}

	public String getProSkill() {
		return ProSkill;
	}

	public void setProSkill(String proSkill) {
		ProSkill = proSkill;
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
		return Education;
	}

	public void setEducation(String education) {
		Education = education;
	}

	public String getMajors() {
		return majors;
	}

	public void setMajors(String majors) {
		this.majors = majors;
	}

	public String getSemester() {
		return Semester;
	}

	public void setSemester(String semester) {
		Semester = semester;
	}

	public String getUniversityName() {
		return universityName;
	}

	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}

	@Override
	public String toString() {
		return "CandidateDTO [candidateID=" + candidateID + ", fullName=" + fullName + ", birthDate=" + birthDate
				+ ", phone=" + phone + ", email=" + email + ", candidateTypeId=" + candidateTypeId + ", ExpInYear="
				+ ExpInYear + ", ProSkill=" + ProSkill + ", graduationDate=" + graduationDate + ", graduationRank="
				+ graduationRank + ", Education=" + Education + ", majors=" + majors + ", Semester=" + Semester
				+ ", universityName=" + universityName + "]";
	}

}
