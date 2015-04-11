package com.uniandes.stampidia.controllers;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.uniandes.stampidia.model.StmpShirt;
import com.uniandes.stampidia.services.ShirtService;
import com.uniandes.stampidia.utilities.Resultado;

@RestController
@RequestMapping(value="/rest")
public class ShirtController {

	@Autowired
	private ShirtService shirtService;
	
	@RequestMapping(value="/shirtService",method=RequestMethod.GET)
	public Resultado getShirts(HttpServletResponse res, @RequestParam(value="categoryId", required = false) Integer categoryId,
			                   @RequestParam(value="stampId", required = false) Integer stampId){
		Resultado ro = new Resultado();
		List<StmpShirt> shirts;
		if ( categoryId != null  &&  stampId != null ){
			shirts = shirtService.getShirtsByStampByCategory(stampId, categoryId);
		}else if( categoryId != null ){
			shirts = shirtService.getShirtsByCategory(categoryId);
		}else if ( stampId != null ){
			shirts = shirtService.getShirtsByStamp(stampId);
		}else{
			shirts = shirtService.getAllShirts();
		}
		ro.setResultado(shirts);
		ro.setMensajeConsulta("Este es el resultado!");
		ro.setTotalObjetos(shirts.size());
		return ro;	
	}
	
	@RequestMapping(value="/shirtService/{shirtText}/{shirtIdColor}/{shirtIdStyle}/{shirtIdSize}/{shirtIdStamp}/{shirtIdUser}",method= RequestMethod.PUT)
    public Resultado addIShirt(
            @PathVariable("shirtText") String shirtText,
            @PathVariable("shirtIdColor")Integer shirtIdColor,
            @PathVariable("shirtIdStyle")Integer shirtIdStyle,
            @PathVariable("shirtIdSize")Integer shirtIdSize,
            @PathVariable("shirtIdStamp")Integer shirtIdStamp,
            @PathVariable("shirtIdUser")Integer shirtIdUser){
        Resultado resultado = new Resultado();
        StmpShirt shirt = new StmpShirt();
        shirt = shirtService.addShirt(shirtText, shirtIdColor, shirtIdStyle, shirtIdSize, shirtIdStamp, shirtIdUser);
        resultado.setResultado(shirt);
        return resultado;
    }
}
