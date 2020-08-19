package com.tcs.information.customerdetail.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tcs.information.customerdetail.dto.PlanDTO;

@FeignClient("PlanMS")
public interface CustFeign {

	@RequestMapping(value="/proditems/{productCode}")
	PlanDTO getSpecificPlan(@PathVariable("productCode") int productCode);
}
