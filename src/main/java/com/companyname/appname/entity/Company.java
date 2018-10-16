package com.companyname.appname.entity;

import org.hibernate.annotations.NaturalId;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name="companies")
public class Company extends UserBaseEntity{

	@NotBlank
	@Size(max=200)
	private String name;

	private String description;

	@Email
	@NotBlank
	@Size(max=100)
	@NaturalId
	private String email;

	@Pattern(regexp="(^$|[0-9]{10})")
	@NaturalId
	@NotBlank
	private String phone;

	private String contactName;

	private String Logo;

	private String website;
}
