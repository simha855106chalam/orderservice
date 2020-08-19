package com.tcs.information.plans;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PlanMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlanMsApplication.class, args);
	}

}
