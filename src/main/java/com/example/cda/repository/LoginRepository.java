package com.example.cda.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.cda.model.User;

@Repository
public interface LoginRepository extends JpaRepository<User, Integer> {
	public List<User> findAllByEmail(String email);
}
