package com.uniandes.stampidia.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.uniandes.stampidia.services.ReportService;
import com.uniandes.stampidia.utilities.Resultado;

@RestController
@RequestMapping(value="/rest")
public class ReportsController {
	
	@Autowired
	private ReportService reportsService;

	
	@RequestMapping(value="/report/sales/period",method=RequestMethod.GET)
	public Resultado getReportSalesByPeriod(@RequestParam(value="username", required = true) String username){
		Resultado resultado = new Resultado();
		resultado.setResultado(reportsService.reportSalesByPeriod(username));
		return resultado;
	}
	
	@RequestMapping(value="/report/sales/artist",method=RequestMethod.GET)
	public Resultado getReportSalesByArtist(@RequestParam(value="username", required = true) String username){
		Resultado resultado = new Resultado();
		resultado.setResultado(reportsService.reportSalesByArtist(username));
		return resultado;
	}
        
	@RequestMapping(value="/report/rating/designs",method=RequestMethod.GET)
	public Resultado reportRatingDesigns(){
		Resultado resultado = new Resultado();
		resultado.setResultado(reportsService.reportRatingDesigns());
		return resultado;
	}
	
	@RequestMapping(value="/report/rating/designs/artist",method=RequestMethod.GET)
	public Resultado reportRatingDesignsByArtist(String username){
		Resultado resultado = new Resultado();
		resultado.setResultado(reportsService.reportRatingDesignsByArtist(username));
		return resultado;
	}
}
