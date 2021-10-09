package com.ecommerce.dev.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseItems {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long productId;
	private Integer quantity;
	private Integer value;
	
	public PurchaseItems(Long productId, Integer quantity, Integer value) {
		super();
		this.productId = productId;
		this.quantity = quantity;
		this.value = value;
	}

	public PurchaseItems() {
		super();
	}

	public PurchaseItems(Long id, Long productId, Integer quantity, Integer value) {
		super();
		this.id = id;
		this.productId = productId;
		this.quantity = quantity;
		this.value = value;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public String printEntity() {
		return "PurchaseItems [id=" + id + ", productId=" + productId + ", quantity=" + quantity + ", value=" + value
				+ "]";
	}
	
	

}
