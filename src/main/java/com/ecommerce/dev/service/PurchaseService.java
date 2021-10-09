package com.ecommerce.dev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.dev.model.Purchase;
import com.ecommerce.dev.model.PurchaseItems;
import com.ecommerce.dev.repository.PurchaseItemsRepository;
import com.ecommerce.dev.repository.PurchaseRepository;

@Service
public class PurchaseService {

	@Autowired
	private PurchaseRepository purchaseRepository;
	@Autowired
	private PurchaseItemsRepository purchaseItemsRepository;

	public Purchase create(Long supplierId, PurchaseItems purchaseInfo) {
		PurchaseItems pInfo = purchaseItemsRepository.save(purchaseInfo);
		Purchase purchase = new Purchase(supplierId, pInfo.getId());
		return purchaseRepository.save(purchase);
	}

	public Purchase getPurchase(Long id) {
		return purchaseRepository.findById(id).get();
	}

}
