package com.tcs.information.customerdetail.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.command.AsyncResult;
import com.tcs.information.customerdetail.controller.CustFeign;
import com.tcs.information.customerdetail.dto.PlanDTO;

@Service
public class HystrixService {
	
	@Autowired
	RestTemplate hystrixRestTemplate;
	
	@Autowired
	CustFeign planCustFeign;
	
	@HystrixCommand(fallbackMethod = "getSpecificPlanFallBack")
	public Future<PlanDTO> getPlan(int productCode) {
		return new AsyncResult<PlanDTO>() {
			//@Override 
			@Override
			public PlanDTO invoke() { 
				//return  hystrixRestTemplate.getForObject("http://PLANMS"+"/plans/"+planId,PlanDTO.class);
				return planCustFeign.getSpecificPlan(productCode);
			}
					 
		};
		
	}
	public PlanDTO getSpecificPlanFallBack(int planId) {
		return new PlanDTO();
		
	}
	
	
	

}
