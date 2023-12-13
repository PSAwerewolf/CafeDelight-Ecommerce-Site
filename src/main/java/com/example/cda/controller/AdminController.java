package com.example.cda.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.cda.dto.ProductDTO;
import com.example.cda.model.Categories;
import com.example.cda.model.Products;
import com.example.cda.model.User;
import com.example.cda.services.CategoriesService;
import com.example.cda.services.ProductsServices;


@Controller
public class AdminController {
	
	public static String uploadDIR = System.getProperty("user.dir") + "/src/main/resources/static/productImages";
	
	@Autowired
	public CategoriesService catService;
	
	@Autowired
	public ProductsServices prodService;
	
	@GetMapping("/admin")
	public String getadminPage(Model model) {
		model.addAttribute("userlogin",new User());
		return "Login";
	}
	
	@GetMapping("/admin/categories")
	public String getadminCategories(Model model) {
		model.addAttribute("categories", catService.getAllCategory());
		return "Categories";
	}
	
	@GetMapping("/admin/addcategories")
	public String addCategories(Model model) {
		model.addAttribute("category", new Categories());
		return "AddCategories";
	}
	
	@PostMapping("/admin/addcategories")
	public String postCategories(@ModelAttribute("category") Categories category) {
		catService.addCategory(category);
		return "redirect:/admin/categories";
	}
	
	@GetMapping("/admin/categories/delete/{id}")
	public String deleteCategories(@PathVariable int id) {
		catService.removeCategory(id);
		return "redirect:/admin/categories";
	}
	
	@GetMapping("/admin/categories/update/{id}")
	public String updateCategories(@PathVariable int id, Model model) {
		Optional<Categories> category = catService.updateCategoryById(id);
		
		if(category.isPresent()) {
			model.addAttribute("category" , category.get());
			return "AddCategories";
		}else {
			return "404";
		}
		
	}
	
	//Products Section
	
	@GetMapping("/admin/products")
	public String getadminProducts(Model model) {
		model.addAttribute("products", prodService.getAllProducts());
		return "Products";
	}
	
	@GetMapping("/admin/products/add")
	public String getaddProducts(Model model) {
		model.addAttribute("productDTO", new ProductDTO());
		model.addAttribute("categories", catService.getAllCategory());
		return "AddProducts";
	}
	
	
	@PostMapping("/admin/products/add")
	public String postaddProducts(@ModelAttribute("productDTO") ProductDTO productDTO ,
									@RequestParam("productImage") MultipartFile file,
									@RequestParam("imgName") String imgName) throws IOException{
		
		Products product=new Products();
		product.setId(productDTO.getId());
		product.setName(productDTO.getName());
		product.setPrice(productDTO.getPrice());
		product.setWeight(productDTO.getWeight());
		product.setDescription(productDTO.getDescription());
		product.setCategory(catService.updateCategoryById(productDTO.getCategoryId()).get());
		
		String imagetempID;
		if(!file.isEmpty()) {
		
			imagetempID = file.getOriginalFilename();
			Path fileNameAndPath = Paths.get(uploadDIR,imagetempID);
			Files.write(fileNameAndPath, file.getBytes());
		}else {
			imagetempID = imgName;
			product.setImageName(imgName);
			prodService.addProducts(product);
			
		}
		
		product.setImageName(imagetempID);
		prodService.addProducts(product);
		return "redirect:/admin/products";
	}
	
	
	@GetMapping("/admin/products/delete/{id}")
	public String deleteProducts(@PathVariable long id) {
		prodService.removeProducts(id);
		return "redirect:/admin/products";
	}
	
	@GetMapping("/admin/products/update/{id}")
	public String updateProducts(@PathVariable int id, Model model) {
		Products product = prodService.getProductsById(id).get();
		ProductDTO productDTO=new ProductDTO();
		
		productDTO.setId(product.getId());
		productDTO.setName(product.getName());
		productDTO.setPrice(product.getPrice());
		productDTO.setWeight(product.getWeight());
		productDTO.setDescription(product.getDescription());
		productDTO.setCategoryId(product.getCategory().getId());
		productDTO.setImageName(product.getImageName());
		
		model.addAttribute("categories" ,catService.getAllCategory());
		model.addAttribute("productDTO", productDTO);
		
		return "AddProducts";
	}
		
	
}
