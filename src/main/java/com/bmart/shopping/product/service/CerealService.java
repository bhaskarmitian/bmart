package com.bmart.shopping.product.service;

import java.util.List;

import javax.print.attribute.standard.MediaSize.Other;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bmart.shopping.product.model.Cereal;
import com.bmart.shopping.product.repository.CerealRepository;

@Service
public class CerealService {
    
	@Autowired
	private CerealRepository productRepository;
	
	public Cereal saveProduct(Cereal product) {
		return productRepository.save(product);
	}
	public List<Cereal> saveProducts(List<Cereal> products){
		return productRepository.saveAll(products);
	}
	public List<Cereal> getProducts(){
		return productRepository.findAll();
	}
	
	public Cereal getProductById(int id){
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
	
	public Cereal updateProduct(Cereal product) {
		Cereal exitingProduct=productRepository.findById(product.getId()).orElse(null);
		//exitingProduct.setProductName(product.getProductName());
		exitingProduct.setName(product.getName());
		exitingProduct.setQuantity(product.getQuantity());
		exitingProduct.setPrice(product.getPrice());
		return productRepository.save(exitingProduct);
	}
	
	
}
