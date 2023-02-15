package fa.training.entities;

public class LineItem {

	private Integer orderId;
	private Integer productId;
	private Integer quantity;
	private Double price;

	public LineItem() {

	}

	public LineItem(Integer orderId, Integer productId, Integer quantity, Double price) {
		super();
		this.orderId = orderId;
		this.productId = productId;
		this.quantity = quantity;
		this.price = price;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "LineItem [orderId=" + orderId + ", productId=" + productId + ", quantity=" + quantity + ", price="
				+ price + "]";
	}

}
