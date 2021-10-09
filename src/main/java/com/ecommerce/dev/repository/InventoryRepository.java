package com.ecommerce.dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.dev.model.Inventory;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {

}
