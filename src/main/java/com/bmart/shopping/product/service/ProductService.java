package com.bmart.shopping.product.service;

import java.util.List;

import javax.print.attribute.standard.MediaSize.Other;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bmart.shopping.product.model.Product;
import com.bmart.shopping.product.repository.ProductRepository;

@Service
public class ProductService {
    
	@Autowired
	private ProductRepository productRepository;
	
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}
	public List<Product> saveProducts(List<Product> products){
		return productRepository.saveAll(products);
	}
	public List<Product> getProducts(){
		return productRepository.findAll();
	}
	
	public Product getProductById(int id){
	    return 	productRepository.findById(id).orElse(null);
	}

	/*
	 * public Product getProductByName(String name){ return
	 * productRepository.findByName(name); }
	 */
	public String deleteProduct(int id) {
		 productRepository.deleteById(id);
		 return "product removed "+id;
	}
	
	public Product updateProduct(Product product) {
		Product exitingProduct=productRepository.findById(product.getId()).orElse(null);
		//exitingProduct.setProductName(product.getProductName());
		exitingProduct.setName(product.getName());
		exitingProduct.setQuantity(product.getQuantity());
		exitingProduct.setPrice(product.getPrice());
		return productRepository.save(exitingProduct);
	}
	
	
}
