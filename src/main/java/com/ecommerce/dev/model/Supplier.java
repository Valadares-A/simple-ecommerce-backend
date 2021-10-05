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
public class Supplier {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String cnpj;
	private String name;
	private String phone;
	private String email;
	private String address;

	public Supplier(String cnpj, String name, String phone, String email, String address) {
		super();
		this.cnpj = cnpj;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.address = address;
	}

	public Supplier() {
		super();
	}

	public Supplier(Long id, String cnpj, String name, String phone, String email, String address) {
		super();
		this.id = id;
		this.cnpj = cnpj;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.address = address;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String printEntity() {
		return "Provider [id=" + id + ", cnpj=" + cnpj + ", name=" + name + ", phone=" + phone + ", email=" + email
				+ ", address=" + address + "]";
	}

}
