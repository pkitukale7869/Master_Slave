package com.project.dto;

public class EmployeeUpdateRequest {
	private String newFirstName;
    private String newLastName;
	public String getNewFirstName() {
		return newFirstName;
	}
	public void setNewFirstName(String newFirstName) {
		this.newFirstName = newFirstName;
	}
	public String getNewLastName() {
		return newLastName;
	}
	public void setNewLastName(String newLastName) {
		this.newLastName = newLastName;
	}
	@Override
	public String toString() {
		return "EmployeeUpdateRequest [newFirstName=" + newFirstName + ", newLastName=" + newLastName + "]";
	}
	public EmployeeUpdateRequest(String newFirstName, String newLastName) {
		super();
		this.newFirstName = newFirstName;
		this.newLastName = newLastName;
	}
    
}
