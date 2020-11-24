package com.example.referencedata.dao.entity;

public class Deliverer {
	
	private String delivererNumber;

	public String getDelivererNumber() {
		return delivererNumber;
	}

	public void setDelivererNumber(String delivererNumber) {
		this.delivererNumber = delivererNumber;
	}

	@Override
	public String toString() {
		return "Deliverer [delivererNumber=" + delivererNumber + "]";
	}
}
