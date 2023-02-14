package main.entities;

public abstract class Beneficiary {

	protected Integer typeId;
	protected String id;
	protected String name;
	protected String birthdate;
	protected String address;
	protected String phone;
	protected String benefitDate;
	protected Integer benefit;

	public Beneficiary() {
	}

	public Beneficiary(Integer typeId, String id, String name, String birthdate, String address, String phone,
			String benefitDate, Integer benefit) {
		super();
		this.typeId = typeId;
		this.id = id;
		this.name = name;
		this.birthdate = birthdate;
		this.address = address;
		this.phone = phone;
		this.benefitDate = benefitDate;
		this.benefit = benefit;
	}

	public Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getBenefitDate() {
		return benefitDate;
	}

	public void setBenefitDate(String benefitDate) {
		this.benefitDate = benefitDate;
	}

	public Integer getBenefit() {
		return benefit;
	}

	public void setBenefit(Integer benefit) {
		this.benefit = benefit;
	}

	public abstract String showInfo();

	public abstract String getAttribute();

}
