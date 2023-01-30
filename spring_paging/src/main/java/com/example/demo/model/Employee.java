package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name="EmpCountry")
public class Employee {
	
	
	@Id
	private int id;
	
	@Column(name="name")
	private String name;
	

	
	@Column(name="country")
	private String Country;
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getCountry() {
		return Country;
	}


	public void setCountry(String country) {
		Country = country;
	}


	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name +  ", Country=" + Country + "]";
	}
	
}
