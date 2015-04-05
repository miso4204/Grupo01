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

    @RequestMapping(value="/cart/{orderId}/shirt/{shirtId}",method= RequestMethod.PUT)
    public Resultado addItemToCart(
            @PathVariable("orderId")Integer orderId,
            @PathVariable("shirtId")Integer shirtId){
        Resultado resultado = new Resultado();

        if(orderId != null && shirtId != null){
            cartService.addItemToCart(shirtId, orderId);

            resultado.setEstado(new Status(EStatusType.OK, Constantes.SUCCESS_RESULT.getDescription()));
        }else {
            resultado.setEstado(new Status(EStatusType.ERROR, Constantes.INVALID_PARAMS_RESULT.getDescription()));
        }

        return resultado;
    }

    @RequestMapping(value="/cart/",method= RequestMethod.PUT)
    public Resultado updateCartItems(
            @RequestParam("order")StmpOrder order){
        Resultado resultado = new Resultado();

        if(order != null){
            resultado.setResultado(cartService.updateOrder(order));

            resultado.setEstado(new Status(EStatusType.OK, Constantes.SUCCESS_RESULT.getDescription()));
        }else {
            resultado.setEstado(new Status(EStatusType.ERROR, Constantes.INVALID_PARAMS_RESULT.getDescription()));
        }

        return resultado;
    }

    @RequestMapping(value="/cart/{orderId}/item/{shirtId}",method= RequestMethod.DELETE)
    public Resultado deleteItemFromCart(
            @PathVariable("orderId")Integer orderId,
            @PathVariable("shirtId")Integer shirtId){
        Resultado resultado = new Resultado();

        if(orderId != null && shirtId != null){
            resultado.setResultado(cartService.deleteItemFromCart(orderId, shirtId));

            resultado.setEstado(new Status(EStatusType.OK, Constantes.SUCCESS_RESULT.getDescription()));
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
