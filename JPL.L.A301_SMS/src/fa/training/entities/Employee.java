package fa.training.entities;

public class Employee {

	private Integer employeeId;
	private String employeeName;
	private Double salary;
	private Integer supervisorId;

	public Employee() {
	}

	public Employee(Integer employeeId, String employeeName, Double salary, Integer supervisorId) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.salary = salary;
		this.supervisorId = supervisorId;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Integer getSupervisorId() {
		return supervisorId;
	}

	public void setSupervisorId(Integer supervisorId) {
		this.supervisorId = supervisorId;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", salary=" + salary
				+ ", supervisorId=" + supervisorId + "]";
	}

}
