package com.bmart.shopping.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bmart.shopping.product.model.Product;

public interface ProductRepository extends JpaRepository<Product,Integer> {

	//Product findByName(String name);

}
