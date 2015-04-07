package com.uniandes.stampidia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.uniandes.stampidia.model.StmpStamp;
import com.uniandes.stampidia.repos.StampRepository;

@Service
@Transactional
public class StampService {
	
	@Autowired
	private StampRepository stampRepository;
	/* 
	 * Method that return all stamps 
	 */
	public List<StmpStamp> getAllStamps(){		
		return stampRepository.findAll();
	}
	/*
	 * Method that returns stamps by category
	 */
	public List<StmpStamp> getStampsByCategory(Integer categoryId){		
		return stampRepository.findStampsByCategory(categoryId);
	}

}
