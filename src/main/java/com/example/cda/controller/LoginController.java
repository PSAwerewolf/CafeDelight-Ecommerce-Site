package com.example.cda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.cda.global.GlobalData;
import com.example.cda.model.User;
import com.example.cda.services.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	@GetMapping("/register")
	public String registerPage(Model model) {
		model.addAttribute("cartcount",GlobalData.cart.size());
		model.addAttribute("user", new User());
		return "Register";
	}
	
	@PostMapping("/userregister")
	public String userRegister(@ModelAttribute("user") User user ) {
		loginService.saveUserDetails(user);
		return "redirect:/home";
	}
	
	@PostMapping("/userlogin/{email}")
	public String userLogin(@PathVariable String email,Model model,User users) {
		model.addAttribute("userlogin",loginService.getAllUserbyEmail(email));
		
		System.out.println(users.getEmail());
		if(users.getEmail().equals("ADMIN@admin.com") && users.getPassword().equals("admin")) {
			return "Admin";
		}else {
			return "Home";
		}
	}
}
