package com.ecommerce.dev.controller;

import java.sql.Array;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	public ResponseEntity<List<Product>> getAllProducts() {
		return ResponseEntity.status(HttpStatus.OK).body(productRepository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable Long id) {
		// return productRepository.getById(id); //retorna uma referencia da entity (não
		// sei como usar isso)
		return ResponseEntity.status(HttpStatus.OK).body(productRepository.findById(id).get());
	}

	@PutMapping("/{id}")
	public ResponseEntity<Product> updateProduct(@RequestBody Product product, @PathVariable Long id) {
		Product auxProduct = productRepository.findById(id).get();
		System.out.println(auxProduct);
		BeanUtils.copyProperties(product, auxProduct, "id");
		System.out.println(auxProduct);
		Product savedProduct = productRepository.save(auxProduct);
		return ResponseEntity.status(HttpStatus.OK).body(savedProduct);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
		productRepository.deleteById(id);
		return ResponseEntity.status(HttpStatus.OK).body("Produto deletado");
	}

}
