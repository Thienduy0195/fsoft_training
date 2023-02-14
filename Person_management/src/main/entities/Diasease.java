package main.entities;

public class Diasease extends Beneficiary {

	private String illness;
	private String sickDate;

	public Diasease() {
		// TODO Auto-generated constructor stub
	}

	public Diasease(Integer typeId, String id, String name, String birthdate, String address, String phone,
			String benefitDate, Integer benefit, String illness, String sickDate) {
		super(typeId, id, name, birthdate, address, phone, benefitDate, benefit);
		this.illness = illness;
		this.sickDate = sickDate;
	}

	public String getIllness() {
		return illness;
	}

	public void setIllness(String illness) {
		this.illness = illness;
	}

	public String getSickDate() {
		return sickDate;
	}

	public void setSickDate(String sickDate) {
		this.sickDate = sickDate;
	}

	@Override
	public String showInfo() {
		return "Diasease [typeId=" + typeId + ", id=" + id + ", name=" + name + ", birthdate=" + birthdate
				+ ", address=" + address + ", phone=" + phone + ", benefitDate=" + benefitDate + ", benefit=" + benefit
				+ ", illness=" + illness + ", sickDate=" + sickDate + "]";
	}

	@Override
	public String getAttribute() {
		return "typeId,id,name,birthdate,address,phone,benefitDate,benefit,illness,sickDate";
	}

}
