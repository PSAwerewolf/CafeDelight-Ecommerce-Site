package com.example.cda.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cda.model.User;
import com.example.cda.repository.LoginRepository;

@Service
public class LoginService {
	
	@Autowired
	LoginRepository loginRepo;
	
	public void saveUserDetails(User user) {
		loginRepo.save(user);
	}
	
	public List<User> getAllUserbyEmail(String email){
		return loginRepo.findAllByEmail(email);
	}
}
