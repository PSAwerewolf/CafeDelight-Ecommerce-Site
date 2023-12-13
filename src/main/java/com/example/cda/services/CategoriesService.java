package com.example.cda.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cda.model.Categories;
import com.example.cda.repository.CategoriesRepository;

@Service
public class CategoriesService {
	
	@Autowired
	public CategoriesRepository repo;
	
	public List<Categories> getAllCategory(){
		return repo.findAll();
	} 
	
	public void addCategory(Categories category) {
		repo.save(category);
	}
	
	public void removeCategory(int id) {
		repo.deleteById(id);
	}
	
	public Optional<Categories> updateCategoryById(int id){
		return repo.findById(id);
	}
}
