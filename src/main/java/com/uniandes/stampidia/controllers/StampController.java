package com.uniandes.stampidia.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.uniandes.stampidia.model.StmpStamp;
import com.uniandes.stampidia.services.StampService;
import com.uniandes.stampidia.utilities.Resultado;

@RestController
@RequestMapping(value="/rest")
public class StampController {

	@Autowired
	private StampService stampService;
	
	@RequestMapping("/stampService")
	//@RequestMapping(value="/stampService/{categoryId}",method=RequestMethod.GET)
	public Resultado getStamps(@RequestParam(value="categoryId", required = false) Integer categoryId){
		Resultado ro = new Resultado();
		List<StmpStamp> stamps;
		if ( categoryId != null ){
			stamps = stampService.getStampsByCategory(categoryId);
		}else{
			stamps = stampService.getAllStamps();
		}
		ro.setResultado(stamps);
		ro.setMensajeConsulta("Este es el resultado!");
		ro.setTotalObjetos(stamps.size());
		return ro;	
	}
	
	
}
