package com.uniandes.stampidia.controllers;

import com.uniandes.stampidia.model.StmpOrder;
import com.uniandes.stampidia.model.StmpShirt;
import com.uniandes.stampidia.services.CartService;
import com.uniandes.stampidia.utilities.Constantes;
import com.uniandes.stampidia.utilities.Resultado;
import com.uniandes.stampidia.utilities.Status;
import com.uniandes.stampidia.utilities.enums.EStatusType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value="/rest")
public class CartController {

    @Autowired
    private CartService cartService;

    @RequestMapping(value="/cart",method= RequestMethod.PUT)
    public Resultado saveCart(
            @RequestBody StmpOrder order){
        Resultado resultado = new Resultado();

        if(!order.isNull()){
            StmpOrder newOrder = cartService.updateOrder(order);

            if(newOrder != null){
                resultado.setResultado(newOrder);
                resultado.setEstado(new Status(EStatusType.OK, Constantes.SUCCESS_RESULT.getDescription()));
            }else {
                resultado.setEstado(new Status(EStatusType.ERROR, Constantes.ERROR_RESULT.getDescription()));
            }

        }else {
            resultado.setEstado(new Status(EStatusType.ERROR, Constantes.INVALID_PARAMS_RESULT.getDescription()));
        }

        return resultado;
    }

    @RequestMapping(value="/cart/{userId}",method= RequestMethod.GET)
    public Resultado getCartProducts(
            @PathVariable("userId")Integer userId){
        Resultado resultado = new Resultado();

        if(userId != null){
            resultado.setResultado(cartService.getCartProducts(userId));
            resultado.setEstado(new Status(EStatusType.OK, Constantes.SUCCESS_RESULT.getDescription()));
        }else {
            resultado.setEstado(new Status(EStatusType.ERROR, Constantes.INVALID_PARAMS_RESULT.getDescription()));
        }

        return resultado;
    }
}
