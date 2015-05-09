package com.uniandes.stampidia.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.uniandes.stampidia.model.StmpColor;
import com.uniandes.stampidia.services.ColorService;
import com.uniandes.stampidia.utilities.Constantes;
import com.uniandes.stampidia.utilities.Resultado;
import com.uniandes.stampidia.utilities.Status;
import com.uniandes.stampidia.utilities.enums.EStatusType;

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
		ro.setMensajeConsulta( Constantes.SUCCESS_RESULT.getDescription());
		ro.setEstado(new Status(EStatusType.OK, Constantes.SUCCESS_RESULT.getDescription()));
		ro.setTotalObjetos(colors.size());
		return ro;
	}
}
