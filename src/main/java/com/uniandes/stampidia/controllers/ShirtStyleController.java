package com.uniandes.stampidia.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.uniandes.stampidia.model.StmpShirtStyle;
import com.uniandes.stampidia.services.ShirtStyleService;
import com.uniandes.stampidia.utilities.Resultado;

@RestController
@RequestMapping(value="/rest")
public class ShirtStyleController {

	@Autowired
	private ShirtStyleService shirtStyleService;
	
	@RequestMapping(value="/shirtStyleService",method=RequestMethod.GET)
	public Resultado getStylesShirts(){
		Resultado ro = new Resultado();	
		List<StmpShirtStyle> shirtStyle = shirtStyleService.getAllShirtStyles();
		ro.setResultado(shirtStyle);
		ro.setMensajeConsulta("Este es el resultado!");
		ro.setTotalObjetos(shirtStyle.size());
		return ro;
	}
}
