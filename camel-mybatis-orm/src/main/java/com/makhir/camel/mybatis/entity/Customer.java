package com.makhir.camel.mybatis.entity;

public class Customer {
	private int id;
	private String name;
	private String city;
	private String address;
	private String contact;
	
	
	public Customer() {
		
	}
	
	
	
	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}

	public Customer(int id, String name, String city, String address, String contact) {
		this.id = id;
		this.name = name;
		this.city = city;
		this.address = address;
		this.contact = contact;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", city=" + city + ", address=" + address + ", contact="
				+ contact + "]";
	}
}
