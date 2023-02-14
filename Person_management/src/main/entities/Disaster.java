package main.entities;

public class Disaster extends Beneficiary {

	private String disasterType;
	private String impactDate;
	private Integer totalDamage;

	public Disaster() {
		// TODO Auto-generated constructor stub
	}

	public Disaster(Integer typeId, String id, String name, String birthdate, String address, String phone,
			String benefitDate, Integer benefit, String disasterType, String impactDate, Integer totalDamage) {
		super(typeId, id, name, birthdate, address, phone, benefitDate, benefit);
		this.disasterType = disasterType;
		this.impactDate = impactDate;
		this.totalDamage = totalDamage;
	}

	public String getDisasterType() {
		return disasterType;
	}

	public void setDisasterType(String disasterType) {
		this.disasterType = disasterType;
	}

	public String getImpactDate() {
		return impactDate;
	}

	public void setImpactDate(String impactDate) {
		this.impactDate = impactDate;
	}

	public Integer getTotalDamage() {
		return totalDamage;
	}

	public void setTotalDamage(Integer totalDamage) {
		this.totalDamage = totalDamage;
	}

	@Override
	public String showInfo() {
		return "Disaster [typeId=" + typeId + ", id=" + id + ", name=" + name + ", birthdate=" + birthdate
				+ ", address=" + address + ", phone=" + phone + ", benefitDate=" + benefitDate + ", benefit=" + benefit
				+ ", disasterType=" + disasterType + ", impactDate=" + impactDate + ", totalDamage=" + totalDamage
				+ "]";
	}

	@Override
	public String getAttribute() {
		return "typeId,id,name,birthdate,address,phone,benefitDate,benefit,disasterType,impactDate,totalDamage";
	}

}
