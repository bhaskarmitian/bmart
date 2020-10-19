package com.bmart.shopping.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bmart.shopping.product.model.Cereal;


public interface CerealRepository extends JpaRepository<Cereal,Integer> {

	//Product findByName(String name);

}
