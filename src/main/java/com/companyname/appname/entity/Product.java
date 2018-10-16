package com.companyname.appname.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name="products")
public class Product extends UserBaseEntity {

	public Product(String name){
		this.name = name;
	}

	public Product() {

	}

	@NotBlank
	@Size(min=3,max=50)
	private String name;

	@Size(max=1500)
	private String description;

	private Float cost;

	private Float price;

	private Long quantity;

	private Long sold;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "product_category",
		joinColumns = @JoinColumn(name="product_id"),
		inverseJoinColumns = @JoinColumn(name ="category_id"))
	private List<Category> categories;


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Float getCost() {
		return cost;
	}

	public void setCost(Float cost) {
		this.cost = cost;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Long getSold() {
		return sold;
	}

	public void setSold(Long sold) {
		this.sold = sold;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
}
