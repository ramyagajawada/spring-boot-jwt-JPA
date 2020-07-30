package com.javainuse.model;

import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name="admin")

public class Admin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long adminid;
	@Column
	private String adminname;
	@Column
	@JsonIgnore
	private String adminpwd;
	public String getAdminname() {
		return adminname;
	}

	public void setUsername(String adminname) {
		this.adminname = adminname;
	}

	public String getAdminpwd() {
		return adminpwd;
	}

	public void setPassword(String adminpwd) {
		this.adminpwd = adminpwd;
	}

}
