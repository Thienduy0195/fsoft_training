package main.entities;

public class Indigent extends Beneficiary {

	private Integer income;
	private Integer dependantAmount;

	public Indigent() {
		// TODO Auto-generated constructor stub
	}

	public Indigent(Integer typeId, String id, String name, String birthdate, String address, String phone,
			String benefitDate, Integer benefit, Integer income, Integer dependantAmount) {
		super(typeId, id, name, birthdate, address, phone, benefitDate, benefit);
		this.income = income;
		this.dependantAmount = dependantAmount;
	}

	public Integer getIncome() {
		return income;
	}

	public void setIncome(Integer income) {
		this.income = income;
	}

	public Integer getDependantAmount() {
		return dependantAmount;
	}

	public void setDependantAmount(Integer dependantAmount) {
		this.dependantAmount = dependantAmount;
	}

	@Override
	public String showInfo() {
		return "Indigent [typeId=" + typeId + ", id=" + id + ", name=" + name + ", birthdate=" + birthdate
				+ ", address=" + address + ", phone=" + phone + ", benefitDate=" + benefitDate + ", benefit=" + benefit
				+ ", income=" + income + ", dependantAmount=" + dependantAmount + "]";
	}

	@Override
	public String getAttribute() {
		return "typeId,id,name,birthdate,address,phone,benefitDate,benefit,income,dependantAmount ";
	}

}
