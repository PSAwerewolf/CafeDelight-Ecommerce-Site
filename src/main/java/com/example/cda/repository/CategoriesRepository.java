package com.example.cda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.cda.model.Categories;

@Repository
public interface CategoriesRepository extends JpaRepository<Categories, Integer> {
	
}
