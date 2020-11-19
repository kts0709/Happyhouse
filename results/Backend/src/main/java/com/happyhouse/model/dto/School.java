package com.happyhouse.model.dto;

public class School {
	private String id;
	private String rate;
	private String name;
	private String contact;
	private String address;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRate() {
		return rate;
	}
	public void setRate(String rate) {
		this.rate = rate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "School [id=" + id + ", rate=" + rate + ", name=" + name + ", contact=" + contact + ", address="
				+ address + "]";
	} 
	
	
}
