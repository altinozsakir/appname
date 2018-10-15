package com.companyname.appname.entity;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name="addresses")
public class Address extends UserBaseEntity {

	@NotBlank
	@Size(max=500)
	private String address;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "county_id")
	private County county;

	public Address() {
	}

	public Address(@NotBlank @Size(max = 500) String address, County county) {
		this.address = address;
		this.county = county;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public County getCounty() {
		return county;
	}

	public void setCounty(County county) {
		this.county = county;
	}
}
