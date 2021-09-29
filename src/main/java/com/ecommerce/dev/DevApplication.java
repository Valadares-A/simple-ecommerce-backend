package com.ecommerce.dev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ecommerce.dev.model.Product;

@SpringBootApplication
public class DevApplication {

	public static void main(String[] args) {
		SpringApplication.run(DevApplication.class, args);
//		Product teste = new Product("Caneta Bic","Caneta mais usada do mercado", "unidade");
//		System.out.println(teste.getName());
	}

}
