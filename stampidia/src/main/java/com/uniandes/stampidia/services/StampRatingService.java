package com.uniandes.stampidia.services;

import com.uniandes.stampidia.model.StmpCategory;
import com.uniandes.stampidia.model.StmpStamp;
import com.uniandes.stampidia.model.StmpStampRating;
import com.uniandes.stampidia.model.StmpUser;
import com.uniandes.stampidia.repos.CategoryRepository;
import com.uniandes.stampidia.repos.StampRepository;
import com.uniandes.stampidia.repos.StampratingRepository;
import com.uniandes.stampidia.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigInteger;
import java.util.List;


@Service
@Transactional
public class StampRatingService {
	
	@Autowired
	private StampratingRepository stampratingRepository;
	@Autowired
	private StampRepository stampRepository;
    @Autowired
	private UserRepository userRepository;

	public StmpStampRating createStampRating(StmpStampRating rating){
        if(rating.getIdUser() != null && rating.getIdStamp() != null) {
            rating.setIdStamp(stampRepository.findOne(rating.getIdStamp().getId()));
            rating.setIdUser(userRepository.findOne(rating.getIdUser().getId()));

            return stampratingRepository.save(rating);
        }
		return null;
	}
	
}
