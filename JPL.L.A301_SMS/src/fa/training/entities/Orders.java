package fa.training.entities;

public class Orders {

	private Integer orderId;
	private String orderDate;
	private Integer customerId;
	private Integer employeeId;
	private Double total;

	public Orders() {
	}

	public Orders(Integer orderId, String orderDate, Integer customerId, Integer employeeId, Double total) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.customerId = customerId;
		this.employeeId = employeeId;
		this.total = total;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + ", orderDate=" + orderDate + ", customerId=" + customerId
				+ ", employeeId=" + employeeId + ", total=" + total + "]";
	}

}
