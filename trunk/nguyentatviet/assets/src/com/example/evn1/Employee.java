package com.example.evn1;

public class Employee {
	private int quantity;
	private int heso;

	public Employee(int quantity, int heso) {
		super();
		this.quantity = quantity;
		this.heso = heso;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getHeso() {
		return heso;
	}

	public void setHeso(int heso) {
		this.heso = heso;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.quantity + " | " + this.heso + " | " + this.heso * this.quantity ;
	}

}
