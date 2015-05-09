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

	
	@RequestMapping(value="/report_by_period",method=RequestMethod.GET)
	public Resultado getReportByPeriod(@RequestParam(value="username", required = true) String username){
		Resultado resultado = new Resultado();
		resultado.setResultado(reportsService.reportByPeriod(username));
		return resultado;
	}
	
	@RequestMapping(value="/report_by_sales",method=RequestMethod.GET)
	public Resultado getReportBySales(@RequestParam(value="username", required = true) String username){
		Resultado resultado = new Resultado();
		resultado.setResultado(reportsService.reportBySales(username));
		return resultado;
	}
}
