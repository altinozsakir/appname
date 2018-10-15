package com.companyname.appname.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Category extends UserBaseEntity {
	@NotBlank
	@Size(max=100)
	private String name;

	private String description;

	public Category(String name){
		this.name = name;
	}



	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "category_category",
	joinColumns = @JoinColumn(name="category_id"),
	inverseJoinColumns = @JoinColumn(name="childcategory_id"))
	private List<Category> childCategory;



}
