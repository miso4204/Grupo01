package com.uniandes.stampidia.controllers;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;

import com.uniandes.stampidia.model.StmpStamp;
import com.uniandes.stampidia.services.StampService;
import com.uniandes.stampidia.utilities.Resultado;

//@Controller
@RestController
@RequestMapping(value="/rest")
public class StampController {

	@Autowired
	private StampService stampService;
	
	@RequestMapping(value="/stampService",method=RequestMethod.GET)
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
	@RequestMapping(value="/stampService/{stampName}/{stampDescription}/{stampImage}/{stampTags}/{stampArtist}/{stampSalesNumber}/{stampCategory}/{stampPrice}",method= RequestMethod.PUT)
	//@RequestMapping(value="/addStamp/{stampName}/{stampDescription}/{stampImage}/{stampTags}",method= RequestMethod.PUT)
	public Resultado addStamp(
            @PathVariable("stampName") String stampName,
            @PathVariable("stampDescription")String stampDescription,
            @PathVariable("stampImage")String stampImage,
            @PathVariable("stampTags")String stampTags,
            @PathVariable("stampArtist")Integer stampArtist,
            @PathVariable("stampSalesNumber")Integer stampSalesNumber,
            @PathVariable("stampCategory")Integer stampCategory,
            @PathVariable("stampPrice")BigInteger stampPrice){
		
		Resultado resultado = new Resultado();
        StmpStamp stamp = new StmpStamp();
        stamp = stampService.addStamp(stampName, stampDescription,stampImage,stampTags,stampArtist,stampSalesNumber,stampCategory,stampPrice);
        resultado.setResultado(stamp);
        return resultado;
        
		
    }
	
	@RequestMapping(value="/stampService/{stampid}/{stampName}/{stampDescription}/{stampImage}/{stampTags}/{stampArtist}/{stampSalesNumber}/{stampCategory}/{stampPrice}",method= RequestMethod.PUT)
	//@RequestMapping(value="/addStamp/{stampName}/{stampDescription}/{stampImage}/{stampTags}",method= RequestMethod.PUT)
	public Resultado updateStamp(
			@PathVariable("stampid") Integer stampId,
            @PathVariable("stampName") String stampName,
            @PathVariable("stampDescription")String stampDescription,
            @PathVariable("stampImage")String stampImage,
            @PathVariable("stampTags")String stampTags,
            @PathVariable("stampArtist")Integer stampArtist,
            @PathVariable("stampSalesNumber")Integer stampSalesNumber,
            @PathVariable("stampCategory")Integer stampCategory,
            @PathVariable("stampPrice")BigInteger stampPrice){
		
		Resultado resultado = new Resultado();
        StmpStamp stamp = new StmpStamp();
        stamp = stampService.updateStamp(stampId,stampName, stampDescription,stampImage,stampTags,stampArtist,stampSalesNumber,stampCategory,stampPrice);
        resultado.setResultado(stamp);
        return resultado;
        
		
    }
	
	@RequestMapping("/stampService/{stampId}")
    public Resultado getStampById(
            @PathVariable("stampId")Integer stampId){
		Resultado ro = new Resultado();
		StmpStamp stamp;
		stamp = stampService.getStampById(stampId);
		ro.setResultado(stamp);
		ro.setMensajeConsulta("Stamp:");
		return ro;	
	}
	
	
}

