package com.tts2.restapi.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tts2.restapi.model.Product;
import com.tts2.restapi.services.ProductJPARepository;

@RestController
public class ProductController {
	//gives us access to our database
	@Autowired
	ProductJPARepository productService;
	
	//Jackson converts java objects to JSON
	//returning all products
	@GetMapping("/products")
	public List<Product> getProducts() {
		return productService.findAll();
	}
	//allowing us to find the product by ID
	//products/3
	@GetMapping("/products/{id}")
	public List<Product> getProductById(@PathVariable Long id) {
		return productService.findAllById(id);
	}
	//delete a product
	@RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
	public String deleteProductById(@PathVariable Long id) {
		productService.deleteById(id);
		return "OK";
	}
	
	//when sending a post request to a endpoint you need to put all the information we want processed in the request body
	//making a new posting without declaring ID because it is automatically generated
	@PostMapping("/products")
	public String addNewProduct(@RequestBody Product product) {
		productService.save(product);
		return "OK";
	}
	
}

	
