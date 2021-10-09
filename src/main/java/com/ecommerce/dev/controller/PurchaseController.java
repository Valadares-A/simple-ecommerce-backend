package com.ecommerce.dev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.dev.model.Purchase;
import com.ecommerce.dev.model.PurchaseItems;
import com.ecommerce.dev.service.PurchaseService;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {

	@Autowired
	private PurchaseService purchaseService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Purchase> createProduct(@RequestBody PurchaseInfo purchaseInfo) {
		PurchaseItems p = new PurchaseItems(purchaseInfo.getProductId(), purchaseInfo.getQuantity(),
				purchaseInfo.getValue());
		return ResponseEntity.status(HttpStatus.CREATED).body(purchaseService.create(purchaseInfo.getSupplierId(), p));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Purchase> getProductById(@PathVariable Long id) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(purchaseService.getPurchase(id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}

}

class PurchaseInfo extends PurchaseItems {

	private Long supplierId;

	public Long getSupplierId() {
		return supplierId;
	}

}