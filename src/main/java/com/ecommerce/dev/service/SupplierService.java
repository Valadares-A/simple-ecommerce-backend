package com.ecommerce.dev.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.dev.model.Supplier;
import com.ecommerce.dev.repository.SupplierRepository;

@Service
public class SupplierService {

	@Autowired
	private SupplierRepository providerRepository;

	public Supplier create(Supplier supplier) {
		return providerRepository.save(supplier);
	};

	public List<Supplier> getAll() {
		return providerRepository.findAll();
	};

	public Supplier getProvider(Long id) {
		return providerRepository.findById(id).get();
	}

	public Supplier updateSupplier(Long id, Supplier supplier) {
		Supplier auxProvider = providerRepository.findById(id).get();
		BeanUtils.copyProperties(supplier, auxProvider, "id");
		return providerRepository.save(auxProvider);
	};

	public String deleteSupplier(Long id) {
		providerRepository.deleteById(id);
		return "Fornecedor apagado com sucesso!";
	};

}
