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
        Resultado resultado = null;

        if(orderId != null && shirtId != null){
            cartService.addItemToCart(shirtId, orderId);

            resultado = new Resultado();
            resultado.setEstado(new Status(EStatusType.OK, Constantes.SUCCESS_RESULT.getDescription()));
        }
        // TODO :: implementar en caso de parametros invalidos

        return resultado;
    }

    @RequestMapping(value="/cart/",method= RequestMethod.PUT)
    public Resultado updateCartItems(
            @RequestParam("order")StmpOrder order){
        Resultado resultado = null;

        if(order != null){
            resultado = new Resultado();

            resultado.setResultado(cartService.updateOrder(order));

            resultado.setEstado(new Status(EStatusType.OK, Constantes.SUCCESS_RESULT.getDescription()));
        }
        // TODO :: implementar en caso de parametros invalidos

        return resultado;
    }

    @RequestMapping(value="/cart/{orderId}/item/{shirtId}",method= RequestMethod.DELETE)
    public Resultado deleteItemFromCart(
            @PathVariable("orderId")Integer orderId,
            @PathVariable("shirtId")Integer shirtId){
        Resultado resultado = null;

        if(orderId != null && shirtId != null){
            resultado = new Resultado();

            resultado.setResultado(cartService.deleteItemFromCart(orderId, shirtId));

            resultado.setEstado(new Status(EStatusType.OK, Constantes.SUCCESS_RESULT.getDescription()));
        }
        // TODO :: implementar en caso de parametros invalidos

        return resultado;
    }

    @RequestMapping(value="/cart/{userId}",method= RequestMethod.GET)
    public Resultado getCartProducts(
            @PathVariable("userId")Integer userId){
        Resultado resultado = null;

        if(userId != null){
            resultado = new Resultado();

            resultado.setResultado(cartService.getCartProducts(userId));

            resultado.setEstado(new Status(EStatusType.OK, Constantes.SUCCESS_RESULT.getDescription()));
        }
        // TODO :: implementar en caso de parametros invalidos

        return resultado;
    }
}
