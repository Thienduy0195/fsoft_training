package main.entities;

public class HomePhone extends Phone {

	private Integer warranty;
	private Integer range;

	public HomePhone() {
		// TODO Auto-generated constructor stub
	}

	public HomePhone(String id, String name, Double screenSize, String chipset, Integer ram, Integer storage,
			Double price, String manufacture, Integer warranty, Integer range) {
		super(id, name, screenSize, chipset, ram, storage, price, manufacture);
		this.warranty = warranty;
		this.range = range;
	}

	public Integer getWarranty() {
		return warranty;
	}

	public void setWarranty(Integer warranty) {
		this.warranty = warranty;
	}

	public Integer getRange() {
		return range;
	}

	public void setRange(Integer range) {
		this.range = range;
	}

	@Override
	public String showInfo() {
		return "HomePhone [id=" + id + ", name=" + name + ", screenSize=" + screenSize + ", chipset=" + chipset
				+ ", ram=" + ram + ", storage=" + storage + ", price=" + price + ", manufacture=" + manufacture
				+ ", warranty=" + warranty + " months, range=" + range + "]";
	}

}
