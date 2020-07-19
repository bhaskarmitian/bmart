package com.bmart.shopping.customer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bmart.shopping.customer.model.Customer;
import com.bmart.shopping.customer.repository.CustomerRepository;

@Service
public class CustomerService {
   @Autowired
   CustomerRepository customerRepository;
   
   public Customer orderPlaced(Customer customer){
	   return customerRepository.save(customer);
   }
   
   public List<Customer> findAllOrder(){
	   return customerRepository.findAll();
   }
}
