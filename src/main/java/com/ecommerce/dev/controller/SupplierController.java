package com.ecommerce.dev.controller;

import java.util.List;

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

import com.ecommerce.dev.model.Supplier;
import com.ecommerce.dev.service.SupplierService;

@RestController
@RequestMapping("/supplier")
public class SupplierController {

	@Autowired
	private SupplierService supplierService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Supplier> createSupplier(@RequestBody Supplier supplier) {
		return ResponseEntity.status(HttpStatus.CREATED).body(supplierService.create(supplier));
	}

	@GetMapping("/list")
	public ResponseEntity<List<Supplier>> getAllSuplier() {
		return ResponseEntity.status(HttpStatus.OK).body(supplierService.getAll());
	};

	@GetMapping("/{id}")
	public ResponseEntity<Supplier> getSupplierById(@PathVariable Long id) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(supplierService.getProvider(id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<Supplier> updateSupplier(@RequestBody Supplier supplier, @PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(supplierService.updateSupplier(id, supplier));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteSupplier(@PathVariable Long id) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(supplierService.deleteSupplier(id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}

}
