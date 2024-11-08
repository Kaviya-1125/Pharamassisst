package com.example.pharmassisst.requestdtos;

import java.time.LocalDate;

import com.example.pharmassisst.enums.Form;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class MedicineRequest {
	

	@NotNull(message=" Name cannot be null")
	@NotBlank(message = "Name cannot be blank")
	@Pattern(regexp = "^[A-Za-z]+$\r\n", message ="Invalid name")
	private String name;
	
	@NotNull(message="category cannot be null")
	@NotBlank(message = "category cannot be blank")
	@Pattern(regexp = "^[A-Za-z]+(?:[ -][A-Za-z]+)*$", message ="Invalid category")
	private String category;
	
	@NotNull(message="ingredients cannot be null")
	@NotBlank(message = "ingredients cannot be blank")
	private String ingredients;
	
	@Min(value = 1)
	private int dosageInMg; 
	private Form form;
	
	@NotNull(message="manufacturer cannot be null")
	@NotBlank(message = "manufacturer cannot be blank")
	@Pattern(regexp = "^[A-Za-z0-9.,\\-\\s]{1,100}$", message="Invalid manufacturer name")
	private String manufacturer;
	
	private int stockQuantity;
	private LocalDate expiryDate;
	private double price;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getIngredients() {
		return ingredients;
	}
	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}
	public int getDosageInMg() {
		return dosageInMg;
	}
	public void setDosageInMg(int dosageInMg) {
		this.dosageInMg = dosageInMg;
	}
	public Form getForm() {
		return form;
	}
	public void setForm(Form form) {
		this.form = form;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public int getStockQuantity() {
		return stockQuantity;
	}
	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}
	public LocalDate getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	

}
