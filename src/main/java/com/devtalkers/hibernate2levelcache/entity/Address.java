package com.devtalkers.hibernate2levelcache.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table( name="address")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Address {
	
	@Column(name="pincode")
	@Id
	private Integer pincode;
	@Column(name="street")
	private String street;
	@Column(name="city")
	private String city;
	public Integer getPincode() {
		return pincode;
	}
	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
}
