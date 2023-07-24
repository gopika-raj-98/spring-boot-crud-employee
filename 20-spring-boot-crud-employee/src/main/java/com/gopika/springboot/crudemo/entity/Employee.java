package com.gopika.springboot.crudemo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {

	// define fields
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="first_Name")
	private String firstName;
	
	@Column(name="lastName")
	private String last_Name;
	
	
	@Column(name="email")
	private String email;
	
	
	
	// define constructors
	
	public Employee() {
		
	}
		
	

	public Employee(String firstName, String last_Name, String email) {
		
		this.firstName = firstName;
		this.last_Name = last_Name;
		this.email = email;
	}


	// define getters and setters
	

	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLast_Name() {
		return last_Name;
	}



	public void setLast_Name(String last_Name) {
		this.last_Name = last_Name;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}

	
	// define tostring
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", last_Name=" + last_Name + ", email=" + email
				+ "]";
	}
	
}
