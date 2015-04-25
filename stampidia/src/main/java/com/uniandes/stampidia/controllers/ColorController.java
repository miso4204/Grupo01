package com.uniandes.stampidia.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.uniandes.stampidia.model.StmpColor;
import com.uniandes.stampidia.services.ColorService;
import com.uniandes.stampidia.utilities.Resultado;

@RestController
@RequestMapping(value="/rest")
public class ColorController {

	@Autowired
	private ColorService colorService;
	
	@RequestMapping(value="/colorService",method=RequestMethod.GET)
	public Resultado getSizes(){
		Resultado ro = new Resultado();	
		List<StmpColor> colors = colorService.getAllColors();
		ro.setResultado(colors);
		ro.setMensajeConsulta("Este es el resultado!");
		ro.setTotalObjetos(colors.size());
		return ro;
	}
}
