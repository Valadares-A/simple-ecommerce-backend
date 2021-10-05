package com.ecommerce.dev.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.dev.model.Product;
import com.ecommerce.dev.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public Product create(Product product) {
		return productRepository.save(product);
	};

	public List<Product> getAll() {
		return productRepository.findAll();
	};

	public Product getProduct(Long id) {
		// return productRepository.getById(id); //retorna uma referencia da entity (não
		// sei como usar isso)
		return productRepository.findById(id).get();
	};

	public Product editProduct(Long id, Product product) {
		Product auxProduct = productRepository.findById(id).get();
		auxProduct.printEntity();
		BeanUtils.copyProperties(product, auxProduct, "id");
		auxProduct.printEntity();
		return productRepository.save(auxProduct);
	};

	public String delete(Long id) {
		productRepository.deleteById(id);
		return "Produto deletado";
	};

}
