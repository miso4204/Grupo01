package com.uniandes.stampidia.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.uniandes.stampidia.services.MockService;
import com.uniandes.stampidia.utilities.Resultado;

@RestController
@RequestMapping(value="/rest")
public class MockController {

	@Autowired
	private MockService mockService;
	
	@RequestMapping(value="/mock",method=RequestMethod.GET)
	public Resultado darClientes(){
		Resultado ro = new Resultado();	
		String mock = mockService.findOne("1");
		
		ro.setResultado(mock);
		ro.setMensajeConsulta("Este es el resultado!");
		
		
		return ro;
	}
}
