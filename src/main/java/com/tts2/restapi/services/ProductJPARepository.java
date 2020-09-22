package com.tts2.restapi.services;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tts2.restapi.model.Product;

//picking the product class we created, and picking the ID datatype of our product
//giving us connection to our database
public interface ProductJPARepository extends JpaRepository<Product, Long> {
	
	//declaring finding the product by id method in our controller
	List<Product> findAllById(Long id);


}
