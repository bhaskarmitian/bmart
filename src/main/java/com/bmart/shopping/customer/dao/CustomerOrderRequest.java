package com.bmart.shopping.customer.dao;

import com.bmart.shopping.customer.model.Customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

//@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CustomerOrderRequest {

	private Customer customer;

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "CustomerOrderRequest [customer=" + customer + ", getCustomer()=" + getCustomer() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
}
