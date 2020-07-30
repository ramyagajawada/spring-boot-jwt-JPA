package com.javainuse.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity

@Table(name="pet")

public class Pet {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long petid;
	@Column
	private String petname;
	@Column
	private String pettype;
	@Column
	private String petprice;
	@Column
	@JsonIgnore
	private String petdescription;
	public Long getPetid() {
		return petid;
	}
	public void setPetid(Long petid) {
		this.petid = petid;
	}
	public String getPetname() {
		return petname;
	}
	public void setPetname(String petname) {
		this.petname = petname;
	}
	public String getPettype() {
		return pettype;
	}
	public void setPettype(String pettype) {
		this.pettype = pettype;
	}
	public String getPetprice() {
		return petprice;
	}
	public void setPetprice(String petprice) {
		this.petprice = petprice;
	}
	public String getPetdescription() {
		return petdescription;
	}
	public void setPetdescription(String petdescription) {
		this.petdescription = petdescription;
	}
	
}
