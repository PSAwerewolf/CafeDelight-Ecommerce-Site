package com.example.cda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.cda.global.GlobalData;
import com.example.cda.model.User;
import com.example.cda.services.CategoriesService;
import com.example.cda.services.ProductsServices;

@Controller
public class HomeController {

		@Autowired
		private CategoriesService catService;
		
		@Autowired
		private ProductsServices prodService;
		
		@GetMapping({"/","/home"})
		public String homePage(Model model) {
			model.addAttribute("cartcount",GlobalData.cart.size());
			return "Home";
		}
		
		@GetMapping("/aboutus")
		public String aboutusPage(Model model) {
			model.addAttribute("cartcount",GlobalData.cart.size());
			return "Aboutus";
		}
		
		@GetMapping("/contactus")
		public String contactusPage(Model model) {
			model.addAttribute("cartcount",GlobalData.cart.size());
			return "Contactus";
		}
		@GetMapping("/gallery")
		public String galleryPage(Model model) {
			model.addAttribute("cartcount",GlobalData.cart.size());
			return "Gallery";
		}
		
		@GetMapping("/login")
		public String loginPage(Model model) {
			model.addAttribute("cartcount",GlobalData.cart.size());
			model.addAttribute("userlogin",new User());
			return "Login";
		}
		
		
		@GetMapping("/order")
		public String getAllItems(Model model) {
			model.addAttribute("cartcount",GlobalData.cart.size());
			model.addAttribute("categories", catService.getAllCategory());
			model.addAttribute("products",prodService.getAllProducts());
			return "Order";
		}
		@GetMapping("/order/category/{id}")
		public String getAllItemsByCategory(Model model,@PathVariable long id) {
			model.addAttribute("cartcount",GlobalData.cart.size());
			model.addAttribute("categories", catService.getAllCategory());
			model.addAttribute("products",prodService.findProductsByCategoryId(id));
			return "Order";
		}
		
		@GetMapping("/order/viewproduct/{id}")
		public String viewProduct(Model model,@PathVariable long id) {
			model.addAttribute("cartcount",GlobalData.cart.size());
			model.addAttribute("product",prodService.getProductsById(id).get());
			return "ViewProduct";
		}
		
}
