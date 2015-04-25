package com.uniandes.stampidia.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
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
	
	@Secured("ROLE_BUYER")
	@RequestMapping(value="/sizeServiceBuyer",method=RequestMethod.GET)
	public Resultado getSizesForBuyer(){
		Resultado ro = new Resultado();	
		List<StmpSize> sizes = sizeService.getAllSizes();
		ro.setResultado(sizes);
		ro.setMensajeConsulta("Este es el resultado para compradores!");
		ro.setTotalObjetos(sizes.size());
		return ro;
	}
	
	@Secured("ROLE_SELLER")
	@RequestMapping(value="/sizeServiceSeller",method=RequestMethod.GET)
	public Resultado getSizesForSeller(){
		Resultado ro = new Resultado();	
		List<StmpSize> sizes = sizeService.getAllSizes();
		ro.setResultado(sizes);
		ro.setMensajeConsulta("Este es el resultado para vendedores!");
		ro.setTotalObjetos(sizes.size());
		return ro;
	}
}
