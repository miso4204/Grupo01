package com.uniandes.stampidia.services;

import com.uniandes.stampidia.model.*;
import com.uniandes.stampidia.repos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class ShirtRatingService {
	
	@Autowired
    private ShirtRatingRepository shirtRatingRepository;
	
	public StmpShirtRating createShirtRating(StmpShirtRating rating){
		return shirtRatingRepository.save(rating);
	}
}
