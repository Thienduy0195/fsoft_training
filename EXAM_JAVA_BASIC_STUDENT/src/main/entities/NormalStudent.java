package main.entities;

public class NormalStudent extends Student {

	private Integer englishScore;
	private Double entryTestScore;

	public NormalStudent() {
	}

	public NormalStudent(String fullName, String doB, String sex, String phoneNumber, String universityName,
			String gradeLevel, Integer englishScore, Double entryTestScore) {
		super(fullName, doB, sex, phoneNumber, universityName, gradeLevel);
		this.englishScore = englishScore;
		this.entryTestScore = entryTestScore;
	}

	public Integer getEnglishScore() {
		return englishScore;
	}

	public void setEnglishScore(Integer englishScore) {
		this.englishScore = englishScore;
	}

	public Double getEntryTestScore() {
		return entryTestScore;
	}

	public void setEntryTestScore(Double entryTestScore) {
		this.entryTestScore = entryTestScore;
	}

	@Override
	public String showMyInfo() {
		return "NormalStudent [fullName=" + fullName + ", doB=" + doB + ", sex=" + sex + ", phoneNumber=" + phoneNumber
				+ ", universityName=" + universityName + ", gradeLevel=" + gradeLevel + ", englishScore=" + englishScore
				+ ", entryTestScore=" + entryTestScore + "]";
	}

	@Override
	public String getAttributeName() {
		return "fullName" + ",doB" + ",sex" + ",phoneNumber" + ",universityName" + ",gradeLevel" + ",englishScore"
				+ ",entryTestScore";
	}

}
