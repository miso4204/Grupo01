package com.uniandes.stampidia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uniandes.stampidia.model.StmpColor;
import com.uniandes.stampidia.model.StmpShirt;
import com.uniandes.stampidia.model.StmpShirtStyle;
import com.uniandes.stampidia.model.StmpSize;
import com.uniandes.stampidia.model.StmpStamp;
import com.uniandes.stampidia.model.StmpUser;
import com.uniandes.stampidia.repos.ColorRepository;
import com.uniandes.stampidia.repos.ShirtRepository;
import com.uniandes.stampidia.repos.ShirtStyleRepository;
import com.uniandes.stampidia.repos.SizeRepository;
import com.uniandes.stampidia.repos.StampRepository;
import com.uniandes.stampidia.repos.UserRepository;


@Service
@Transactional
public class ShirtService {
	
	@Autowired
    private ColorRepository colorRepository;
	
	@Autowired
    private ShirtRepository shirtRepository;
	
	@Autowired
    private ShirtStyleRepository shirtStyleRepository;
	
	@Autowired
    private StampRepository stampRepository;
	
	@Autowired
    private SizeRepository sizeRepository;
	
	@Autowired
    private UserRepository userRepository;
	
	
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
	
	/*
	 * Method that returns stamps by stamp
	*/
	public StmpShirt addShirt(String shirtText,Integer shirtIdColor,Integer shirtIdStyle,Integer shirtIdSize,Integer shirtIdStamp,Integer shirtIdUser){		
		Integer id = null;
		StmpShirt shirt  = new StmpShirt();
		StmpShirt entity  = new StmpShirt();
		StmpColor color = colorRepository.findOne(shirtIdColor);
		StmpShirtStyle style = shirtStyleRepository.findOne(shirtIdStyle);
		StmpSize size = sizeRepository.findOne(shirtIdSize);
		StmpStamp stamp = stampRepository.findOne(shirtIdStamp);
		StmpUser user = userRepository.findOne(shirtIdUser);
		shirt.setId(id);
		shirt.setIdArtistUser(user);
		shirt.setIdColor(color);
		shirt.setIdStyle(style);
		shirt.setIdSize(size);
		shirt.setIdStamp(stamp);
		shirt.setText(shirtText);
		entity = shirtRepository.save(shirt);
		return entity;
	}
	
	public StmpShirt getShirtById(Integer shirtId){		
		return shirtRepository.findOne(shirtId);
	}
	
	public StmpShirt getSalesById(Integer shirtId){		
		return shirtRepository.findOne(shirtId);
	}
	

}
