package product_management.entities;

/**
 * @author DuyNT58
 * @Author_birth_date: 1995-01-01
 */
public class LaptopMacbook extends Laptop {

	private String macType;
	private String cpuType;
	private String macTypeCharge;

	public LaptopMacbook() {
		// TODO Auto-generated constructor stub
	}

	public LaptopMacbook(Integer typeId, String laptopId, String name, String brand, String ram, String ssd,
			String resolution, String cpu, String importDate, Integer price, String macType, String cpuType,
			String macTypeCharge) {
		super(typeId, laptopId, name, brand, ram, ssd, resolution, cpu, importDate, price);
		this.macType = macType;
		this.cpuType = cpuType;
		this.macTypeCharge = macTypeCharge;
	}

	public String getMacType() {
		return macType;
	}

	public void setMacType(String macType) {
		this.macType = macType;
	}

	public String getCpuType() {
		return cpuType;
	}

	public void setCpuType(String cpuType) {
		this.cpuType = cpuType;
	}

	public String getMacTypeCharge() {
		return macTypeCharge;
	}

	public void setMacTypeCharge(String macTypeCharge) {
		this.macTypeCharge = macTypeCharge;
	}

	@Override
	public String showInfo() {
		return "LaptopMacbook [typeId=" + typeId + ", laptopId=" + laptopId + ", name=" + name + ", brand=" + brand
				+ ", ram=" + ram + ", ssd=" + ssd + ", resolution=" + resolution + ", cpu=" + cpu + ", importDate="
				+ importDate + ", price=" + price + ", macType=" + macType + ", cpuType=" + cpuType + ", macTypeCharge="
				+ macTypeCharge + "]";
	}

	@Override
	public String getAttributeName() {
		return "typeId" + ",laptopId" + ",name" + ",brand" + ",ram" + ",ssd" + ",resolution" + ",cpu" + ",importDate"
				+ ",price" + ",macType" + ",cpuType" + ",macTypeCharge";
	}

}
