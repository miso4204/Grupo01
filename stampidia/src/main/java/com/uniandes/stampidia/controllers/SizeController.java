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
import com.uniandes.stampidia.utilities.Constantes;
import com.uniandes.stampidia.utilities.ConvertObjetHelper;
import com.uniandes.stampidia.utilities.Resultado;
import com.uniandes.stampidia.utilities.Status;
import com.uniandes.stampidia.utilities.enums.EStatusType;

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
		ro.setResultado(ConvertObjetHelper.listToMap(sizes));
		ro.setMensajeConsulta( Constantes.SUCCESS_RESULT.getDescription());
		ro.setEstado(new Status(EStatusType.OK, Constantes.SUCCESS_RESULT.getDescription()));
		ro.setTotalObjetos(sizes.size());
		return ro;
	}
	
	@Secured("ROLE_SELLER")
	@RequestMapping(value="/sizeServiceSeller",method=RequestMethod.GET)
	public Resultado getSizesForSeller(){
		Resultado ro = new Resultado();	
		List<StmpSize> sizes = sizeService.getAllSizes();
		ro.setResultado(ConvertObjetHelper.listToMap(sizes));
		ro.setMensajeConsulta( Constantes.SUCCESS_RESULT.getDescription());
		ro.setEstado(new Status(EStatusType.OK, Constantes.SUCCESS_RESULT.getDescription()));
		ro.setTotalObjetos(sizes.size());
		return ro;
	}
}
