package com.uniandes.stampidia.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
//@Transactional
public class MockService {
	
//	@Autowired
//	private MockRepo mockRepo;
	
	public String findOne(String key){
		return "Mock Data :)";
	}
}