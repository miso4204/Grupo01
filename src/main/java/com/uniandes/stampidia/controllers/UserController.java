package com.uniandes.stampidia.controllers;

import com.uniandes.stampidia.model.StmpUser;
import com.uniandes.stampidia.services.UserService;
import com.uniandes.stampidia.utilities.Constantes;
import com.uniandes.stampidia.utilities.Resultado;
import com.uniandes.stampidia.utilities.Status;
import com.uniandes.stampidia.utilities.enums.EStatusType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by SEBASTIAN on 04/04/2015.
 */

@RestController
@RequestMapping(value="/rest")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value="/user/buyer",method= RequestMethod.PUT)
    public Resultado updateBuyerProfile(
            @RequestParam("buyer") StmpUser buyer){
        Resultado resultado = new Resultado();

        if(buyer != null){
            resultado.setResultado(userService.updateBuyerProfile(buyer));

            resultado.setEstado(new Status(EStatusType.OK, Constantes.SUCCESS_RESULT.getDescription()));
        }else{
            resultado.setEstado(new Status(EStatusType.ERROR, Constantes.INVALID_PARAMS_RESULT.getDescription()));
        }

        return resultado;
    }

    @RequestMapping(value="/user/seller",method= RequestMethod.PUT)
    public Resultado updateSellerProfile(
            @RequestParam("seller") StmpUser seller){
        Resultado resultado = new Resultado();

        if(seller != null){
            resultado.setResultado(userService.updateSellerProfile(seller));

            resultado.setEstado(new Status(EStatusType.OK, Constantes.SUCCESS_RESULT.getDescription()));
        }else{
            resultado.setEstado(new Status(EStatusType.ERROR, Constantes.INVALID_PARAMS_RESULT.getDescription()));
        }

        return resultado;
    }
}
