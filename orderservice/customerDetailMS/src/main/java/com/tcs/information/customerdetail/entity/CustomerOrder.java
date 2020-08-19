package com.tcs.information.customerdetail.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "orderservice")
public class CustomerOrder {
	@Id
	@Column(name = "phone_no",nullable = false)
	Long phoneNo;
	@Column(nullable = false, length=50)
	String customerName;
	
	@Column(nullable = false, length=50)
	String shippingAddress;
	
	@Column(nullable = false, length=50)
	String orderItems;
	
	@Column(nullable = false , length=10)
	Integer  total;
	
	
	@Column(nullable = false, length=50)
	String orderDate;
	
	@Column(nullable = false , length=10)
	Integer planId;
	
	public Long getPhoneNo() {
		return phoneNo;
	}


	public Integer getPlanId() {
		return planId;
	}


	public void setPlanId(Integer planId) {
		this.planId = planId;
	}


	public void setPhoneNo(Long phoneNo) {
		this.phoneNo = phoneNo;
	}


	public String getCustomerName() {
		return customerName;
	}


	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	public String getShippingAddress() {
		return shippingAddress;
	}


	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}


	


	public String getOrderItems() {
		return orderItems;
	}


	public void setOrderItems(String orderItems) {
		this.orderItems = orderItems;
	}


	public Integer getTotal() {
		return total;
	}


	public void setTotal(Integer total) {
		this.total = total;
	}


	public String getOrderDate() {
		return orderDate;
	}


	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}


	public CustomerOrder() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
