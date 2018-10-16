package com.companyname.appname.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="persons")
public class Person extends UserBaseEntity {

	private String firstname;

	private String lastname;

	private String avatarPath;


}
