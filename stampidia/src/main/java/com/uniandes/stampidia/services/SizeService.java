package com.uniandes.stampidia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uniandes.stampidia.model.StmpSize;
import com.uniandes.stampidia.repos.SizeRepository;

@Service
@Transactional
public class SizeService {
	
	@Autowired
	private SizeRepository sizeRepository;
	

	
	public List<StmpSize> getAllSizes(){
		
		return sizeRepository.findAll();
	}
	

}
