package com.ecommerce.dev.controller;

import java.sql.Array;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.dev.model.Product;
import com.ecommerce.dev.repository.ProductRepository;

@RestController // onde fica os endpoints relacionado ao product
@RequestMapping("/product") // aqui ele cria um prefix, dai os mappings a baixo, são tipo uma soma de
							// strings
public class ProductController {

	@Autowired
	private ProductRepository productRepository;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Product> createProduct(@RequestBody Product product, HttpServletResponse response) {
		Product savedProduct = productRepository.save(product);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedProduct);
	}

	@GetMapping("/list")
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@DeleteMapping("/{id}")
	public Product deleteProduct(@PathVariable Long id) {
		System.out.println(id);
		productRepository.deleteById(id);
		return null;

	}

}
