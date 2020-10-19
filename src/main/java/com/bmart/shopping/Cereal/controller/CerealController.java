package com.bmart.shopping.Cereal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bmart.shopping.product.model.Cereal;
import com.bmart.shopping.product.service.CerealService;


@RestController
@CrossOrigin(origins="http://localhost:3006")
@RequestMapping("/products")
public class CerealController {

	@Autowired
	CerealService  productService;
	
	//@PostMapping("/addProduct")
	/*
	 * @PostMapping() public Product saveProduct(@RequestBody Product product) {
	 * return productService.saveProduct(product);
	 }*/
	
	 @PostMapping("/save")
	  public List<Cereal> saveProducts(@RequestBody List<Cereal> products){ 
		 return productService.saveProducts(products);
	 }
	 
	@GetMapping("")
	public List<Cereal> getProducts(){
		return productService.getProducts();
	}
	
	@GetMapping("/{id}")
	public Cereal getProductById(@PathVariable int id) {
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
	public Cereal updateProduct(@RequestBody Cereal product) {
		return productService.updateProduct(product);
	}
	
}
