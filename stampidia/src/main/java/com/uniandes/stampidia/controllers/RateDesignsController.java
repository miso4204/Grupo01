package com.uniandes.stampidia.controllers;

import com.uniandes.stampidia.model.StmpOrder;
import com.uniandes.stampidia.model.StmpOrderDetail;
import com.uniandes.stampidia.model.StmpStampRating;
import com.uniandes.stampidia.services.CartService;
import com.uniandes.stampidia.services.StampRatingService;
import com.uniandes.stampidia.utilities.Constantes;
import com.uniandes.stampidia.utilities.Resultado;
import com.uniandes.stampidia.utilities.Status;
import com.uniandes.stampidia.utilities.enums.EStatusType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value="/rest")
public class RateDesignsController {

    @Autowired
    private StampRatingService ratingService;

    @RequestMapping(value="/design/rate",method= RequestMethod.PUT)
    public Resultado rateDesigns(
            @RequestBody StmpStampRating rating){
        Resultado resultado = new Resultado();

        if(!rating.isNull()){

            StmpStampRating newRating = ratingService.createStampRating(rating);

            if(newRating != null){
                resultado.setResultado(newRating);
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
