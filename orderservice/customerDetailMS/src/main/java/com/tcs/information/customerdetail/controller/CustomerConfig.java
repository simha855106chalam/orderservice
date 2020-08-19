package com.tcs.information.customerdetail.controller;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class CustomerConfig {
	
	@Bean @LoadBalanced
	RestTemplate restTemplate() {
		return new RestTemplate();
		
	}

}