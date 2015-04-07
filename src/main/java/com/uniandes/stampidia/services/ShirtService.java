package com.uniandes.stampidia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uniandes.stampidia.model.StmpShirt;
import com.uniandes.stampidia.repos.ShirtRepository;


@Service
@Transactional
public class ShirtService {
	
	@Autowired
	private ShirtRepository shirtRepository;
	
	public List<StmpShirt> getAllShirts(){		
		return shirtRepository.findAll();
	}
	/*
	 * Method that returns stamps by category
	 */
	public List<StmpShirt> getShirtsByCategory(Integer categoryId){		
		return shirtRepository.findShirtByCategory(categoryId);
	}
	/*
	 * Method that returns stamps by stamp
	 */
	public List<StmpShirt> getShirtsByStamp(Integer stampId){		
		return shirtRepository.findShirtByStamp(stampId);
	}
	/*
	 * Method that returns stamps by stamp
	*/
	public List<StmpShirt> getShirtsByStampByCategory(Integer stampId, Integer categoryId){		
		return shirtRepository.findShirtByStampByCategory(stampId,categoryId);
	}

}
