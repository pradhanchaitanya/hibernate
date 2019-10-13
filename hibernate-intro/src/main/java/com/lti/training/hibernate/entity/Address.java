package com.lti.training.hibernate.entity;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name="TBL_ADDRESS")
public class Address {
	
	@Id
	@GeneratedValue
	private int address_id;
	private int flat_no;
	private String Landmark;
	private String city;
	private int pincode;
	@OneToOne(cascade  = CascadeType.ALL)
	private Person person;
	
	
	
	public int getAddress_id() {
		return address_id;
	}
	public void setAddress_id(int address_id) {
		this.address_id = address_id;
	}
	public int getFlat_no() {
		return flat_no;
	}
	public void setFlat_no(int flat_no) {
		this.flat_no = flat_no;
	}
	public String getLandmark() {
		return Landmark;
	}
	public void setLandmark(String landmark) {
		Landmark = landmark;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	
	
}
