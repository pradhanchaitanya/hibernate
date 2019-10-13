package com.lti.training.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_CUST")
public class Customer {
	
	@Id		//PK
	@GeneratedValue
	@Column(name="CUST_ID")
	private int id;
	
	@Column(name="CUST_NAME")
	private String name;
	
	@Column(name="CUST_EMAIL")
	private String email;
	
	@Column(name="CUST_CITY")
	private String city;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	
}
