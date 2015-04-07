package com.uniandes.stampidia.controllers;

import com.uniandes.stampidia.model.StmpUser;
import com.uniandes.stampidia.services.UserService;
import com.uniandes.stampidia.utilities.Constantes;
import com.uniandes.stampidia.utilities.Resultado;
import com.uniandes.stampidia.utilities.Status;
import com.uniandes.stampidia.utilities.enums.EStatusType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
            @RequestBody StmpUser buyer){
        Resultado resultado = new Resultado();

        if(buyer != null && buyer.getId() != null){
            resultado.setResultado(userService.updateBuyerProfile(buyer));

            resultado.setEstado(new Status(EStatusType.OK, Constantes.SUCCESS_RESULT.getDescription()));
        }else{
            resultado.setEstado(new Status(EStatusType.ERROR, Constantes.INVALID_PARAMS_RESULT.getDescription()));
        }

        return resultado;
    }

    @RequestMapping(value="/user/seller",method= RequestMethod.PUT)
    public Resultado updateSellerProfile(
            @RequestBody StmpUser seller){
        Resultado resultado = new Resultado();

        if(seller != null && seller.getId() != null){
            resultado.setResultado(userService.updateSellerProfile(seller));

            resultado.setEstado(new Status(EStatusType.OK, Constantes.SUCCESS_RESULT.getDescription()));
        }else{
            resultado.setEstado(new Status(EStatusType.ERROR, Constantes.INVALID_PARAMS_RESULT.getDescription()));
        }

        return resultado;
    }
    
    @RequestMapping(value="/user/buyer",method= RequestMethod.POST)
    public Resultado createBuyerProfile(
            @RequestParam("username") String username,
            @RequestParam("username") String password,
            @RequestParam("email") String email,
            @RequestParam("facebook_email") String face,
            @RequestParam("twitter_email") String twitter,
            @RequestParam("is_seller") boolean isSeller,
            @RequestParam("status") boolean status){
        Resultado resultado = new Resultado();

        if(username != null){
        	StmpUser user = new StmpUser(null, username, password, email, isSeller, status);
        	user.setFacebookEmail(face);
        	user.setTwitterEmail(twitter);
        	user.setIsSeller(isSeller);
        	user.setStatus(status);
        	
            resultado.setResultado(userService.createProfile(user));

            resultado.setEstado(new Status(EStatusType.OK, Constantes.SUCCESS_RESULT.getDescription()));
        }else{
            resultado.setEstado(new Status(EStatusType.ERROR, Constantes.INVALID_PARAMS_RESULT.getDescription()));
        }

        return resultado;
    }

}