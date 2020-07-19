package com.bmart.shopping.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bmart.shopping.customer.dao.CustomerOrderRequest;
import com.bmart.shopping.customer.dao.CustomerOrderResponse;
import com.bmart.shopping.customer.model.Customer;
import com.bmart.shopping.customer.repository.CustomerRepository;
import com.bmart.shopping.customer.service.CustomerService;

@RestController
public class CustomerOrder {

	  @Autowired
	  CustomerService customerService;
	
	  @Autowired
	  CustomerRepository customerRepository;
	 
	   @PostMapping("/placeOrder")
	   public  Customer orderPlaced(@RequestBody CustomerOrderRequest customerReq) {
		   System.out.println(customerReq);
		  return customerService.orderPlaced(customerReq.getCustomer());
	   }
	   @GetMapping("/ordes")
	   public List<Customer> findAllOrder(){
		  return  customerService.findAllOrder(); 
	   }
	   @GetMapping("/getProductByCustomer")
	   public List<CustomerOrderResponse> getProductByCustomer(){
		   return customerRepository.getProductByCustomer();
	   }
}
