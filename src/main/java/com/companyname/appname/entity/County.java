package com.companyname.appname.entity;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;


@Entity
@Table(name="counties")
public class County extends UserBaseEntity {

	@NotBlank
	@Size(min=3, max=100)
	private String name;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="city_id")
	private City city;

	@OneToMany(cascade = CascadeType.ALL,
	fetch = FetchType.LAZY,
	mappedBy = "county")
	private Set<Address> addresses;

	public County() {
	}

	public County(@NotBlank @Size(min = 3, max = 100) String name, Set<Address> addresses) {
		this.name = name;
		this.addresses = addresses;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}
}
