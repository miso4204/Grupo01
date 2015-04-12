package com.uniandes.stampidia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uniandes.stampidia.model.StmpShirtStyle;
import com.uniandes.stampidia.repos.ShirtStyleRepository;


@Service
@Transactional
public class ShirtStyleService {
	
	@Autowired
	private ShirtStyleRepository shirtStyleRepository;
	
	public List<StmpShirtStyle> getAllShirtStyles(){		
		return shirtStyleRepository.findAll();
	}
	

}
