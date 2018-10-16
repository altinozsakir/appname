package com.companyname.appname.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name="countries")
public class Country extends UserBaseEntity {

	@NotBlank
	@Size(min=3,max=100)
	private String name;

	@OneToMany(fetch = FetchType.LAZY,
	cascade = CascadeType.ALL,
	mappedBy = "country")
	private Set<City> cities;

	public Country() {
	}

	public Country(@NotBlank @Size(min = 3, max = 100) String name, Set<City> cities) {
		this.name = name;
		this.cities = cities;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<City> getCities() {
		return cities;
	}

	public void setCities(Set<City> cities) {
		this.cities = cities;
	}
}
