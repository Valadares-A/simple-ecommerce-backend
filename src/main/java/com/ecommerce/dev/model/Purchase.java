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
public class Purchase {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long supplierId;
	private Long purchaseItemsId;

	public Purchase(Long supplierId, Long purchaseItemsId) {
		super();
		this.supplierId = supplierId;
		this.purchaseItemsId = purchaseItemsId;
	}

	public Purchase(Long id, Long supplierId, Long purchaseItemsId) {
		super();
		this.id = id;
		this.supplierId = supplierId;
		this.purchaseItemsId = purchaseItemsId;
	}

	public Purchase() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPurchaseItemsId() {
		return purchaseItemsId;
	}

	public void setPurchaseItemsId(Long purchaseItemsId) {
		this.purchaseItemsId = purchaseItemsId;
	}

	public Long getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}

	public String printEntity() {
		return "Purchase [id=" + id + ", purchaseItemsId=" + purchaseItemsId + "]";
	}

}
