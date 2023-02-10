package product_management.entities;

/**
 * @author DuyNT58
 * @Author_birth_date: 1995-01-01
 */
public abstract class Laptop {

	protected Integer typeId;
	protected String laptopId;
	protected String name;
	protected String brand;
	protected String ram;
	protected String ssd;
	protected String resolution;
	protected String cpu;
	protected String importDate;
	protected Integer price;

	public Laptop() {
	}

	public Laptop(Integer typeId, String laptopId, String name, String brand, String ram, String ssd, String resolution,
			String cpu, String importDate, Integer price) {
		super();
		this.typeId = typeId;
		this.laptopId = laptopId;
		this.name = name;
		this.brand = brand;
		this.ram = ram;
		this.ssd = ssd;
		this.resolution = resolution;
		this.cpu = cpu;
		this.importDate = importDate;
		this.price = price;
	}

	public Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	public String getLaptopId() {
		return laptopId;
	}

	public void setLaptopId(String laptopId) {
		this.laptopId = laptopId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getRam() {
		return ram;
	}

	public void setRam(String ram) {
		this.ram = ram;
	}

	public String getSsd() {
		return ssd;
	}

	public void setSsd(String ssd) {
		this.ssd = ssd;
	}

	public String getResolution() {
		return resolution;
	}

	public void setResolution(String resolution) {
		this.resolution = resolution;
	}

	public String getCpu() {
		return cpu;
	}

	public void setCpu(String cpu) {
		this.cpu = cpu;
	}

	public String getImportDate() {
		return importDate;
	}

	public void setImportDate(String importDate) {
		this.importDate = importDate;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public abstract String showInfo();

	public abstract String getAttributeName();

}
