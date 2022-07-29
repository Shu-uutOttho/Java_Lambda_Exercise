package entities;

public class Employee {
	private String Name;
	private String Email;
	private double Salary;
	
	
	public Employee() {
		
	}
	
	
	public Employee(String name, String email, double salary) {
		Name = name;
		Email = email;
		Salary = salary;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public double getSalary() {
		return Salary;
	}
	public void setSalary(double salary) {
		Salary = salary;
	}
	
	
	
}
