package com.tcs.information.plans.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.information.plans.dto.PlanDTO;
import com.tcs.information.plans.service.PlanService;

@RestController
@EnableAutoConfiguration
@CrossOrigin
public class PlanController {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	PlanService planService;
	// Fetch All Plan details
	@GetMapping(value="/proditems", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<PlanDTO> getAllProducts(){
		return planService.getAllProditems();
		
	}
	
	//To get a plan details based on paln id
	@GetMapping(value="/proditems/{productCode}", produces=MediaType.APPLICATION_JSON_VALUE)
	public PlanDTO getPlan(@PathVariable("productCode") Integer productCode){
		/*
		 * if(planId.equals(0)) { throw new RuntimeException(); }
		 */
		return planService.getplan(productCode);
		
	}
	
	
	
	@PostMapping(value="/proditems", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void createProditems(@RequestBody PlanDTO planDTO){
		logger.info("Creation request for Customer {}", planDTO);
		planService.createProditem(planDTO);
	}
}
