package main.entities;

public abstract class Phone {

	protected String id;
	protected String name;
	protected Double screenSize;
	protected String chipset;
	protected Integer ram;
	protected Integer storage;
	protected Double price;
	protected String manufacture;

	public Phone() {
	}

	public Phone(String id, String name, Double screenSize, String chipset, Integer ram, Integer storage, Double price,
			String manufacture) {
		super();
		this.id = id;
		this.name = name;
		this.screenSize = screenSize;
		this.chipset = chipset;
		this.ram = ram;
		this.storage = storage;
		this.price = price;
		this.manufacture = manufacture;
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

	public Double getScreenSize() {
		return screenSize;
	}

	public void setScreenSize(Double screenSize) {
		this.screenSize = screenSize;
	}

	public String getChipset() {
		return chipset;
	}

	public void setChipset(String chipset) {
		this.chipset = chipset;
	}

	public Integer getRam() {
		return ram;
	}

	public void setRam(Integer ram) {
		this.ram = ram;
	}

	public Integer getStorage() {
		return storage;
	}

	public void setStorage(Integer storage) {
		this.storage = storage;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getManufacture() {
		return manufacture;
	}

	public void setManufacture(String manufacture) {
		this.manufacture = manufacture;
	}

	@Override
	public String toString() {
		return "Phone [id=" + id + ", name=" + name + ", screenSize=" + screenSize + ", chipset=" + chipset + ", ram="
				+ ram + ", storage=" + storage + ", price=" + price + ", manufacture=" + manufacture + "]";
	}

	public abstract String showInfo();

}
