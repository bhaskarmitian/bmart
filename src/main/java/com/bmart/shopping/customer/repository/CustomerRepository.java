package com.bmart.shopping.customer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bmart.shopping.customer.dao.CustomerOrderResponse;
import com.bmart.shopping.customer.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
  
	@Query("select new com.bmart.shopping.customer.dao.CustomerOrderResponse(c.name,p.name) from Customer c JOIN c.products p")
	public List<CustomerOrderResponse> getProductByCustomer();
	
}
