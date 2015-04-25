package com.uniandes.stampidia.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.uniandes.stampidia.model.StmpCategory;
import com.uniandes.stampidia.services.CategoryService;
import com.uniandes.stampidia.utilities.Resultado;

@RestController
@RequestMapping(value="/rest")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping(value="/categoryService",method=RequestMethod.GET)
	public Resultado getSizes(){
		Resultado ro = new Resultado();	
		List<StmpCategory> category = categoryService.getAllCategories();
		ro.setResultado(category);
		ro.setMensajeConsulta("Este es el resultado!");
		ro.setTotalObjetos(category.size());
		return ro;
	}
}
