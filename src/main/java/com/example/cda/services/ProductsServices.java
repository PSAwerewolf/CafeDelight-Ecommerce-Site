package com.example.cda.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cda.model.Products;
import com.example.cda.repository.ProductsRepository;

@Service
public class ProductsServices {
	
	@Autowired
	public ProductsRepository prodRepo;
	
	public List<Products> getAllProducts(){
		return prodRepo.findAll();
	}
	
	public void addProducts(Products product) {
		prodRepo.save(product);
	}
	
	public void removeProducts(long id) {
		prodRepo.deleteById(id);
	}
	
	public Optional<Products> getProductsById(long id) {
		return prodRepo.findById(id);
	}
	
	public List<Products> findProductsByCategoryId(long id){
		return prodRepo.findAllByCategoryId(id);
	}
}
