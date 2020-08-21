package com.example.demo.model;

public class Department {

	private String departmentName;
	private String location;
	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return "Department [departmentName=" + departmentName + ", location=" + location + "]";
	}
	
	
}
