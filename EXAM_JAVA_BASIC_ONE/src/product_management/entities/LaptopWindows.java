package product_management.entities;

/**
 * @author DuyNT58
 * @Author_birth_date: 1995-01-01
 */
public class LaptopWindows extends Laptop {

	private String touchScreen;
	private String numpad;

	public LaptopWindows() {
	}

	public LaptopWindows(Integer typeId, String laptopId, String name, String brand, String ram, String ssd,
			String resolution, String cpu, String importDate, Integer price, String touchScreen, String numpad) {
		super(typeId, laptopId, name, brand, ram, ssd, resolution, cpu, importDate, price);
		this.touchScreen = touchScreen;
		this.numpad = numpad;
	}

	public String getTouchScreen() {
		return touchScreen;
	}

	public void setTouchScreen(String touchScreen) {
		this.touchScreen = touchScreen;
	}

	public String getNumpad() {
		return numpad;
	}

	public void setNumpad(String numpad) {
		this.numpad = numpad;
	}

	@Override
	public String showInfo() {
		return "LaptopWindows [typeId=" + typeId + ", laptopId=" + laptopId + ", name=" + name + ", brand=" + brand
				+ ", ram=" + ram + ", ssd=" + ssd + ", resolution=" + resolution + ", cpu=" + cpu + ", importDate="
				+ importDate + ", price=" + price + ",touchScreen=" + touchScreen + ", numpad=" + numpad + "]";
	}

	@Override
	public String getAttributeName() {
		return "typeId" + ",laptopId" + ",name" + ",brand" + ",ram" + ",ssd" + ",resolution" + ",cpu" + ",importDate"
				+ ",price" + ",touchScreen" + ",numpad";
	}

}
