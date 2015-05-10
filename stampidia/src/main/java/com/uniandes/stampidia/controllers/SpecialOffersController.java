package com.uniandes.stampidia.controllers;

import com.uniandes.stampidia.model.StmpOfert;
import com.uniandes.stampidia.model.StmpShirtRating;
import com.uniandes.stampidia.repos.ShirtRatingRepository;
import com.uniandes.stampidia.services.OfferService;
import com.uniandes.stampidia.utilities.Constantes;
import com.uniandes.stampidia.utilities.Resultado;
import com.uniandes.stampidia.utilities.Status;
import com.uniandes.stampidia.utilities.enums.EStatusType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value="/rest")
public class SpecialOffersController {

    @Autowired
    private OfferService offerService;

    @RequestMapping(value="/specialoffers",method= RequestMethod.POST)
    public Resultado createPromo(
            @RequestBody StmpOfert specialOffer){
        Resultado resultado = new Resultado();

        if(!specialOffer.isNull()){

            StmpOfert newOffer = offerService.saveSpecialOffer(specialOffer);

            if(newOffer != null){
                resultado.setResultado(newOffer);
                resultado.setEstado(new Status(EStatusType.OK, Constantes.SUCCESS_RESULT.getDescription()));
            }else {
                resultado.setEstado(new Status(EStatusType.ERROR, Constantes.ERROR_RESULT.getDescription()));
            }

        }else {
            resultado.setEstado(new Status(EStatusType.ERROR, Constantes.INVALID_PARAMS_RESULT.getDescription()));
        }

        return resultado;
    }

    @RequestMapping(value="/specialoffers",method= RequestMethod.PUT)
    public Resultado updatePromo(
            @RequestBody StmpOfert specialOffer){
        Resultado resultado = new Resultado();

        if(!specialOffer.isNull()){

            StmpOfert newOffer = offerService.saveSpecialOffer(specialOffer);

            if(newOffer != null){
                resultado.setResultado(newOffer);
                resultado.setEstado(new Status(EStatusType.OK, Constantes.SUCCESS_RESULT.getDescription()));
            }else {
                resultado.setEstado(new Status(EStatusType.ERROR, Constantes.ERROR_RESULT.getDescription()));
            }

        }else {
            resultado.setEstado(new Status(EStatusType.ERROR, Constantes.INVALID_PARAMS_RESULT.getDescription()));
        }

        return resultado;
    }

    @RequestMapping(value="/specialoffer/{plan}",method= RequestMethod.GET)
    public Resultado getSpecialOfferAvailable(@PathVariable("plan") String plan){
        Resultado resultado = new Resultado();

        if(plan != null && plan.equals(Constantes.PLAN_BUSSINESS.getDescription())) {

            Object offer = offerService.getActiveSpecialOffer();

            if (offer != null) {
                resultado.setResultado(offer);
                resultado.setEstado(new Status(EStatusType.OK, Constantes.SUCCESS_RESULT.getDescription()));
            } else {
                resultado.setEstado(new Status(EStatusType.ERROR, Constantes.ERROR_RESULT.getDescription()));
            }
        }else{
            resultado.setEstado(new Status(EStatusType.OK, Constantes.SUCCESS_RESULT.getDescription()));
        }

        return resultado;
    }


}
