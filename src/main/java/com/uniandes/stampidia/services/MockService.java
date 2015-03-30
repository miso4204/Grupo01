package com.uniandes.stampidia.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uniandes.stampidia.repos.MockRepo;

@Service
@Transactional
public class MockService {
	@Autowired
	private MockRepo mockRepo;
	
	public String findOne(String key){
		return mockRepo.findOne(key);
	}
}