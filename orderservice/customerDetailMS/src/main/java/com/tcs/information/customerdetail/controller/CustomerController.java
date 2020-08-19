package com.tcs.information.customerdetail.controller;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.information.customerdetail.dto.CustomerDTO;
import com.tcs.information.customerdetail.dto.LoginDTO;
import com.tcs.information.customerdetail.dto.PlanDTO;
import com.tcs.information.customerdetail.service.CustomerService;
import com.tcs.information.customerdetail.service.HystrixService;



@RestController
@CrossOrigin
//@RibbonClient(name="custribbon")
public class CustomerController {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CustomerService customerService;
	
	
	@Autowired
	HystrixService hystrixService;
	/*
	 * @Autowired RestTemplate loadBalancedRestTemplate;
	 */
	/*
	 * @Autowired DiscoveryClient client;//important
	 */	/*
	@Autowired
	RestTemplate loadBalancedRestTemplate;
	
	@Value("${friend.uri}")
	String friendUri;
	
	@Value("${plan.uri}")
	String planUri;*/
	//create a new Customer
	@PostMapping(value="/customers", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void createCustomer(@RequestBody CustomerDTO customerDTO){
		logger.info("Creation request for Customer {}", customerDTO);
		customerService.createCustomer(customerDTO);
	}
	
	@RequestMapping(value="/customers/{phoneNo}",method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public CustomerDTO getCustomerProfile(@PathVariable Long phoneNo) throws InterruptedException, ExecutionException{
		System.out.println("=========Inprofile Data==========="+phoneNo);
		logger.info("profile  request for Customer {}", phoneNo);
		 CustomerDTO customerProfile = customerService.getCustomerProfile(phoneNo);
		 Future<PlanDTO> futurePlanDTO= hystrixService.getPlan(customerProfile.getCurrentPlan().getProductCode());
		 customerProfile.setCurrentPlan(futurePlanDTO.get());
		 return customerProfile;
	}
	
}
