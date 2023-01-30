package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name="student_data")
public class Student {
	@Id
	private int student_id;
	private String name;
	private String city;
	
	@OneToOne
	@JoinColumn(name="laptop_id")
	private Laptop laptop;
	
	public int getStudent_id() {
		return student_id;
	}
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	

}
