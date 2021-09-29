package com.ecommerce.dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.dev.model.Product;

@Repository //funcionalidades com o banco de dados
public interface ProductRepository extends JpaRepository<Product, Long> {

}
