package com.uniandes.stampidia.controllers;

import com.uniandes.stampidia.model.StmpShirtRating;
import com.uniandes.stampidia.services.ShirtRatingService;
import com.uniandes.stampidia.utilities.Constantes;
import com.uniandes.stampidia.utilities.ConvertObjetHelper;
import com.uniandes.stampidia.utilities.Resultado;
import com.uniandes.stampidia.utilities.Status;
import com.uniandes.stampidia.utilities.enums.EStatusType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value="/rest")
public class RateProductsController {

    @Autowired
    private ShirtRatingService ratingService;

    @RequestMapping(value="/product/rate",method= RequestMethod.PUT)
    public Resultado rateProducts(
            @RequestBody StmpShirtRating rating){
        Resultado resultado = new Resultado();

        if(!rating.isNull()){

            StmpShirtRating newRating = ratingService.createShirtRating(rating);

            if(newRating != null){
                resultado.setResultado(ConvertObjetHelper.objectToMap(newRating));
                resultado.setEstado(new Status(EStatusType.OK, Constantes.SUCCESS_RESULT.getDescription()));
            }else {
                resultado.setEstado(new Status(EStatusType.ERROR, Constantes.ERROR_RESULT.getDescription()));
            }

        }else {
            resultado.setEstado(new Status(EStatusType.ERROR, Constantes.INVALID_PARAMS_RESULT.getDescription()));
        }

        return resultado;
    }

}
