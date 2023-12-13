package com.example.cda.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.cda.model.Products;

@Repository
public interface ProductsRepository extends JpaRepository<Products, Long> {
	public List<Products> findAllByCategoryId(long id);
}
