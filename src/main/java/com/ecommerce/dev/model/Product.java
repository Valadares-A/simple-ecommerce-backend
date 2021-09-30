package com.ecommerce.dev.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // cria os metodos setter and getter automagicamente pra gente
@Entity // Dizendo pro java que essa classe é uam entidade
@Table
@AllArgsConstructor
@NoArgsConstructor
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String description;
	private String unit;

	public Product(String name, String description, String unit) {
		super();
		this.name = name;
		this.description = description;
		this.unit = unit;
	}

	public Product() {
		super();
	}

	public Product(Long id, String name, String description, String unit) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.unit = unit;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description=" + description + ", unit=" + unit + "]";
	}

}
