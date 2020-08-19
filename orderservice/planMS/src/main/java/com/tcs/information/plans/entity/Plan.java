package com.tcs.information.plans.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="orderitem")
public class Plan {
	
	@Id
	@Column(name ="product_code", nullable = false)
	Integer productCode;
	@Column(name = "plan_name", nullable=false,length=50)
	String productName;
	@Column(name = "quantity", nullable=false)
	Integer quantity;
	
	
	public Integer getProductCode() {
		return productCode;
	}


	public void setProductCode(Integer productCode) {
		this.productCode = productCode;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public Integer getQuantity() {
		return quantity;
	}


	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}


	public Plan() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
