package com.uniandes.stampidia.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.uniandes.stampidia.model.StmpSize;
import com.uniandes.stampidia.services.SizeService;
import com.uniandes.stampidia.utilities.Resultado;

@RestController
@RequestMapping(value="/rest")
public class SizeController {

	@Autowired
	private SizeService sizeService;
	
	@RequestMapping(value="/sizeService",method=RequestMethod.GET)
	public Resultado getSizes(){
		Resultado ro = new Resultado();	
		List<StmpSize> sizes = sizeService.getAllSizes();
		ro.setResultado(sizes);
		ro.setMensajeConsulta("Este es el resultado!");
		ro.setTotalObjetos(sizes.size());
		return ro;
	}
}
