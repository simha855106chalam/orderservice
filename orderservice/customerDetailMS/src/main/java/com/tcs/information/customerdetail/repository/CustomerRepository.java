package com.tcs.information.customerdetail.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.information.customerdetail.entity.CustomerOrder;



public interface CustomerRepository extends JpaRepository<CustomerOrder, Long> {

}
