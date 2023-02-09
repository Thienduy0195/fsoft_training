package General_Assignment_BTJB_opt1_Day2.models;


/**
 * @author DuyNT58
 * Author birth date: 1995-01-01
 */
public class Certificated {

	private Integer certificatedId;
	private String certificatedName;
	private String certificatedRank;
	private String certificatedDate;
	private Integer candidateId;

	public Certificated() {
	}

	public Certificated(Integer certificatedId, String certificatedName, String certificatedRank,
			String certificatedDate, Integer candidateId) {
		super();
		this.certificatedId = certificatedId;
		this.certificatedName = certificatedName;
		this.certificatedRank = certificatedRank;
		this.certificatedDate = certificatedDate;
		this.candidateId = candidateId;
	}

	public Certificated(Integer certificatedId, String certificatedName, String certificatedRank,
			String certificatedDate) {
		this.certificatedId = certificatedId;
		this.certificatedName = certificatedName;
		this.certificatedRank = certificatedRank;
		this.certificatedDate = certificatedDate;
	}

	public Integer getCertificatedId() {
		return certificatedId;
	}

	public void setCertificatedId(Integer certificatedId) {
		this.certificatedId = certificatedId;
	}

	public String getCertificatedName() {
		return certificatedName;
	}

	public void setCertificatedName(String certificatedName) {
		this.certificatedName = certificatedName;
	}

	public String getCertificatedRank() {
		return certificatedRank;
	}

	public void setCertificatedRank(String certificatedRank) {
		this.certificatedRank = certificatedRank;
	}

	public String getCertificatedDate() {
		return certificatedDate;
	}

	public void setCertificatedDate(String certificatedDate) {
		this.certificatedDate = certificatedDate;
	}

	public Integer getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(Integer candidateId) {
		this.candidateId = candidateId;
	}

}
