package com.bmart.shopping.customer.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
//@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CustomerOrderResponse {
   
	private String name;
	private String productName;
	
	public CustomerOrderResponse(String name,String productName ){
		this.name=name;
		this.productName=productName;
	}
}
