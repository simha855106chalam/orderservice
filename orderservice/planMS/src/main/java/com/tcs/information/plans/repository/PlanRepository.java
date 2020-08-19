package com.tcs.information.plans.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.information.plans.entity.Plan;

public interface PlanRepository extends JpaRepository<Plan, Integer> {

}
