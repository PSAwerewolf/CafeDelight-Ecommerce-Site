package com.example.cda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.cda.global.GlobalData;
import com.example.cda.model.Products;
import com.example.cda.services.ProductsServices;

@Controller
public class CartController {

	@Autowired
	ProductsServices prodService;
	
	@GetMapping("/addtocart/{id}")
	public String addToCart(@PathVariable int id,Model model) {
		GlobalData.cart.add(prodService.getProductsById(id).get());
		model.addAttribute("product",prodService.getProductsById(id).get());
		return "redirect:/cart";
	}
	
	
	@GetMapping("/cart")
	public String cartGet(Model model) {
		model.addAttribute("cartcount",GlobalData.cart.size());
		model.addAttribute("total",GlobalData .cart.stream().mapToDouble(Products::getPrice).sum());
		model.addAttribute("cart",GlobalData.cart);
		
		return "cart";
	}
	
	
	@GetMapping("/checkout")
	public String checkoutPage() {
		return "Checkout";
	}
}
