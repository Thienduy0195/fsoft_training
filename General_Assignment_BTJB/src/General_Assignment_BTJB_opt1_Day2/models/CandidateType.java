package General_Assignment_BTJB_opt1_Day2.models;

public class CandidateType {
	private Integer candidateTypeId;
	private String candidateTypeName;

	public CandidateType() {
	}

	public CandidateType(Integer candidateTypeId, String candidateTypeName) {
		this.candidateTypeId = candidateTypeId;
		this.candidateTypeName = candidateTypeName;
	}

	public Integer getCandidateTypeId() {
		return candidateTypeId;
	}

	public void setCandidateTypeId(Integer candidateTypeId) {
		this.candidateTypeId = candidateTypeId;
	}

	public String getCandidateTypeName() {
		return candidateTypeName;
	}

	public void setCandidateTypeName(String candidateTypeName) {
		this.candidateTypeName = candidateTypeName;
	}

}
