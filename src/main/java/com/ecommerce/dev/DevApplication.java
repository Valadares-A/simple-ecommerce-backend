package com.ecommerce.dev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ecommerce.dev.model.Supplier;

@SpringBootApplication
public class DevApplication {

	public static void main(String[] args) {
		SpringApplication.run(DevApplication.class, args);

		Supplier p = new Supplier("a", "e", "i", "o", "u");
		System.out.println(p.printEntity());
	}

}
