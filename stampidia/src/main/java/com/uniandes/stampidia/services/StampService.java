package com.uniandes.stampidia.services;

import java.math.BigInteger;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uniandes.stampidia.model.StmpCategory;
import com.uniandes.stampidia.model.StmpStamp;
import com.uniandes.stampidia.model.StmpUser;
import com.uniandes.stampidia.repos.StampRepository;
import com.uniandes.stampidia.repos.UserRepository;
import com.uniandes.stampidia.repos.CategoryRepository;
import com.uniandes.stampidia.services.StampService;


@Service
@Transactional
public class StampService {
	
	@Resource
    private Environment env;
	
	private static final String RESOURCES_SERVER = "resources.server";	
	
	@Autowired
	private StampRepository stampRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	//stampIdArtist
	//StmpCategory
	/* 
	/* 
	 * Method that return all stamps 
	 */
	public List<StmpStamp> getAllStamps(){		
		return stampRepository.findAll();
	}
	/*
	 * Method that returns stamps by category
	 */
	public List<StmpStamp> getStampsByCategory(Integer categoryId){		
		return stampRepository.findStampsByCategory(categoryId);
	}

	public StmpStamp addStamp(String stampName, String stampDescription,String stampImage, String shirtTags, Integer stampArtist,Integer stampSalesNumber, Integer stampCategory, BigInteger stampPrice) {
		Integer id = null;
		StmpStamp stamp   = new StmpStamp();
		StmpStamp entity  = new StmpStamp();
		StmpUser user = userRepository.findOne(stampArtist);
		StmpCategory category = categoryRepository.findOne(stampCategory);
		stamp.setId(id);
		stamp.setName(stampName);
		stamp.setDescription(stampDescription);
		stamp.setImage(env.getRequiredProperty(RESOURCES_SERVER)+stampImage);
		stamp.setTags(shirtTags);
		stamp.setSalesNumber(stampSalesNumber);
		stamp.setPrice(stampPrice);
		stamp.setIdArtistUser(user);
		stamp.setIdCategory(category);
		entity = stampRepository.save(stamp);
		         
		return entity;
		
	}
	public StmpStamp updateStamp(Integer id,String stampName, String stampDescription,String stampImage, String shirtTags, Integer stampArtist,Integer stampSalesNumber, Integer stampCategory, BigInteger stampPrice) {
		StmpStamp stamp   = new StmpStamp();
		StmpStamp entity  = new StmpStamp();
		StmpUser user = userRepository.findOne(stampArtist);
		StmpCategory category = categoryRepository.findOne(stampCategory);
		stamp.setId(id);
		stamp.setName(stampName);
		stamp.setDescription(stampDescription);
		stamp.setImage(env.getRequiredProperty(RESOURCES_SERVER)+stampImage);
		stamp.setTags(shirtTags);
		stamp.setSalesNumber(stampSalesNumber);
		stamp.setPrice(stampPrice);
		stamp.setIdArtistUser(user);
		stamp.setIdCategory(category);
		entity = stampRepository.save(stamp);
		         
		return entity;
		
	}
	
	/*
	 * Method that returns stamp by id
	 */
	public StmpStamp getStampById(Integer stampId){		
		return stampRepository.findOne(stampId);
	}
	
	public StmpStamp getSalesById(Integer stampId){		
		return stampRepository.findOne(stampId);
	}
}
