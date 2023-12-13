package com.example.cda.dto;

public class ProductDTO {
	private long id;
	private String name;
	
	private double price;
	private double weight;
	private String imageName;
	private String description;
	private int categoryId;
	public ProductDTO() {
		super();
	}
	public ProductDTO(long id, String name, double price, double weight, String imageName, String description,
			int categoryId) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.weight = weight;
		this.imageName = imageName;
		this.description = description;
		this.categoryId = categoryId;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	
	
}
