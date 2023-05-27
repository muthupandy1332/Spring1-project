package com.anudipProject.sprint1Project.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



@Entity
@Table(name="employees")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long eid;
	
	@Column(name = "first_name", nullable = false)
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "post")
	private String post;
	
	@Column(name = "department")
	private String department;
	
	@Column(name = "salary")
	private double salary;
	
	@Column(name = "contact")
	private String contact;
	
	public Employee() {
		
	}

	public Employee(long eid,String firstName, String lastName, String email, String post, String department,
			double salary, String contact) {
		super();
		this.eid=eid;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.post = post;
		this.department = department;
		this.salary = salary;
		this.contact = contact;
	}
	
	

	public long getEid() {
		return eid;
	}

	public void setEid(long eid) {
		this.eid = eid;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	} 
	
	
}

