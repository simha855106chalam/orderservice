package com.tcs.information.customerdetail.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.information.customerdetail.dto.CustomerDTO;
import com.tcs.information.customerdetail.entity.CustomerOrder;
import com.tcs.information.customerdetail.repository.CustomerRepository;

@Service
public class CustomerService {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CustomerRepository customerRepository;
	public void createCustomer(CustomerDTO custDTO) {
		logger.info("Create Request for Customer {}" ,custDTO);
		
		CustomerOrder cust = custDTO.createEntity();
		//Plan p = new Plan();
		//p.setPlanId(custDTO.getCurrentPlan().getPlanId());
		//cust.setPlan(p);
		customerRepository.save(cust);
	}
	
	
	
	// fetch full profile of a specific customer
	
	@SuppressWarnings("static-access")
	public CustomerDTO getCustomerProfile(Long phoneNo) {
		CustomerDTO customerDTO  = null;
		logger.info("Profile request for customer{}", phoneNo);
		Optional<CustomerOrder> optCust = customerRepository.findById(phoneNo);
		if(optCust.isPresent()) {
			CustomerOrder cust = optCust.get();
			customerDTO = customerDTO.valueOf(cust);
		}
		logger.info("Profile for customer :{}", customerDTO);
		return customerDTO;
		
	}
}
