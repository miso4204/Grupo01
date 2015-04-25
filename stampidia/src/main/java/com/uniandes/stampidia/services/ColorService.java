package com.uniandes.stampidia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uniandes.stampidia.model.StmpColor;
import com.uniandes.stampidia.repos.ColorRepository;


@Service
@Transactional
public class ColorService {
	
	@Autowired
	private ColorRepository colorRepository;
	
	public List<StmpColor> getAllColors(){		
		return colorRepository.findAll();
	}
	

}
