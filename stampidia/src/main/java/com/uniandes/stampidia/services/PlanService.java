package com.uniandes.stampidia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uniandes.stampidia.model.SmtpPlan;
import com.uniandes.stampidia.repos.PlanRepository;

@Service
@Transactional
public class PlanService {
	
	@Autowired
	private PlanRepository planRepository;
	

	
	public List<SmtpPlan> getAllPlans(){
		
		return planRepository.findAll();
	}
	
	public SmtpPlan getPlan(Integer planId){
		SmtpPlan answer = null;

        answer = (SmtpPlan) planRepository.findOne(planId);

        return answer;
    }
	

}
