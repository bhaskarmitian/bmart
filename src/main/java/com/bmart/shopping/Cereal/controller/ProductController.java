package com.bmart.shopping.Cereal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bmart.shopping.product.service.ProductService;


@RestController
//@CrossOrigin(origins="http://localhost:3006")
@RequestMapping("/products")
public class ProductController {

	@Autowired
	ProductService  productService;
	
		
}
