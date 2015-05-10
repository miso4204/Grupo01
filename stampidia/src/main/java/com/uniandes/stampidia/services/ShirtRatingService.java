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
    @Autowired
    private ShirtRepository shirtRepository;
    @Autowired
    private UserRepository userRepository;
	
	public StmpShirtRating createShirtRating(StmpShirtRating rating){
        if(rating.getIdUser() != null && rating.getIdShirt() != null) {
            rating.setIdShirt(shirtRepository.findOne(rating.getIdShirt().getId()));
            rating.setIdUser(userRepository.findOne(rating.getIdUser().getId()));

            return shirtRatingRepository.save(rating);
        }
        return null;
	}
}
