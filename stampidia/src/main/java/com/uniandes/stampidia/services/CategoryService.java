package com.uniandes.stampidia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uniandes.stampidia.model.StmpCategory;
import com.uniandes.stampidia.repos.CategoryRepository;


@Service
@Transactional
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	public List<StmpCategory> getAllCategories(){		
		return categoryRepository.findAll();
	}
	

}
