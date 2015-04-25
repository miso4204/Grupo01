package com.uniandes.stampidia.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.uniandes.stampidia.model.SmtpPlan;

public interface PlanRepository extends CrudRepository<SmtpPlan,Integer>{

	SmtpPlan findOne(Integer id);
	
	List<SmtpPlan> findAll();
}
