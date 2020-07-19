package com.bmart.shopping.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bmart.shopping.product.model.Product;
import com.bmart.shopping.product.service.ProductService;


@RestController
@CrossOrigin(origins="http://localhost:3006")
public class ProductController {

	@Autowired
	ProductService  productService;
	
	@PostMapping("/addProduct")
	public Product saveProduct(@RequestBody Product product) {
		return productService.saveProduct(product);
	}
	@PostMapping("/addProducts")
	public List<Product> saveProducts(@RequestBody List<Product> products){
		return productService.saveProducts(products);
	}
	@GetMapping("/products")
	public List<Product> getProducts(){
		return productService.getProducts();
	}
	@GetMapping("/productsById/{id}")
	public Product getProductById(@PathVariable int id) {
		return productService.getProductById(id); 
	}

	/*
	 * @GetMapping("/products/{name}") public Product getProductByName(@PathVariable
	 * String name) { return productService.getProductByName(name); }
	 */
	@GetMapping("/deleteProducts/{id}")
    public String deleteProduct(@PathVariable int id) {
	   return productService.deleteProduct(id);
    }
	@PutMapping("/updateProduct")
	public Product updateProduct(@RequestBody Product product) {
		return productService.updateProduct(product);
	}
	
}
