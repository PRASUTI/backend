package com.niit.shoppingackend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;
@Entity
@Table(name = "cart")
@Component
public class Cart {
	@Id 
	@GeneratedValue
	private int id;
	
	@Transient
	private String total;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String string) {
		this.total = string;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String string) {
		this.price = string;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String string) {
		this.quantity = string;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String string) {
		this.status = string;
	}
	private String productName;
	private String price;
	private String quantity;
	private String status;
}
