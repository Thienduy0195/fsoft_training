package main.entities;

public class OldPhone extends Phone {

	private Integer status;
	private Integer bodyStatus;
	private Double priceWarranty;

	public OldPhone() {
		// TODO Auto-generated constructor stub
	}

	public OldPhone(String id, String name, Double screenSize, String chipset, Integer ram, Integer storage,
			Double price, String manufacture, Integer status, Integer bodyStatus, Double priceWarranty) {
		super(id, name, screenSize, chipset, ram, storage, price, manufacture);
		this.status = status;
		this.bodyStatus = bodyStatus;
		this.priceWarranty = priceWarranty;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getBodyStatus() {
		return bodyStatus;
	}

	public void setBodyStatus(Integer bodyStatus) {
		this.bodyStatus = bodyStatus;
	}

	public Double getPriceWarranty() {
		return priceWarranty;
	}

	public void setPriceWarranty(Double priceWarranty) {
		this.priceWarranty = priceWarranty;
	}

	@Override
	public String showInfo() {
		return "OldPhone [id=" + id + ", name=" + name + ", screenSize=" + screenSize + ", chipset=" + chipset
				+ ", ram=" + ram + ", storage=" + storage + ", price=" + price + ", manufacture=" + manufacture
				+ ", warranty= 7 days" + ", status=" + status + ", bodyStatus=" + bodyStatus + ", priceWarranty="
				+ priceWarranty + "]";
	}

}
