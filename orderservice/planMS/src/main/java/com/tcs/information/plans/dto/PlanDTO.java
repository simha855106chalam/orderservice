package com.tcs.information.plans.dto;



import com.tcs.information.plans.entity.Plan;

public class PlanDTO {
	
	Integer productCode;
	String productName;
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

public PlanDTO() {
	super();
	// TODO Auto-generated constructor stub
}

// Converts Entity into DTO

public static PlanDTO valueOF(Plan plan) {
	PlanDTO planDTO = new PlanDTO();
	planDTO.setProductCode(plan.getProductCode());
	planDTO.setProductName(plan.getProductName());
	planDTO.setQuantity(plan.getQuantity());
	return planDTO;
	
}

public Plan createEntity() {
	// TODO Auto-generated method stub
	Plan plan = new Plan();
	plan.setProductCode(this.productCode);
	plan.setProductName(this.productName);
	plan.setQuantity(this.quantity);
	return plan;
}
}
