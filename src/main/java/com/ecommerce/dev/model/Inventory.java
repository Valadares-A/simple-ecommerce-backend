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
public class Inventory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long productId;
	private Integer quantity;
	private Integer saleValue;

	public Inventory(Long productId, Integer quantity, Integer saleValue) {
		super();
		this.productId = productId;
		this.quantity = quantity;
		this.saleValue = saleValue;
	}

	public Inventory() {
		super();
	}

	public Inventory(Long id, Long productId, Integer quantity, Integer saleValue) {
		super();
		this.id = id;
		this.productId = productId;
		this.quantity = quantity;
		this.saleValue = saleValue;
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

	public Integer getSaleValue() {
		return saleValue;
	}

	public void setSaleValue(Integer saleValue) {
		this.saleValue = saleValue;
	}

	public String printEntity() {
		return "Inventory [id=" + id + ", productId=" + productId + ", quantity=" + quantity + ", saleValue="
				+ saleValue + "]";
	}

}
