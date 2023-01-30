package com.example.demo.model;
import jakarta.persistence.*;

@Entity
@Table(name="Laptop_data")
public class Laptop {
	
	@Id
	private int laptop_id;
	private String brand;
	private String model;
	

	public int getLaptop_id() {
		return laptop_id;
	}
	public void setLaptop_id(int laptop_id) {
		this.laptop_id = laptop_id;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
}
