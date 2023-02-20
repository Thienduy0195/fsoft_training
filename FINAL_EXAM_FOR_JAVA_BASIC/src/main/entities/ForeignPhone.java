package main.entities;

public class ForeignPhone extends Phone {

	private String country;
	private Double priceWarranty;

	public ForeignPhone() {
		// TODO Auto-generated constructor stub
	}

	public ForeignPhone(String id, String name, Double screenSize, String chipset, Integer ram, Integer storage,
			Double price, String manufacture, String country, Double priceWarranty) {
		super(id, name, screenSize, chipset, ram, storage, price, manufacture);
		this.country = country;
		this.priceWarranty = priceWarranty;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Double getPriceWarranty() {
		return priceWarranty;
	}

	public void setPriceWarranty(Double priceWarranty) {
		this.priceWarranty = priceWarranty;
	}

	@Override
	public String showInfo() {
		return "ForeignPhone [id=" + id + ", name=" + name + ", screenSize=" + screenSize + ", chipset=" + chipset
				+ ", ram=" + ram + ", storage=" + storage + ", price=" + price + ", manufacture=" + manufacture
				+ ", warranty= 7 days" + ", country=" + country + ", priceWarranty=" + priceWarranty + "]";
	}

}
